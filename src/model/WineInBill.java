package model;

public class WineInBill {
    private int wineId;
    private String wineName;
    private int quantity;
    private float cost;

    public WineInBill(int id, String wineName, int quantity, float cost) {
        this.wineId = id;
        this.wineName = wineName;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getWineId() {
        return wineId;
    }

    public void setWineId(int wineId) {
        this.wineId = wineId;
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
