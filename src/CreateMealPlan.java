package src;

import java.lang.reflect.Array;
import java.util.Scanner;

public class CreateMealPlan {

    public static String[] breakfastOptions = new String[] {"Avocado Toast", "Biscuits and Gravy", "Oatmeal", "Waffles",
            "Fruit Loops Cereal", "Hash Brown Omelet"};
    public static String[] lunchOptions = new String[] {"Chicken Taco Salad","Tomato and Pasta Soup","Greed Goddess Wraps",
            "Burrito Bowls","Turkey Quinoa Salad","BLT Sandwich"};
    public static String[] dinnerOptions = new String[] {"Broccoli Chicken Alfredo","Baked Salmon and Rice","Chicken Stir Fry",
            "Beef Stew","Pork Roast with Potatoes and Carrots","Enchiladas"};
    public static int[] selectedMeals = new int[26];
    public static Scanner scanner = new Scanner(System.in);

    public static void initializeArrayMeals() {
        for (int i = 0; i<selectedMeals.length; i++) {
            selectedMeals[i] = Integer.MAX_VALUE;
        }
    }

    public static void getMealsByType(String mealType) {
        if (mealType.equals("Breakfast")) {
            for (int i = 0; i < breakfastOptions.length; i++) {
                System.out.println((i+1) + ". " +breakfastOptions[i]);
            }
        }
        if (mealType.equals("Lunch")) {
            for (int i = 0; i < lunchOptions.length; i++) {
                System.out.println((i+1) + ". " +lunchOptions[i]);
            }
        }
        if (mealType.equals("Dinner")) {
            for (int i = 0; i < dinnerOptions.length; i++) {
                System.out.println((i+1) + ". " +dinnerOptions[i]);
            }
        }

    }

    public static void setMealsByDay(int mealIndex, int mealNumber) {
        Array.set(selectedMeals,mealIndex,mealNumber);

    }

    public static void displayMealSelections () {
        int count = 0;
        for (int i=0; i<selectedMeals.length; i++) {
            System.out.println("Day " + (i+1));
            System.out.println("-------------");
            System.out.println("Breakfast: " + breakfastOptions[selectedMeals[count]]);
            count++;
            System.out.println("Lunch: " + lunchOptions[selectedMeals[count]]);
            count++;
            System.out.println("Dinner: " + dinnerOptions[selectedMeals[count]]);
            count++;
            System.out.println("");
            if (selectedMeals[count] == Integer.MAX_VALUE) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        initializeArrayMeals();
        System.out.println("Welcome to the meal planner!" );
        System.out.println("Enter the number of days to meal plan for:");
        int mealPlanDays = scanner.nextInt();

        int counterIndex = 0;
        for (int i = 0; i<=mealPlanDays-1; i++) {
            System.out.println("Day " + (i+1) + " Breakfast Options:");
            getMealsByType("Breakfast");
            System.out.println("");
            System.out.println("Enter the meal number you want for Breakfast:");
            int mealSelectTemp = scanner.nextInt();
            setMealsByDay(counterIndex,mealSelectTemp-1);
            counterIndex++;

            System.out.println("Day " + (i+1) + " Lunch Options:");
            getMealsByType("Lunch");
            System.out.println("");
            System.out.println("Enter the meal number you want for Lunch:");
            mealSelectTemp = scanner.nextInt();
            setMealsByDay(counterIndex,mealSelectTemp-1);
            counterIndex++;

            System.out.println("Day " + (i+1) + " Dinner Options:");
            getMealsByType("Dinner");
            System.out.println("");
            System.out.println("Enter the meal number you want for Dinner:");
            mealSelectTemp = scanner.nextInt();
            setMealsByDay(counterIndex,mealSelectTemp-1);
            counterIndex++;
        }

        System.out.println("Here is your Meal Plan:");
        System.out.println("");
        displayMealSelections();
    }

}

