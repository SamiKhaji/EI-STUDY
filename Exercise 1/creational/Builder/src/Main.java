public class Main {
    public static void main(String[] args) {
        MealBuilder vegMealBuilder = new VegMealBuilder();
        MealDirector director = new MealDirector(vegMealBuilder);
        Meal vegMeal = director.constructMeal();
        vegMeal.showMeal();

        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        director = new MealDirector(nonVegMealBuilder);
        Meal nonVegMeal = director.constructMeal();
        nonVegMeal.showMeal();
    }
}