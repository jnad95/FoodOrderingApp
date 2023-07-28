import model.Dish;
import model.MenuOperations;
import model.SelectionStrategy;

import java.util.List;

public interface OrderingApp {

    void addRestaurant(String name, int maxOrders, List<Dish> dishList, int rating);

    void addOrUpdateMenu(String restaurantName, MenuOperations operation, Dish dish);

    int addOrder(String user, List<Dish> dishList, SelectionStrategy strategy);

    void updateOrder(int orderId);
}
