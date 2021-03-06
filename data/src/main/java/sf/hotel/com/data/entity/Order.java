package sf.hotel.com.data.entity;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import sf.hotel.com.data.utils.TimeUtils;

/**
 * Created by 林其望
 * data：2016/7/4
 * email: 1105896230@qq.com
 */
@DatabaseTable(tableName = "tb_order")
public class Order {
    //    已完成
    public static final int ALRADYORDER = -100;
    //    未入住
    public static final int NOTORDER = 0x11;
    //    待确认
    public static final int PENDING_CONFIRMATION = 0x1;

    //    无早餐
    public static final int BREAFKFAST_NOT = 1;
    //    单早餐
    public static final int BREAFKFAST_ONE = 2;
    //    双早餐
    public static final int BREAFKFAST_DOUBLE = 3;

    @DatabaseField(columnName = "customer")
    @SerializedName("customer")
    public long userId;
    @DatabaseField(id = true, unique = true, columnName = "order")
    @SerializedName("order")
    private long order_num;
    //    订单的状态
    @DatabaseField(columnName = "payment_status")
    @SerializedName("payment_status")
    private int state;

    @DatabaseField(columnName = "closed")
    @SerializedName("closed")
    private boolean isClosed;
    @DatabaseField(columnName = "room_name")
    @SerializedName("room_name")
    private String room_name;
    @DatabaseField(columnName = "hotel_name")
    @SerializedName("hotel_name")
    private String hotel_name;

    @DatabaseField(columnName = "checkin_time")
    @SerializedName("checkin_time")
    private String checkin_time;
    @DatabaseField(columnName = "checkout_time")
    @SerializedName("checkout_time")
    private String checkout_time;
    @DatabaseField(columnName = "deleted")
    @SerializedName("deleted")
    private boolean deleted;


    @DatabaseField(columnName = "total_front_prices")
    @SerializedName("total_front_prices")
    private long total_front_prices;

    @DatabaseField(columnName = "total_need_points")
    @SerializedName("total_need_points")
    private long total_need_points;

    public int getBreakfast() {
        return breakfast;
    }

    @DatabaseField(columnName = "breakfast")
    @SerializedName("breakfast")

    private int breakfast;
    @DatabaseField(columnName = "process_state")
    @SerializedName("process_state")

    private int process_state;

    @DatabaseField(columnName = "seller")
    @SerializedName("seller")

    private int seller;
    @DatabaseField(columnName = "modified")
    @SerializedName("modified")
    private String modified;

    @DatabaseField(columnName = "update_time")
    private long update_time;

    public String getModified() {
        return modified;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getCheckin_time() {
        return checkin_time;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getCheckout_time() {
        return checkout_time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public long getTotal_front_prices() {
        return total_front_prices;
    }

    public long getTotal_need_points() {
        return total_need_points;
    }

    public String getHotel_name() {
        return hotel_name;
    }


    public boolean isClosed() {
        return isClosed;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
//    订单号

    public long getOrder_num() {
        return order_num;
    }


    public int getState() {
        return state;
    }


    public String getStateMessage() {
        String text = "";
        if (state == 1) {
            text = "订单当前在审核";
        } else if (state == 2) {
            text = "取消入住";
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Order) {
            return this.order_num == ((Order) o).getOrder_num();
        }
        return false;
    }

    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }


    public void timeAdapter() {
        this.update_time = TimeUtils.TimeAdapter(this.modified);
    }
}
