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

    //Display meal options to user based on hard coded meal arrays
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

    //Storing meals
    public static void setMealsByDay(int mealIndex, int mealNumber) {
        selectedMeals[mealIndex] = mealNumber;
    }

    //Iteration over stored meals
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

    //checking number of days is a number
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

    //checking range of numbers falls into meal options
    public static boolean isMealOptionValid (int mealNumber) {
        if (mealNumber <=0 || mealNumber >6) {
            System.out.println("Enter a number between 1 and 6");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("WELCOME to the meal PLANNER!");
        int mealPlanDays = getNumberOfDays();
        selectedMeals = new int[mealPlanDays * 3];

        int mealSelectTemp;
        int counterIndex = 0; //Counter to know where to store values in selectedMeals array
        //iteration over number of days
        for (int i = 0; i <= mealPlanDays - 1; i++) {
            //iteration over number of meals
            for (int j = 0; j < 3; j++) {
                String mealType = "";
                switch (j) {
                    case 0:
                        mealType = MEAL_BREAKFAST;
                        break;
                    case 1:
                        mealType = MEAL_LUNCH;
                        break;
                    case 2:
                        mealType = MEAL_DINNER;
                        break;
                }

                System.out.println("Day " + (i + 1) + " " + mealType + " Options:");
                getMealsByType(mealType);

                System.out.println("");
                //error handling for numbers and between correct options
                do {
                    System.out.println("Enter the meal number you want for " + mealType + ":");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        scanner.next();
                    }
                    mealSelectTemp = scanner.nextInt();
                } while (!isMealOptionValid(mealSelectTemp));
                //storing meals
                setMealsByDay(counterIndex, mealSelectTemp - 1);
                counterIndex++;
            }
        }

        System.out.println("Here is your Meal Plan:");
        System.out.println("");
        displayMealSelections(mealPlanDays);
    }
}

