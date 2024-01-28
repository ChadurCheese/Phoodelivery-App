package piotr.mazur;

public class Food {

    // instance vaiables
    private String category;
    private String name;
    private double price;
    private String restaurant;

    // constructor
    public Food(String name, double price, String restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    // getters
    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getRestaurant() {
        return restaurant;
    }

}
