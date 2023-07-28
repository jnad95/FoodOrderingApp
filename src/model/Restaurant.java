package model;

import java.util.List;

public class Restaurant {

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", dish=" + dish +
                ", maxOrders=" + maxOrders +
                ", currentOrders=" + currentOrders +
                ", rating=" + rating +
                '}';
    }

    private String name;
    private List<Dish> dish;
    private int maxOrders;
    private int currentOrders;
    private int rating;

    public int getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(int currentOrders) {
        this.currentOrders = currentOrders;
    }

    public Restaurant(String name, List<Dish> dish, int maxOrders, int rating) {
        this.name = name;
        this.dish = dish;
        this.maxOrders = maxOrders;
        this.rating = rating;
        this.currentOrders = 0;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }
}
