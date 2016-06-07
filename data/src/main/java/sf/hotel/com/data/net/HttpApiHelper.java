package sf.hotel.com.data.net;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import sf.hotel.com.data.entity.HttpResult;
import sf.hotel.com.data.net.Exception.APIException;
import sf.hotel.com.data.net.Interceptor.LoggingInterceptor;

/**
 * Created by sanfen on 16/6/6.
 */
public abstract class HttpApiHelper {

    private static final int DEFAULT_TIMEOUT = 5;

    public Retrofit mRetrofit;
    public OkHttpClient mOkhttpClient;


    public void init(String APIHOST) {
        //初始化
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())  // 日志拦截器
                ;
        mOkhttpClient = builder.build();


        Retrofit.Builder mRetrofitBuilde = new Retrofit.Builder()
                .client(mOkhttpClient)
                .baseUrl(APIHOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        mRetrofit = mRetrofitBuilde.build();
    }

    /**
     * 对网络接口返回的httpResult进行分割操作
     *
     * @param httpResult
     * @param <T>
     * @return
     */
    public <T> Observable<T> flatResponse(final HttpResult<T> httpResult) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (httpResult.isSuccess()) {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(httpResult.getData());
                    }
                } else {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(new APIException(httpResult.getCode()
                                , httpResult.getMessage()));
                    }
                    return;
                }

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }

            }
        });
    }

    protected <T> Observable.Transformer<HttpResult<T>, T> applySchedulers() {
        return (Observable.Transformer<HttpResult<T>, T>) transformer;
    }

    final Observable.Transformer transformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Func1() {
                        @Override
                        public Object call(Object httpResult) {
                            return flatResponse((HttpResult<Object>) httpResult);
                        }
                    })
                    ;
        }
    };

    public Map<String, String> defaultQueryMap() {
        Map<String, String> queryMap = new HashMap<>();

        //queryMap.put("app_ver", "1.0.1");
       // queryMap.put("sdk_ver", "6.0.1");

        return queryMap;
    }

}
