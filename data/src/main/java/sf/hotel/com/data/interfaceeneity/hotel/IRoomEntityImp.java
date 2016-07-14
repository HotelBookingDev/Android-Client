package sf.hotel.com.data.interfaceeneity.hotel;


import rx.Observable;
import sf.hotel.com.data.entity.HotelBookResult;
import sf.hotel.com.data.entity.netresult.hotel.HotelsBean;
import sf.hotel.com.data.net.ApiWrapper;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/7/12.
 */
public class IRoomEntityImp implements RoomEntity{


    /**
     * @param id hotel的id
     * @return
     */
    public Observable<HotelsBean> callHotelBean(String id){
        return ApiWrapper.getInstance().callHotelBean(id);
    }


    /**
     *
     * @param auth 授权
     * @param productId 商品id
     * @param inTime 开始时间
     * @param outTime 结束时间
     * @return
     */
    public Observable<HotelBookResult> callHotelBook(String auth, String productId, String inTime, String outTime){
        return ApiWrapper.getInstance().callHotelBook(auth, productId, inTime, outTime);
    }

}