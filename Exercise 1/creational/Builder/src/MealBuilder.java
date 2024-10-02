public abstract class MealBuilder {
    protected Meal meal = new Meal();

    public abstract void buildBurger();
    public abstract void buildDrink();
    public abstract void buildDessert();

    public Meal getMeal() {
        return meal;
    }
}