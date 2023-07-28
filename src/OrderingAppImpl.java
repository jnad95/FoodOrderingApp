import model.*;
import selection.LowestCostStrategy;
import selection.SelectionStrategy;

import java.util.*;

public class OrderingAppImpl implements OrderingApp {

    private List<Restaurant> restaurants;
    private List<User> users;
    private Map<Integer, Restaurant> orderMap;
    private SelectionStrategy selector;

    OrderingAppImpl(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        users = new ArrayList<>();
        orderMap = new HashMap<>();
    }

    @Override
    public void addRestaurant(String name, int maxOrders, List<Dish> dishList, int rating) {
        // TODO: validations
        restaurants.add(new Restaurant(name, dishList, maxOrders, rating));
        System.out.println("Restaurant: " + restaurants + " added successfully");
    }

    @Override
    public void addOrUpdateMenu(String restaurantName, MenuOperations operation, Dish dish) {
        Restaurant restaurant = getRestaurantByRestaurantName(restaurantName);
        if (operation == MenuOperations.ADD) {
            List<Dish> dishList = restaurant.getDish();
            dishList.add(dish);
        } else if (operation == MenuOperations.UPDATE) {
            List<Dish> dishList = restaurant.getDish();
            Dish dishToBeRemoved = getDishByDishNameFromDishList(dish.getDishName(), dishList);
            if (dishToBeRemoved != null) {
                dishList.remove(dishToBeRemoved);
            }
            dishList.add(dish);
        } else {
            // other operations
        }
        System.out.println("Menu Updated");
    }

    @Override
    public int addOrder(String userName, List<Dish> dishList, model.SelectionStrategy strategy) {
        User user = getUserbyUserName(userName);
        if (user == null) {
            user = new User(userName, new Order((int) (Math.random() * 10), dishList));
            users.add(user);
        }
        Restaurant selectedRest;
        if (strategy == model.SelectionStrategy.LOWEST_COST) {
            selector = new LowestCostStrategy();
            selectedRest = selector.getRestaurant(restaurants, dishList);
            if (selectedRest != null) {
                removeCapacityFromRest(selectedRest, dishList);
                System.out.println("Order taken at rest: " + selectedRest);
                orderMap.put(user.getOrder().getOrderId(), selectedRest);
            } else {
                System.out.println("Order cant be taken");
            }
        }
        return user.getOrder().getOrderId();
    }

    @Override
    public void updateOrder(int orderId) {
        Restaurant rest = orderMap.get(orderId);
        if (rest != null) {
            System.out.println("Order has been serverd by " + rest.getName());
        } else {
            System.out.println("Order cant be served");
        }
    }

    private Dish getDishByDishNameFromDishList(String dishName, List<Dish> dishList) {
        for (Dish dish : dishList) {
            if (dish.getDishName().equals(dishName)) {
                return dish;
            }
        }
        return null;
    }

    private Restaurant getRestaurantByRestaurantName(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }
        return null;
    }

    private User getUserbyUserName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    private void removeCapacityFromRest(Restaurant selectedRest, List<Dish> dishList) {
        List<Dish> menu = selectedRest.getDish();
        for (Dish dish : dishList) {
            for (Dish menuDish : menu) {
                if (Objects.equals(menuDish.getDishName(), dish.getDishName())) {
                    menuDish.setQuantity(menuDish.getQuantity() - dish.getQuantity());
                }
            }
        }
    }
}
