package selection;

import model.Dish;
import model.Restaurant;

import java.util.List;

public class LowestCostStrategy implements SelectionStrategy {


    @Override
    public Restaurant getRestaurant(List<Restaurant> restaurants, List<Dish> dishList) {
        int lowestSum = 0;
        Restaurant targetRestaurant = null;
        for (Restaurant restaurant : restaurants) {
            if (canRestaurantFulfilOrder(restaurant, dishList)) {
                int orderSum = orderSumForThisRestaurant(restaurant, dishList);
                if (lowestSum != 0 && lowestSum > orderSum) {
                    lowestSum = orderSum;
                    targetRestaurant = restaurant;
                } else {
                    lowestSum = orderSum;
                    targetRestaurant = restaurant;
                }
            }
        }
        return targetRestaurant;
    }

    private int orderSumForThisRestaurant(Restaurant restaurant, List<Dish> dishList) {
        int cost = 0;
        List<Dish> restDishList = restaurant.getDish();
        for (Dish dish : dishList) {
            Dish dishInRest = getDishByDishName(restDishList, dish.getDishName());
            cost += dishInRest.getCost() * dish.getQuantity();
        }
        return cost;
    }

    private boolean canRestaurantFulfilOrder(Restaurant restaurant, List<Dish> dishList) {
        List<Dish> restDishList = restaurant.getDish();
        boolean canServe = true;
        if (restaurant.getCurrentOrders() >= restaurant.getMaxOrders()) {
            return false;
        }
        for (Dish dish : dishList) {
            if (restDishList.contains(dish)) {
                Dish dishInRest = getDishByDishName(restDishList, dish.getDishName());
                if (dishInRest.getQuantity() < dish.getQuantity()) {
                    canServe = false;
                }
            } else {
                canServe = false;
            }
        }
        return canServe;
    }

    private Dish getDishByDishName(List<Dish> dishList, String dishName) {
        for (Dish dish : dishList) {
            if (dishName.equals(dish.getDishName()))
                return dish;
        }
        return null;
    }
}
