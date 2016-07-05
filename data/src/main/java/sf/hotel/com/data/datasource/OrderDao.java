package sf.hotel.com.data.datasource;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import rx.Observable;
import sf.hotel.com.data.entity.Order;

/**
 * Created by 林其望
 * data：2016/7/4
 * email: 1105896230@qq.com
 */
public class OrderDao {
    public static void addOrder(Order order, Context context) {
        initdata(order);
        try {
            DatabaseHelper.getHelper(context).getOrders().createIfNotExists(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Order order, Context context) {
        initdata(order);
        try {
            DatabaseHelper.getHelper(context).getOrders().createOrUpdate(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(List<Order> list, Context context) {
        if (list == null) return;
        for (Order order : list) {
            update(order, context);
        }
    }

    public static List<Order> getOrder(Context context, int position, long userId) {
        List<Order> mLists = null;
        if (position == Order.ALRADYORDER || position == Order.NOTORDER) {
            try {
                QueryBuilder<Order, Integer> orderIntegerQueryBuilder = DatabaseHelper.getHelper(
                        context).getOrders().queryBuilder();
                orderIntegerQueryBuilder.where().eq("state", position);
                orderIntegerQueryBuilder.where().eq("user_id", userId);
                mLists = orderIntegerQueryBuilder.query();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mLists;
    }

    private static void initdata(Order mOrder) {
        Observable.just(mOrder)
                .filter(orderAndHotel -> mOrder == null ? Boolean.FALSE : Boolean.TRUE)
                .filter(orderAndHotel -> mOrder.getHotelShot() ==
                        null ? Boolean.FALSE : Boolean.TRUE)
                .subscribe(orderAndHotel -> {
                    mOrder.getHotelShot().setId(mOrder.getOrder_num());
                });
    }
}
