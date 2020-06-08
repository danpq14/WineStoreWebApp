package model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private String Date;
    private List<WineInBill> wines;
    private float totalCost = 0;

    public Order(int orderId, int customerId, String date, List<WineInBill> wines) {
        this.orderId = orderId;
        this.customerId = customerId;
        Date = date;
        this.wines = wines;

        for (WineInBill wine : wines) {
            this.totalCost += wine.getCost();
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public List<WineInBill> getWines() {
        return wines;
    }

    public void setWines(List<WineInBill> wines) {
        this.wines = wines;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
