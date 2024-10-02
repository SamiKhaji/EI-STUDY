public class Meal {
    private String burger;
    private String drink;
    private String dessert;

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void showMeal() {
        System.out.println("Burger: " + burger);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
    }
}