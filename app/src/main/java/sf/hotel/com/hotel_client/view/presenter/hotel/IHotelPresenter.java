package sf.hotel.com.hotel_client.view.presenter.hotel;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import sf.hotel.com.data.entity.netresult.HotelResult;
import sf.hotel.com.data.interfaceeneity.HotelsEntityImp;
import sf.hotel.com.data.net.callback.SimpleSubscriber;
import sf.hotel.com.hotel_client.view.event.RxBus;
import sf.hotel.com.hotel_client.view.event.hotel.HotelListMsg;
import sf.hotel.com.hotel_client.view.event.hotel.MessageFactory;
import sf.hotel.com.hotel_client.view.interfaceview.hotel.IHotelsView;
import sf.hotel.com.hotel_client.view.presenter.SuperPresenter;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/13.
 */
public class IHotelPresenter extends SuperPresenter {

    IHotelsView mIHotelsView;

    HotelsEntityImp mHotelsEntity;

    CompositeSubscription mCompositeSubscription;

    public IHotelPresenter(IHotelsView mIHotelsView) {
        this.mIHotelsView = mIHotelsView;
        mHotelsEntity = new HotelsEntityImp();
        mCompositeSubscription = new CompositeSubscription();
    }

    public void loadMoreHotel() {

    }



    public void callHotelsByCityId(String cityId){
        Subscription subscribe = mHotelsEntity.callHotelsByCityId(cityId).subscribe(new SimpleSubscriber<HotelResult>(mIHotelsView.getBottomContext()) {
            @Override
            public void onNext(HotelResult hotelResult) {
                super.onNext(hotelResult);
                RxBus.getDefault().post(MessageFactory.createHotelListMsg(HotelListMsg.SUCCESS, hotelResult));
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                RxBus.getDefault().post(MessageFactory.createHotelListMsg(HotelListMsg.FAILE, e));
            }
        });

        mCompositeSubscription.add(subscribe);
    }


    @Override
    public void destroy() {
        if (mHotelsEntity != null){
            mHotelsEntity = null;
        }

        if (!mCompositeSubscription.isUnsubscribed()){
            mCompositeSubscription.unsubscribe();
        }
    }
}
