package controller;

public class MenuItem {
    private int itemId;
    private String name;
    private double price;
    private String itemType;
    private String imagePath;

    public MenuItem(int itemId, String name, double price, String itemType) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    // Getters
    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getItemType() { return itemType; }
    public String getImagePath() { return imagePath; }

    // Setters
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
