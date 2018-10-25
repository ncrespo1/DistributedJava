package us.ncrespo.fruit.model;

public class FruitItems {
    private String name;
    private double price;
    private String image;
    private String description;
    private int id;


    public FruitItems(int id, String name, double price, String image, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() { return description; }

    public int getID() { return id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) { this.description = description; }

    public void setID(int id) { this.id = id; }
}
