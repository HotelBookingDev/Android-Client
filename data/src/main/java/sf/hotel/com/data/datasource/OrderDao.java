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


    public static void update(Order order, Context context) {
        try {
            if (order.isDeleted()) {
                boolean exitDb = isExitDb(context, order);
                if (exitDb) {
                    DatabaseHelper.getHelper(context).getOrders().delete(order);
                }
            } else {
                DatabaseHelper.getHelper(context).getOrders().createOrUpdate(order);
            }
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

    public static List<Order> getOrder(Context context, boolean isClose, long userId) {
        List<Order> mLists = null;
        try {
            QueryBuilder<Order, Integer> orderIntegerQueryBuilder = DatabaseHelper.getHelper(
                    context).getOrders().queryBuilder();
            orderIntegerQueryBuilder.where().eq("closed", isClose).and().eq("user_id", userId);
            mLists = orderIntegerQueryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mLists;
    }

    private static boolean isExitDb(Context context, Order order) {
        boolean isExit = false;
        if (order == null) return isExit;
        try {
            QueryBuilder<Order, Integer> orderIntegerQueryBuilder = DatabaseHelper.getHelper(
                    context).getOrders().queryBuilder();
            orderIntegerQueryBuilder.where().eq("number", order.getOrder_num());
            List<Order> query = orderIntegerQueryBuilder.query();
            if (query != null && query.size() > 0) {
                isExit = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExit;
    }
}
