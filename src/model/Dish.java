package model;

public class Dish {

    private String dishName;
    private int quantity;
    private int cost;

    public Dish(String dishName, int quantity, int cost) {
        this.dishName = dishName;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
