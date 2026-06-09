import java.util.ArrayList;


public class RecommendationService {

     public static void showRecommendations(UserProfile profile, ArrayList<Workout> workouts) {

        System.out.println("\n===== PERSONALIZED FITNESS REPORT =====");
        System.out.println("Age: " + profile.age);
        System.out.println("Weight: " + profile.weight + " kg");
        System.out.println("Height: " + profile.height + " cm");
        System.out.printf("BMI: %.2f\n", profile.calculateBMI());
        System.out.printf("Daily Protein Goal: %.2f grams\n", profile.calculateProteinGoal());

        if (profile.goal.equalsIgnoreCase("Bulk") || profile.goal.equalsIgnoreCase("Bulking")) {
            showBulkingPlan(profile, workouts);
        } else if (profile.goal.equalsIgnoreCase("Cut") || profile.goal.equalsIgnoreCase("Cutting")) {
            showCuttingPlan(profile, workouts);
        } else if (profile.goal.equalsIgnoreCase("Maintain") || profile.goal.equalsIgnoreCase("Maintenance")) {
            showMaintainPlan(profile, workouts);
        } else {
            System.out.println("Invalid goal. Please enter Bulk, Cut, or Maintain.");
        }
    }

    public static void showBulkingPlan(UserProfile profile, ArrayList<Workout> workouts){

        System.out.println("\n===== BULKING MEAL PLAN =====");

        if (profile.weight < 60) {
            System.out.println("Meal Type: High-calorie lean bulk plan");
            System.out.println("1. Oats + Milk + Banana + Peanut Butter");
            System.out.println("Protein: 25g | Fats: 22g | Calories: 650");
            System.out.println("Vitamins: Calcium, Potassium, Vitamin E");

            System.out.println("2. Rice + Dal + Curd + Eggs");
            System.out.println("Protein: 35g | Fats: 18g | Calories: 750");
            System.out.println("Vitamins: B12, Calcium, Iron");

        } else {
            System.out.println("Meal Type: Balanced muscle gain plan");
            System.out.println("1. Rice + Chicken/Rajma + Curd");
            System.out.println("Protein: 45g | Fats: 15g | Calories: 800");
            System.out.println("Vitamins: Iron, Zinc, Calcium");

            System.out.println("2. Eggs + Milk + Oats");
            System.out.println("Protein: 32g | Fats: 18g | Calories: 520");
            System.out.println("Vitamins: B12, Vitamin D, Calcium");
        }

        System.out.println("\n===== BULKING WORKOUT PLAN =====");
        System.out.println("Goal: Muscle gain with progressive overload");
        System.out.println("Day 1: Chest + Triceps");
        System.out.println("- Bench Press: 4 sets x 8 reps");
        System.out.println("- Incline Dumbbell Press: 3 sets x 10 reps");
        System.out.println("- Triceps Pushdown: 3 sets x 12 reps");

        System.out.println("Day 2: Back + Biceps");
        System.out.println("- Lat Pulldown: 4 sets x 10 reps");
        System.out.println("- Barbell Row: 3 sets x 8 reps");
        System.out.println("- Bicep Curls: 3 sets x 12 reps");

        System.out.println("Day 3: Legs + Shoulders");
        System.out.println("- Squats: 4 sets x 8 reps");
        System.out.println("- Shoulder Press: 3 sets x 10 reps");
    
    workouts.add(new Workout("Bench Press", 4, 8, 0));
workouts.add(new Workout("Incline Dumbbell Press", 3, 10, 0));
workouts.add(new Workout("Triceps Pushdown", 3, 12, 0));
workouts.add(new Workout("Lat Pulldown", 4, 10, 0));
workouts.add(new Workout("Barbell Row", 3, 8, 0));
workouts.add(new Workout("Squats", 4, 8, 0));
    

System.out.println("\nSuggested bulking workouts added to your workout history.");
    }

