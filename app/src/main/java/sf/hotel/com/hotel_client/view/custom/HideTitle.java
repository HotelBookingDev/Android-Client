package sf.hotel.com.hotel_client.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.utils.transulcent.TransulcentUtils;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/30.
 */
public class HideTitle extends LinearLayout {

    ImageView leftImg;
    TextView midText;
    ImageView rightImg1;
    ImageView rightImg2;
    LinearLayout rightLinearLayout;
    NoScrollView scrollView;
    boolean isStatusView;

    View statusView;
    RelativeLayout belowLayout;


    int colorA = 0;
    int colorR = 0;
    int colorG = 0;
    int colorB = 0;


    String RGB = "#000000";

    RelativeLayout.LayoutParams leftImgParams, rightParams, midTextParams ;
    LinearLayout.LayoutParams rightImgParams1, rightImgParams2,statusViewParams, belowLayoutParams;

    int leftImgResId;
    int rightImgResId1, rightImgResId2;
    String midString = "";


    public void setScrollView(NoScrollView scrollView, int height) {
        this.scrollView = scrollView;

        scrollView.setOnScrollListener(new NoScrollView.onScrollListener() {
            @Override
            public void onScroll(View view, int x, int y, int oldX, int oldY) {
                if(y < height){
                    float alpha = y / (float)height;
                    if (alpha < 0)
                        alpha = 0;
                    if (alpha > 1)
                        alpha = 1;
                    setViewAlpha(alpha);
                }
            }
        });
    }


    public void setColorRGB(int A, int R, int G, int B){
        colorA = A;
        colorR = R;
        colorG = G;
        colorB = B;
    }

    public void setColorWithHex(String s){
        int i = Color.parseColor(s);
    }


    public HideTitle(Context context) {
        this(context, null);
    }

    public HideTitle(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HideTitle);

        leftImgResId = ta.getResourceId(R.styleable.HideTitle_left_img, 0);
        rightImgResId1 = ta.getResourceId(R.styleable.HideTitle_right_img1, 0);
        rightImgResId2 = ta.getResourceId(R.styleable.HideTitle_right_img2, 0);
        midString = ta.getString(R.styleable.HideTitle_mid_text);
        isStatusView = ta.getBoolean(R.styleable.HideTitle_add_status_view, true);

        ta.recycle();

        initView();
    }

    public void setViewAlpha(float alpha){
        int a = (int) (255 * alpha);
        setBackgroundColor(Color.argb(a, colorR, colorB, colorG));
        //Drawable drawable = Draw
    }

    private void initView() {
        setClickable(false);
        setOrientation(VERTICAL);
        setViewAlpha(0);

        if (isStatusView)
            addStatusView();

        addBelowView();
        addLeftView();
        addMidView();
        addRightView();
    }

    private void addStatusView() {
        if (statusView == null){
            statusView = new View(getContext());
            statusViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , TransulcentUtils.getStatusBarHeight(getContext()));
        }
        addView(statusView, statusViewParams);
    }

    private void addBelowView() {
        if (belowLayout == null){
            belowLayout = new RelativeLayout(getContext());
            int titleHeight = getContext().getResources().getDimensionPixelOffset(R.dimen.title_height);
            belowLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , titleHeight);
        }
        addView(belowLayout, belowLayoutParams);
    }

    private void addRightView() {

        if (rightLinearLayout == null){
            rightLinearLayout = new LinearLayout(getContext());
            rightParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            rightParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                rightParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
            }
            rightLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            rightImg1 = new ImageView(getContext());
            rightImgParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rightImg1.setBackgroundResource(rightImgResId1);
            rightLinearLayout.addView(rightImg1, rightImgParams1);

            rightImg2 = new ImageView(getContext());
            rightImgParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rightImg2.setBackgroundResource(rightImgResId2);
            rightLinearLayout.addView(rightImg2, rightImgParams2);

        }
        belowLayout.addView(rightLinearLayout, rightParams);
    }



    private void addMidView() {
        if (midText == null){
            midText = new TextView(getContext());
            midTextParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            midTextParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            midText.setText(midText.getText());
        }
        belowLayout.addView(midText, midTextParams);
    }

    private void addLeftView() {
        if (leftImg == null){
            leftImg = new ImageView(getContext());
            leftImgParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            leftImgParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            leftImgParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                leftImgParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
            }
            leftImg.setBackgroundResource(leftImgResId);
        }
        belowLayout.addView(leftImg, leftImgParams);
    }


    public void addLeftViewOnClickListener(OnClickListener onClickListener){
        if (!leftImg.isClickable())
            leftImg.setClickable(true);
        leftImg.setOnClickListener(onClickListener);
    }


    public void addRightView1OnClickListener(OnClickListener onClickListener){
        if (!rightImg1.isClickable())
            rightImg1.setClickable(true);
        rightImg1.setOnClickListener(onClickListener);
    }

    public void addRightView2OnClickListener(OnClickListener onClickListener){
        if (!rightImg2.isClickable())
            rightImg2.setClickable(true);
        rightImg2.setOnClickListener(onClickListener);
    }

    public void setMidText(String midString){
        midText.setText(midString);
    }
}
