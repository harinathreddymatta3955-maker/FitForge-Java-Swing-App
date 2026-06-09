import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static UserProfile profile;
    static ArrayList<Workout> workouts = new ArrayList<>();
    static ArrayList<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== FITFORGE =====");
            System.out.println("1. Create Profile");
            System.out.println("2. Add Workout");
            System.out.println("3. Add Meal");
            System.out.println("4. View Summary");
            System.out.println("5. View Workouts");
            System.out.println("6. Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

    sc.nextLine();

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Age: ");
    int age = sc.nextInt();

    System.out.print("Enter Height (cm): ");
    double height = sc.nextDouble();

    System.out.print("Enter Weight (kg): ");
    double weight = sc.nextDouble();

    sc.nextLine();

    System.out.print("Enter Goal (Bulk/Cut/Maintain): ");
    String goal = sc.nextLine();

   profile = new UserProfile(
            name,
            age,
            "Male",
            height,
            weight,
            goal,
            "Veg",
            "Beginner",
            5
        );

    System.out.println("\nProfile Created Successfully!");

    System.out.println(
        "Daily Protein Goal: "
        + profile.calculateProteinGoal()
        + " grams");
        RecommendationService.showRecommendations(profile, workouts);

    break;

                case 2:
    sc.nextLine();

    System.out.print("Enter Exercise Name: ");
    String exerciseName = sc.nextLine();

    System.out.print("Enter Sets: ");
    int sets = sc.nextInt();

    System.out.print("Enter Reps: ");
    int reps = sc.nextInt();

    System.out.print("Enter Weight Used (kg): ");
    double weightUsed = sc.nextDouble();

    workouts.add(new Workout(exerciseName, sets, reps, weightUsed));

    System.out.println("Workout Added Successfully!");
    break;

                case 3:
    sc.nextLine();

    System.out.print("Enter Food Name: ");
    String foodName = sc.nextLine();

    System.out.print("Enter Protein (grams): ");
    double protein = sc.nextDouble();

    System.out.print("Enter Calories: ");
    double calories = sc.nextDouble();

    meals.add(new Meal(foodName, protein, calories));

    System.out.println("Meal Added Successfully!");
    break;


                case 4:
    if (profile == null) {
        System.out.println("Please create your profile first.");
        break;
    }

    double totalProtein = 0;
    double totalCalories = 0;

    for (Meal meal : meals) {
        totalProtein += meal.protein;
        totalCalories += meal.calories;
    }

    System.out.println("\n===== DAILY SUMMARY =====");
    System.out.println("Name: " + profile.name);
    System.out.println("Goal: " + profile.goal);
    System.out.println("Protein Goal: " + profile.calculateProteinGoal() + " grams");
    System.out.println("Protein Consumed: " + totalProtein + " grams");
    System.out.println("Calories Consumed: " + totalCalories);
    System.out.println("Workouts Done: " + workouts.size());

    break;

                case 5:
    if (workouts.isEmpty()) {
        System.out.println("No workouts added yet.");
    } else {
        System.out.println("\n===== WORKOUT HISTORY =====");

        for (Workout workout : workouts) {
            System.out.println("\nExercise: " + workout.exerciseName);
            System.out.println("Sets: " + workout.sets);
            System.out.println("Reps: " + workout.reps);
            System.out.println("Weight Used: " + workout.weightUsed + " kg");
        }
    }
    break;

    case 6:
    System.out.println("Thank You For Using FitForge!");
    sc.close();
    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
