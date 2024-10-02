public class MealDirector {
    private MealBuilder builder;

    public MealDirector(MealBuilder builder) {
        this.builder = builder;
    }

    public Meal constructMeal() {
        builder.buildBurger();
        builder.buildDrink();
        builder.buildDessert();
        return builder.getMeal();
    }
}