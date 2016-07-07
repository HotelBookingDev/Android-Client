package sf.hotel.com.hotel_client.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sf.hotel.com.data.entity.netresult.hotel.HotelsBean;
import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.utils.HotelImageLoad;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/13.
 */
public class HomePullViewAdapter extends RecyclerViewBaseAdapter<HomePullViewAdapter.ViewHolder> {

    private List<HotelsBean> mList = new ArrayList<>();

    public void setList(List<HotelsBean> hotelList) {
        mList = hotelList;
        setCount(mList.size());
        this.notifyDataSetChanged();
    }

    public HotelsBean getItemByPos(int pos) {
        return mList.get(pos);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public HomePullViewAdapter(Context context) {
        super(context);
        setCount(mList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_hotels, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HotelsBean hotelsBean = mList.get(position);

        holder.mTitle.setText(hotelsBean.getName());

        holder.mTextContent.setText(hotelsBean.getAddress());

        if (hotelsBean.getHotel_imgs() != null && hotelsBean.getHotel_imgs().size() > 0){
            HotelImageLoad.loadImage(mContext, holder.mImage, hotelsBean
                    .getHotel_imgs()
                    .get(0));
        }else {
            HotelImageLoad.loadImage(mContext, holder.mImage, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3256474343,2114829206&fm=23&gp=0.jpg");
        }

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
        ImageView mImage;
        TextView mTitle, mTextContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.item_hotels_img);
            mTitle = (TextView) itemView.findViewById(R.id.item_hotels_name);
            mTextContent = (TextView) itemView.findViewById(R.id.item_hotels_content);
        }
    }
}
