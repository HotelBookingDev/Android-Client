package sf.hotel.com.hotel_client.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import sf.hotel.com.hotel_client.R;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/16.
 */
public class DetailPullViewAdapter extends RecyclerViewBaseAdapter<DetailPullViewAdapter.ViewHolder> {

    private OnItemClickListener mOnItemClickListener;

    public DetailPullViewAdapter(Context context) {
        super(context);
    }


    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_room, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.mTitle.setText("hahha");
//        holder.mPrice.setText("$ 1111");
//
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //ImageView mImage;

        TextView mTitle;
        TextView mPrice;
        TextView mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            // mImage = (ImageView) itemView.findViewById(R.id.ite);
            mTitle = (TextView) itemView.findViewById(R.id.item_room_title);
            mPrice = (TextView) itemView.findViewById(R.id.item_room_price);
            mContext = (TextView) itemView.findViewById(R.id.item_room_content);
        }
    }
}
