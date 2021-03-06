package sf.hotel.com.hotel_client.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.utils.HotelImageLoad;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/6/17.
 */
public class RoomRecyclerPagerAdapter
        extends RecyclerViewBaseAdapter<RoomRecyclerPagerAdapter.ViewHolder> {

    List<String> mList = new ArrayList<>();

    public RoomRecyclerPagerAdapter(Context context) {
        super(context);
        mList.add("");
        setCount(mList.size());
    }

    public void setList(List<String> list) {
        if (list != null && list.size() > 0) {
            mList.clear();
            mList.addAll(list);
            setCount(mList.size());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_room_pager, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HotelImageLoad.loadImage(mContext, holder.mImage, mList.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.item_room_pager_img);
        }
    }
}
