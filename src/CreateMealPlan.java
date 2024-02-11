package src;

import java.util.Scanner;

public class CreateMealPlan {

    public static String[] breakfastOptions = new String[]{"Avocado Toast", "Biscuits and Gravy", "Oatmeal", "Waffles",
            "Fruit Loops Cereal", "Hash Brown Omelet"};
    public static String[] lunchOptions = new String[]{"Chicken Taco Salad", "Tomato and Pasta Soup", "Greed Goddess Wraps",
            "Burrito Bowls", "Turkey Quinoa Salad", "BLT Sandwich"};
    public static String[] dinnerOptions = new String[]{"Broccoli Chicken Alfredo", "Baked Salmon and Rice", "Chicken Stir Fry",
            "Beef Stew", "Pork Roast with Potatoes and Carrots", "Enchiladas"};
    public static final String MEAL_BREAKFAST = "Breakfast";
    public static final String MEAL_LUNCH = "Lunch";
    public static final String MEAL_DINNER = "Dinner";
    public static int[] selectedMeals;
    public static Scanner scanner = new Scanner(System.in);

    public static void getMealsByType(String mealType) {
        if (MEAL_BREAKFAST.equals(mealType)) {
            for (int i = 0; i < breakfastOptions.length; i++) {
                System.out.println((i + 1) + ". " + breakfastOptions[i]);
            }
        } else if (MEAL_LUNCH.equals(mealType)) {
            for (int i = 0; i < lunchOptions.length; i++) {
                System.out.println((i + 1) + ". " + lunchOptions[i]);
            }
        } else if (MEAL_DINNER.equals(mealType)) {
            for (int i = 0; i < dinnerOptions.length; i++) {
                System.out.println((i + 1) + ". " + dinnerOptions[i]);
            }
        }
    }

    public static void setMealsByDay(int mealIndex, int mealNumber) {
        selectedMeals[mealIndex] = mealNumber;
    }

    public static void displayMealSelections(int numOfDays) {
        int count = 0;
        for (int i = 0; i <= numOfDays; i++) {
            if (selectedMeals.length > count) {
                System.out.println("Day " + (i + 1));
                System.out.println("-------------");
                System.out.println("Breakfast: " + breakfastOptions[selectedMeals[count]]);
                count++;
                System.out.println("Lunch: " + lunchOptions[selectedMeals[count]]);
                count++;
                System.out.println("Dinner: " + dinnerOptions[selectedMeals[count]]);
                count++;
                System.out.println("");
            } else {
                break;
            }
        }
    }

    public static int getNumberOfDays() {
        boolean isDaysValid = false;
        while (!isDaysValid) {
            System.out.println("Enter the number of days to meal plan for:");
            if (scanner.hasNextInt()) {
                isDaysValid = true;
            }else {
                System.out.println("You did not enter a valid number.  Please re-enter a number.");
                scanner.next();
            }
        }
        return scanner.nextInt();
    }

    public static int  getMealNumber () {
        boolean isMealValid = false;
        while (!isMealValid) {
            if (scanner.hasNextInt()) {
                isMealValid = true;
            }else {
                System.out.println("You did not enter a valid number.  Please re-enter a number.");
                scanner.next();
            }
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the meal planner!");
        int mealPlanDays = getNumberOfDays();
        selectedMeals = new int[mealPlanDays * 3];

        int counterIndex = 0;
        for (int i = 0; i <= mealPlanDays - 1; i++) {
            System.out.println("Day " + (i + 1) + " Breakfast Options:");
            getMealsByType(MEAL_BREAKFAST);
            System.out.println("");
            System.out.println("Enter the meal number you want for Breakfast:");
            int mealSelectTemp = getMealNumber();
            setMealsByDay(counterIndex, mealSelectTemp - 1);
            counterIndex++;

            System.out.println("Day " + (i + 1) + " Lunch Options:");
            getMealsByType(MEAL_LUNCH);
            System.out.println("");
            System.out.println("Enter the meal number you want for Lunch:");
            mealSelectTemp = getMealNumber();
            setMealsByDay(counterIndex, mealSelectTemp - 1);
            counterIndex++;

            System.out.println("Day " + (i + 1) + " Dinner Options:");
            getMealsByType(MEAL_DINNER);
            System.out.println("");
            System.out.println("Enter the meal number you want for Dinner:");
            mealSelectTemp = getMealNumber();
            setMealsByDay(counterIndex, mealSelectTemp - 1);
            counterIndex++;
        }

        System.out.println("Here is your Meal Plan:");
        System.out.println("");
        displayMealSelections(mealPlanDays);
    }
}

