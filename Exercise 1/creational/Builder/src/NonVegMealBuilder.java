public class NonVegMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("Chicken Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coke");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Brownie");
    }
}
