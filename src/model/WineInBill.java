package model;

public class WineInBill {
    private String wineName;
    private int quantity;
    private float cost;

    public WineInBill(String wineName, int quantity, float cost) {
        this.wineName = wineName;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
