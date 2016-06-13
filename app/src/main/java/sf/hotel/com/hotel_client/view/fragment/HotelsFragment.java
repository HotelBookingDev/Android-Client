package sf.hotel.com.hotel_client.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.lhh.ptrrv.library.footer.loadmore.BaseLoadMoreView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.view.adapter.PullToRefreshViewAdapter;
import sf.hotel.com.hotel_client.view.custom.DividerItemDecoration;
import sf.hotel.com.hotel_client.view.interfaceview.IHotelsView;
import sf.hotel.com.hotel_client.view.presenter.IHotelPresenter;


/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/13.
 */
public class HotelsFragment extends BaseFragment implements IHotelsView{

    @BindView(R.id.fragment_hotels_list)
    PullToRefreshRecyclerView mPullView;


    PullToRefreshViewAdapter mPullAdapter;

    private IHotelPresenter mIHotelPersentes;

    Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        ButterKnife.bind(this,view);

        mIHotelPersentes = new IHotelPresenter(this);

        initPullView();
        return view;
    }

    private void initPullView() {
        mPullView.setSwipeEnable(true);


        View header = LayoutInflater.from(getBottomContext()).inflate(R.layout.custom_title, null);
        mPullView.addHeaderView(header);

        //加载更多
        mPullView.setLayoutManager(new LinearLayoutManager(getBottomContext()));
        mPullView.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener(){
            @Override
            public void onLoadMoreItems() {
                mIHotelPersentes.loadMoreHotel();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPullAdapter.setCount(mPullAdapter.getItemCount() + 20);
                        mPullAdapter.notifyDataSetChanged();
                        mPullView.onFinishLoading(true, false);
                    }
                });
            }
        });


        //设置间隔线
        mPullView.getRecyclerView().addItemDecoration(new DividerItemDecoration(getBottomContext(),
                DividerItemDecoration.VERTICAL_LIST));


        //设置上拉加载
        BaseLoadMoreView loadMoreView = new BaseLoadMoreView(getBottomContext(), mPullView.getRecyclerView());
        mPullView.setLoadMoreFooter(loadMoreView);
        mPullView.setLoadMoreCount(10);

        //刷新
        mPullView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        mPullAdapter.setCount(20);
                        mPullAdapter.notifyDataSetChanged();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mPullView.setOnRefreshComplete();
                        mPullView.onFinishLoading(true, false);
                    }
                });
            }
        });


        //设置适配器
        mPullAdapter = new PullToRefreshViewAdapter(getBottomContext());
        mPullAdapter.setCount(20);

        mPullView.setAdapter(mPullAdapter);
        mPullView.onFinishLoading(true, false);

    }


    @Override
    public Context getBottomContext() {
        return getActivity();
    }

    @Override
    public void showViewToast(String msg) {
        showToast(msg);
    }

    @Override
    public void success(int type) {

    }

    @Override
    public void failed(int type, Throwable e) {

    }
}