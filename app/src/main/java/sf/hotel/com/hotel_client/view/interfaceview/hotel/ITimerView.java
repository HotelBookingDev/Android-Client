package sf.hotel.com.hotel_client.view.interfaceview.hotel;

import sf.hotel.com.data.entity.SearchItem;
import sf.hotel.com.hotel_client.view.interfaceview.BaseView;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/7/18.
 */
public interface ITimerView extends BaseView {

    SearchItem getSearchItem();

    void setSearchItem(SearchItem searchItem);
}
