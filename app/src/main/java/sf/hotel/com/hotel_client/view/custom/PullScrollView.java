package sf.hotel.com.hotel_client.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import sf.hotel.com.hotel_client.utils.DensityUtils;


/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/7/6.
 */
public class PullScrollView extends FrameLayout {

    private FrameLayout mHeaderContainer;
    private NoScrollView mContentContainer;

    private FrameLayout mContentView;


    private int hideHeight;

    public interface HideHeardListener{
        void onHideView(float alpha);
    }


    HideHeardListener mHideHeardListener = new HideHeardListener() {
        @Override
        public void onHideView(float alpha) {
            mHeaderContainer.setAlpha(alpha);
        }
    };

    public void setHideHeardListener(HideHeardListener mHideHeardListener) {
        this.mHideHeardListener = mHideHeardListener;
    }

    private LayoutParams mHeaderParams, mContentParams,mContentViewParams;

    public PullScrollView(Context context) {
        this(context, null);
    }

    public PullScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

        hideHeight = DensityUtils.dp2px(context, 200);
        initView();
    }

    private void initView() {
        mHeaderContainer = new FrameLayout(getContext());
        mHeaderParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(mHeaderContainer, mHeaderParams);

        mContentContainer = new NoScrollView(getContext());
        mContentParams =  new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mContentView = new FrameLayout(getContext());
        mContentViewParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentContainer.addView(mContentView, mContentViewParams);

        addView(mContentContainer, mContentParams);


        mHeaderContainer.bringToFront();

        mContentContainer.setOnScrollListener(new NoScrollView.onScrollListener() {
            @Override
            public void onScroll(View view, int x, int y, int oldX, int oldY) {
                int curr = y - 1500;

                if(curr < hideHeight){
                    float alpha = curr / (float)hideHeight;
                    if (alpha < 0)
                        alpha = 0;
                    if (alpha > 1)
                        alpha = 1;
                    mHideHeardListener.onHideView(alpha);
                }
            }
        });
    }


    public void addHeaderView(View view){
        mHeaderContainer.removeAllViews();
        mHeaderContainer.addView(view);
    }


    public void addContentView(View view){
        mContentView.removeAllViews();
        mContentView.addView(view);
    }


}