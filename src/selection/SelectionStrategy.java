package selection;

import model.Dish;
import model.Restaurant;

import java.util.List;

public interface SelectionStrategy {

    Restaurant getRestaurant(List<Restaurant> restaurants, List<Dish> dishList);
}
