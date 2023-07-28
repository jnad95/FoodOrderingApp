import model.Dish;
import model.MenuOperations;
import model.Restaurant;
import model.SelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlipkartFoodOrderingApp {
    private static int MAX_ORDERS = 5;

    public static void main(String args[]) {

        List<Dish> dishList1 = getTestDishList1();
        List<Restaurant> restaurantList = getTestRestaurantList1(dishList1);

        List<Dish> dishList2 = getTestDishList2();

        OrderingApp app = new OrderingAppImpl(restaurantList);


        app.addRestaurant("MotherMary", MAX_ORDERS, dishList2, 3);

        app.addOrUpdateMenu("khaanakhazana", MenuOperations.ADD,
                new Dish("butter paneer masala", 10, 300));

        int orderId = app.addOrder("testUser", dishList2, SelectionStrategy.LOWEST_COST);

        app.updateOrder(orderId);
    }

    private static List<Dish> getTestDishList1() {
        Dish jalebi = new Dish("jalebi", 100, 10);
        Dish paneerRoll = new Dish("paneerRoll", 10, 120);
        List<Dish> dishList = new ArrayList<>();
        dishList.add(jalebi);
        dishList.add(paneerRoll);
        return dishList;
    }

    private static List<Dish> getTestDishList2() {
        Dish jalebi = new Dish("jalebi", 100, 9);
        Dish paneerRoll = new Dish("paneerRoll", 10, 20);
        List<Dish> dishList = new ArrayList<>();
        dishList.add(jalebi);
        dishList.add(paneerRoll);
        return dishList;
    }

    private static List<Restaurant> getTestRestaurantList1(List<Dish> dishList) {

        Restaurant khaanaKhazana = new Restaurant("khaanakhazana", dishList, MAX_ORDERS, 4);
        List<Restaurant> restList = new ArrayList<>();
        restList.add(khaanaKhazana);
        return restList;
    }


}
