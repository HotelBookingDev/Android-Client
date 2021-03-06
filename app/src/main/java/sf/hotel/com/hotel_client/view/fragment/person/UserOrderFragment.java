package sf.hotel.com.hotel_client.view.fragment.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import sf.hotel.com.data.entity.Order;
import sf.hotel.com.data.utils.LogUtils;
import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.view.adapter.UserOrderAdapter;
import sf.hotel.com.hotel_client.view.custom.HotelRefreshHotelView;
import sf.hotel.com.hotel_client.view.event.RxBus;
import sf.hotel.com.hotel_client.view.event.person.OrderMessage;
import sf.hotel.com.hotel_client.view.fragment.BaseFragment;
import sf.hotel.com.hotel_client.view.interfaceview.person.IUserOrderView;
import sf.hotel.com.hotel_client.view.presenter.person.UserOrderPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserOrderFragment extends BaseFragment implements IUserOrderView {

    private static final String PUSH_ORDER = "com.pushHotel.action";

    private UserOrderPresenter mUserOrderPresenter;

    public static UserOrderFragment newInstance() {

        Bundle args = new Bundle();

        UserOrderFragment fragment = new UserOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @BindView(R.id.rv_order)
    RecyclerView mRecycleView;

    @BindView(R.id.swipe_refresh)
    HotelRefreshHotelView refreshHotelView;
    private boolean isRegisterReceiver = false;
    //    判断当前的订单列表该显示那个
    private int position;

    private UserOrderAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userd_order, container, false);
        ButterKnife.bind(this, view);
        position = OrderMessage.PENDING_CONFIRMATION;
        initRefreshView();
        mUserOrderPresenter = new UserOrderPresenter(this);
//        根据你需要的订单来获取
        mUserOrderPresenter.getDatas(position);
        registerReceiver();
        initRxevent();
        return view;
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(PUSH_ORDER);
        getActivity().registerReceiver(receiver, filter);
        isRegisterReceiver = true;
    }

    private void unregisterReceiver() {
        if (isRegisterReceiver) getActivity().unregisterReceiver(receiver);
    }

    private void initRefreshView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getBottomContext(),
                LinearLayoutManager.VERTICAL, false));
        refreshHotelView.setmRefresh(new HotelRefreshHotelView.refresh() {
            @Override
            public void loadMore() {
                mUserOrderPresenter.pullMoreData(UserOrderFragment.this.getPosition());
            }

            @Override
            public void refresh() {
                mUserOrderPresenter.refresh(UserOrderFragment.this.getPosition());
            }
        });
    }

    private void initRxevent() {
        Subscription subscribe = RxBus.getDefault()
                .toObservable(OrderMessage.class)
                .subscribe(orderMessage -> {
                    if (orderMessage == null) return;
                    position = orderMessage.what;
                    if (orderMessage.what != sf.hotel.com.hotel_client.view.event.Message.ISEXIT) {
                        mUserOrderPresenter.getDatas(position);
                    }
                }, LogUtils::logThrowadle);
        addSubscription(subscribe);
    }

    @Override
    public void showOrder(List<Order> mOrders) {
        if (mOrders == null) return;
        if (mAdapter == null) {
            mAdapter = new UserOrderAdapter(getActivity(), mOrders);
            mAdapter.setmUserOrderClick(this::showDialog);
            mRecycleView.setAdapter(mAdapter);
        } else {
            mAdapter.setOrders(mOrders);
        }
        //加载更多
        mAdapter.notifyDataSetChanged();
        mAdapter.setCount(mOrders.size());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
        if (mUserOrderPresenter != null)
            mUserOrderPresenter.destroy();
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void pullViewComplete() {
        refreshHotelView.finsh();
    }

    private void showDialog(Order order) {
        if (order.isClosed()) return;
        AlertDialog.Builder builder = new AlertDialog.Builder(getBottomContext());
        builder.setMessage("确认取消订单吗?");
        builder.setTitle("取消订单");
        builder.setPositiveButton("确认", (dialog, which) -> {
            mUserOrderPresenter.detect(order);
        });
        builder.setNegativeButton("取消", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(PUSH_ORDER)) {
                mUserOrderPresenter.refresh(getPosition());
                try {
                    JSONObject json = new JSONObject(
                            intent.getExtras().getString("com.avos.avoscloud.Data"));
                    String order = json.getString("order");
                    mUserOrderPresenter.updateOrder(order, position);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
