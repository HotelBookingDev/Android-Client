package sf.hotel.com.hotel_client.view.interfaceview.login;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/7.
 */
public interface IRegisterView extends ILRConmView {

    void register();

    void callPhoneCaptcha();

    String getCaptcha();

    void startTimer();
}
