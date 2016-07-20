package sf.hotel.com.hotel_client.view.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import mehdi.sakout.fancybuttons.FancyButton;
import sf.hotel.com.hotel_client.R;

/**
 * Created by 林其望
 * data：2016/7/18
 * email: 1105896230@qq.com
 */
public class PayBottomView extends PopupWindow {

    PayView payView;

    public PayBottomView(Context context, PayView.PayClick click) {
        super(context);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        payView = new PayView(context, click);
        init();
    }

    private void init() {

        setContentView(payView.getRootView());
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setAnimationStyle(R.style.pay_menu_animation);

    }

}
