package sf.hotel.com.hotel_client.view.event.hotel;


/**
 * Created by 林其望 on 2016/6/17.
 */
public class Message {

    public int what;
    public String message;
    public Object obj;


    public Message(int what) {
        this.what = what;
    }

    public Message(String message, int what) {
        this.message = message;
        this.what = what;
    }

    public Message(int what, String message, Object obj) {
        this.what = what;
        this.message = message;
        this.obj = obj;
    }
}
