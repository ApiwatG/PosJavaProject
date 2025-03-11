package controller;

public class MenuItem {
    private int itemId;
    private String name;
    private double price;
    private int quantity;
    private String imagePath;
    
    public MenuItem() {
    	 itemId = 0;
    	    name = "";
    	    price = 0;
    	    quantity = 0;
    	    imagePath = "";
    }
    
    public MenuItem(int itemId, String name, double price, int quantity, String imagePath) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    // Constructor without imagePath (optional)
   
    
    

    // Getters
    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getquantity() { return quantity; }
    public String getImagePath() { return imagePath; }

    // Setters
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setItemType(int quantity) { this.quantity = quantity; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

	public void MenuItem(int itemId, String name, double price, int quantity) {
		this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
		
	}

}
