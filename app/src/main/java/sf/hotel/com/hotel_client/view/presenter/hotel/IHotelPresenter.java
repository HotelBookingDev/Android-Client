package sf.hotel.com.hotel_client.view.presenter.hotel;

import sf.hotel.com.data.interfaceeneity.HotelsEntityImp;
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

    public IHotelPresenter(IHotelsView mIHotelsView) {
        this.mIHotelsView = mIHotelsView;
        mHotelsEntity = new HotelsEntityImp();
    }

    public void loadMoreHotel() {

    }

    @Override
    public void destroy() {

    }
}