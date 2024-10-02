public class VegMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("Veggie Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Orange Juice");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Ice Cream");
    }
}