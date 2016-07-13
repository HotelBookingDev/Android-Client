package sf.hotel.com.hotel_client.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sf.hotel.com.data.entity.Order;
import sf.hotel.com.hotel_client.R;

/**
 * Created by 林其望
 * data：2016/7/4
 * email: 1105896230@qq.com
 */
public class UserOrderAdapter extends RecyclerViewBaseAdapter {
    List<Order> mOrders;
    UserOrderClick mUserOrderClick;

    public UserOrderAdapter(Context context, List<Order> mOrders) {
        super(context);
        this.mOrders = mOrders;
        setCount(mOrders.size());
    }

    public void setmUserOrderClick(UserOrderClick mUserOrderClick) {
        this.mUserOrderClick = mUserOrderClick;
    }

    public void setOrders(List<Order> orders) {
        if (orders == null) return;
        mOrders.clear();
        mOrders.addAll(orders);
        setCount(mOrders.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Order order = mOrders.get(position);
        if (order == null || order.getHotelShot() == null) return;
        setText(order.getHotelShot().getHotel_name(), viewHolder.mHotelName);
        setText(order.getTime() + "", viewHolder.mTime);
        setText(order.getHotelShot().getHouse_name(), viewHolder.mRoomName);
        setText(order.getHotelShot().getFron_price() + "", viewHolder.mRoomMoney);
        setState(order, viewHolder.mSateTxt);
        viewHolder.mSateTxt.getRootView().setOnClickListener(v -> {
            if (mUserOrderClick != null) mUserOrderClick.click(order);
        });
    }

    private void setText(String text, TextView view) {
        if (!TextUtils.isEmpty(text)) {
            view.setText(text);
        }
    }

    private void setState(Order order, TextView textView) {
        textView.setText(order.getStateMessage());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHotelIcon;
        TextView mHotelName;
        TextView mTime;
        TextView mRoomName;
        TextView mRoomMoney;
        TextView mSateTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            mHotelIcon = (ImageView) itemView.findViewById(R.id.iv_hotel);
            mHotelName = (TextView) itemView.findViewById(R.id.tv_hotel);
            mTime = (TextView) itemView.findViewById(R.id.tv_time);
            mRoomMoney = (TextView) itemView.findViewById(R.id.tv_money);
            mRoomName = (TextView) itemView.findViewById(R.id.tv_room);
            mSateTxt = (TextView) itemView.findViewById(R.id.tv_state);
        }
    }

    public interface UserOrderClick {
        void click(Order order);
    }
}
