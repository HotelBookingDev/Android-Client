package sf.hotel.com.data.net;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import sf.hotel.com.data.entity.HotelBookResult;
import sf.hotel.com.data.entity.Intallation;
import sf.hotel.com.data.entity.ProvincesResult;
import sf.hotel.com.data.entity.netresult.HotelResult;
import sf.hotel.com.data.entity.netresult.HttpResult;
import sf.hotel.com.data.entity.netresult.LoginResult;
import sf.hotel.com.data.entity.netresult.NormalResult;
import sf.hotel.com.data.entity.netresult.TokenResult;
import sf.hotel.com.data.entity.netresult.hotel.room.RoomResult;
import sf.hotel.com.data.entity.netresult.pay.PayResult;
import sf.hotel.com.data.entity.netresult.person.OrderListsResult;
import sf.hotel.com.data.entity.netresult.person.OrderReuslt;

import static sf.hotel.com.data.net.HttpParam.*;


/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/6.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST(AppUrl.LOGIN)
    Observable<HttpResult<LoginResult>> callLogin(@Field(PHONE_NUMBER) String phone,
                                                  @Field(HttpParam.SMS_CODE) String code);

    @FormUrlEncoded
    @POST(AppUrl.REGISTER_URL)
    Observable<HttpResult<LoginResult>> callRegister(@Field(PHONE_NUMBER) String phone,
                                                     @Field(SMS_CODE) String smsCode);

    @FormUrlEncoded
    @POST(AppUrl.SMS_URL)
    Observable<HttpResult<NormalResult>> callSmsCode(@Field(PHONE_NUMBER) String phone);

    @FormUrlEncoded
    @POST(AppUrl.LOGIN_SMS_URL)
    Observable<HttpResult<NormalResult>> callSmsCodeByLogin(@Field(PHONE_NUMBER) String phone);

    //绑定
    @FormUrlEncoded
    @POST(AppUrl.INSTALLATIONS_BIND_URL)
    Observable<HttpResult<NormalResult>> postInstallation(@Field(DEVICE_TYPE) String type,
                                                          @Field(PHONE_NUMBER) String phoneNum,
                                                          @Field(INSTALLATION_CODE) String installation_code);

    //上传设备号
    @POST(AppUrl.INSTALLATION_URL)
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Observable<HttpResult<NormalResult>> postIntallation(@Body Intallation mIntallation);

    @GET(AppUrl.HOTELS_URL)
    Observable<HttpResult<HotelResult>> callHotelsByCityId(@Query(CITY_ID) String cityId,
                                                           @Query(PAGE) String page,
                                                           @Query(CHECK_IN_TIME) String in,
                                                           @Query(CHECK_OUT_TIME) String out,
                                                           @Query(EXCLUDE) String exclude);

    @FormUrlEncoded
    @POST(AppUrl.ROOMPACKAGE + "{productId}/book/")
    Observable<HttpResult<HotelBookResult>> callHotelBook(@Path(PRODUCTID) String productId,
                                                          @Field(CHECK_IN_TIME) String inTime,
                                                          @Field(CHECK_OUT_TIME) String outTime,
                                                          @Field(GUESTS) String guests,
                                                          @Field(PRICE_TYPE) String priceType);

    @GET("hotel/{id}")
    Observable<HttpResult<RoomResult>> callHotelBeanById(@Path("id") String id,
                                                         @Query(CHECK_IN_TIME) String inTime,
                                                         @Query(CHECK_OUT_TIME) String outTime,
                                                         @Query(EXCLUDE) String exclude);

    //获取TOKEN
    @GET(AppUrl.TOKEN_URL)
    Observable<HttpResult<TokenResult>> getTokenResult();

    @GET(AppUrl.PROVINCES_URL)
    Observable<HttpResult<ProvincesResult>> callCityList();

    @GET(AppUrl.ORDER_URL)
    Observable<HttpResult<OrderListsResult>> getOrders(@Query(HttpParam.PROCESS_SATE) int postion, @Query(HttpParam.PAGE) int page);

    @GET(AppUrl.ORDER_URL)
    Observable<HttpResult<OrderListsResult>> getClosedOrders(@Query(HttpParam.COLSED) String closed, @Query(HttpParam.PAGE) int page);

    @FormUrlEncoded
    @POST(AppUrl.CHANGEPWD_URL)
    Observable<HttpResult<NormalResult>> putChangePwd(@Field(PHONE_NUMBER) String phoneNum,
                                                      @Field(PASSWORD) String password, @Field(HttpParam.NEWPASSWORD) String newPassword);

    @GET(AppUrl.DELETE_URL + "{number}" + "/" + "cancel")
    Observable<HttpResult<OrderReuslt>> deleteOrder(@Path(NUMBER) long number);


    @GET(AppUrl.PAY_URL)
    Observable<HttpResult<PayResult>> callPay(@Query(POINT) String point);

    @FormUrlEncoded
    @POST(AppUrl.CHECK_TOKEN)
    Observable<HttpResult<NormalResult>> checkToken(@Field(PHONE_NUMBER) String phoneNum, @Field(TOKEN) String token);

    @FormUrlEncoded
    @PUT(AppUrl.PROFILE)
    Observable<HttpResult<LoginResult>> putUserInfo(@Field(SEX) int sex, @Field(NAME) String name);
}