    public static void showCuttingPlan(UserProfile profile, ArrayList<Workout> workouts) {

        System.out.println("\n===== CUTTING MEAL PLAN =====");

        if (profile.calculateBMI() > 25) {
            System.out.println("Meal Type: Fat-loss high-protein plan");
            System.out.println("1. Eggs + Vegetables + Curd");
            System.out.println("Protein: 30g | Fats: 12g | Calories: 350");
            System.out.println("Vitamins: B12, Vitamin C, Calcium");

            System.out.println("2. Grilled Chicken/Paneer + Salad");
            System.out.println("Protein: 40g | Fats: 14g | Calories: 450");
            System.out.println("Vitamins: Iron, Zinc, Vitamin A");
        } else {
            System.out.println("Meal Type: Mild cutting plan");
            System.out.println("1. Rice + Dal + Vegetables");
            System.out.println("Protein: 22g | Fats: 6g | Calories: 500");
            System.out.println("Vitamins: B Vitamins, Iron, Fiber");

            System.out.println("2. Milk + Eggs");
            System.out.println("Protein: 20g | Fats: 14g | Calories: 280");
            System.out.println("Vitamins: Calcium, B12, Vitamin D");
        }

        System.out.println("\n===== CUTTING WORKOUT PLAN =====");
        System.out.println("Goal: Fat loss while maintaining muscle");
        System.out.println("Day 1: Full Body Strength");
        System.out.println("- Squats: 3 sets x 12 reps");
        System.out.println("- Push-ups: 3 sets x 15 reps");
        System.out.println("- Lat Pulldown: 3 sets x 12 reps");

        System.out.println("Day 2: Cardio + Core");
        System.out.println("- Treadmill Walking: 25 minutes");
        System.out.println("- Plank: 3 sets x 45 seconds");
        System.out.println("- Crunches: 3 sets x 20 reps");

        System.out.println("Day 3: Upper Body + Cardio");
        System.out.println("- Shoulder Press: 3 sets x 12 reps");
        System.out.println("- Bicep Curls: 3 sets x 12 reps");
        System.out.println("- Cycling: 20 minutes");
        workouts.add(new Workout("Squats", 3, 12, 0));
workouts.add(new Workout("Push-ups", 3, 15, 0));
workouts.add(new Workout("Lat Pulldown", 3, 12, 0));
workouts.add(new Workout("Treadmill Walking", 1, 25, 0));
workouts.add(new Workout("Plank", 3, 45, 0));
workouts.add(new Workout("Cycling", 1, 20, 0));

System.out.println("\nSuggested cutting workouts added to your workout history.");
    }

    public static void showMaintainPlan(UserProfile profile, ArrayList<Workout> workouts){

        System.out.println("\n===== MAINTENANCE MEAL PLAN =====");

        System.out.println("Meal Type: Balanced fitness plan");
        System.out.println("1. Rice + Dal + Vegetables + Curd");
        System.out.println("Protein: 28g | Fats: 10g | Calories: 600");
        System.out.println("Vitamins: Calcium, Iron, B Vitamins");

        System.out.println("2. Eggs/Paneer + Milk + Fruits");
        System.out.println("Protein: 30g | Fats: 16g | Calories: 500");
        System.out.println("Vitamins: B12, Vitamin D, Potassium");

        System.out.println("\n===== MAINTENANCE WORKOUT PLAN =====");
        System.out.println("Goal: Stay fit and maintain strength");

        System.out.println("Day 1: Push Workout");
        System.out.println("- Bench Press: 3 sets x 10 reps");
        System.out.println("- Shoulder Press: 3 sets x 10 reps");
        System.out.println("- Triceps Pushdown: 3 sets x 12 reps");

        System.out.println("Day 2: Pull Workout");
        System.out.println("- Lat Pulldown: 3 sets x 10 reps");
        System.out.println("- Seated Row: 3 sets x 10 reps");
        System.out.println("- Bicep Curls: 3 sets x 12 reps");

        System.out.println("Day 3: Legs");
        System.out.println("- Squats: 3 sets x 10 reps");
        System.out.println("- Leg Press: 3 sets x 12 reps");
        System.out.println("- Calf Raises: 3 sets x 15 reps");
        workouts.add(new Workout("Bench Press", 3, 10, 0));
workouts.add(new Workout("Shoulder Press", 3, 10, 0));
workouts.add(new Workout("Lat Pulldown", 3, 10, 0));
workouts.add(new Workout("Seated Row", 3, 10, 0));
workouts.add(new Workout("Squats", 3, 10, 0));
workouts.add(new Workout("Leg Press", 3, 12, 0));

System.out.println("\nSuggested maintenance workouts added to your workout history.");
    }
}