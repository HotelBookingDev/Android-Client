package sf.hotel.com.hotel_client.view.event.person;

import sf.hotel.com.hotel_client.view.event.Message;

/**
 * Created by 林其望
 * data：2016/6/28
 * email: 1105896230@qq.com
 */
public class OrderMessage extends Message {

    public static final int SEARCHMESSAGE = 2;
    public static final int ALREADYCONSUMED = 3;
    public static final int NOTCONSUMED = 4;

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
