package sf.hotel.com.hotel_client.view.event.hotel.person;

import sf.hotel.com.hotel_client.view.event.hotel.Message;

/**
 * Created by 林其望
 * data：2016/6/28
 * email: 1105896230@qq.com
 */
public class OrderMessage extends Message {

    public static final  int SEARCHMESSAGE=2;
    public OrderMessage(int what) {
        super(what);
    }

    public OrderMessage(String message, int what) {
        super(message, what);
    }

    public OrderMessage(int what, String message, Object obj) {
        super(what, message, obj);
    }
}
