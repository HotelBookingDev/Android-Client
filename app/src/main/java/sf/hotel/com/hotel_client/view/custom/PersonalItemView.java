package sf.hotel.com.hotel_client.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.utils.HotelImageLoad;

/**
 * Created by 林其望
 * data：2016/6/16
 * email: 1105896230@qq.com
 */
//用于用户Fragment下的item
public class PersonalItemView extends FrameLayout {

    private ImageView mIconRightView;

    private int defaultIcon = R.mipmap.ic_launcher;
    private String showString;
    private String rightString;

    public PersonalItemView(Context context) {
        this(context, null);
    }

    public PersonalItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PersonalItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.PersonalItemView, 0, 0);
        try {
            defaultIcon = a.getResourceId(R.styleable.PersonalItemView_leftIcon, defaultIcon);
            showString = a.getString(R.styleable.PersonalItemView_contextText);
            rightString = a.getString(R.styleable.PersonalItemView_rightText);
        } finally {
            a.recycle();
        }
        initViews(context);
    }

    private void initViews(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_person, this);
        ImageView mIconView = (ImageView) inflate.findViewById(R.id.iv_item_persion);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_item_persion_content);
        String defaultString = "PensionItemView";
        textView.setText(defaultString);
        if (!TextUtils.isEmpty(showString)) {
            textView.setText(showString);
        }

        HotelImageLoad.loadImage(context, mIconView, defaultIcon);
        if (defaultIcon == R.mipmap.ic_launcher) {
            mIconView.setVisibility(GONE);
        }
//        加载右侧的文字描述
        if (!TextUtils.isEmpty(rightString)) {
            TextView tv_right = (TextView) inflate.findViewById(R.id.tv_right);
            tv_right.setVisibility(VISIBLE);
            tv_right.setText(rightString);
        }
    }
}
