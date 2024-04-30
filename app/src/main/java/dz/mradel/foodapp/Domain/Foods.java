package dz.mradel.foodapp.Domain;

import java.io.Serializable;

public class Foods implements Serializable {
    private int CategoryId;
    private String Description;
    private boolean BestFood;
    private int Id;
    private int LocationId;
    private double Price;
    private String ImagePath;
    private int Priceld;
    private double Star;
    private int Timeld;
    private int TimeValue;
    private String Title;
    private int numberInCart;

    public Foods() {

    }

    public Foods(int categoryId, String description, boolean bestFood, int id, int locationId, double price, String imagePath, int priceld, double star, int timeld, int timeValue, String title, int numberInCart) {
        CategoryId = categoryId;
        Description = description;
        BestFood = bestFood;
        Id = id;
        LocationId = locationId;
        Price = price;
        ImagePath = imagePath;
        Priceld = priceld;
        Star = star;
        Timeld = timeld;
        TimeValue = timeValue;
        Title = title;
        this.numberInCart = numberInCart;
    }

    @Override
    public String toString() {
        return Title ;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBestFood() {
        return BestFood;
    }

    public void setBestFood(boolean bestFood) {
        BestFood = bestFood;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getPriceld() {
        return Priceld;
    }

    public void setPriceld(int priceld) {
        Priceld = priceld;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public int getTimeld() {
        return Timeld;
    }

    public void setTimeld(int timeld) {
        Timeld = timeld;
    }

    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = timeValue;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
