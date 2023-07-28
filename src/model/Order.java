package model;

import java.util.List;

public class Order {

    private int orderId;
    private List<Dish> dishList;

    public Order(int orderId, List<Dish> dishList) {
        this.orderId = orderId;
        this.dishList = dishList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dishList=" + dishList +
                '}';
    }
}
