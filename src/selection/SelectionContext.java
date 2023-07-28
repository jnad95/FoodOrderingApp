package selection;

import model.Restaurant;

public class SelectionContext {

    SelectionStrategy strategy;

    public SelectionContext(SelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public Restaurant getRestaurant() {
        return new Restaurant();
    }
}
