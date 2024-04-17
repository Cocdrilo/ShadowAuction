package edu.shadowauction.shadowauction;

public class Item {
    private String name;
    private String description;
    private String image;
    private int startingPrice;
    private int id;

    public Item(String name, String description, String image, int startingPrice, int id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.startingPrice = startingPrice;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
