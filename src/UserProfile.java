public class UserProfile {

    String name;
    int age;
    String gender;
    double height;
    double weight;
    String goal;
    String dietType;
    String experience;
    int workoutDays;
   

    public UserProfile(String name, int age, String gender, double height,
                   double weight, String goal, String dietType,
                   String experience, int workoutDays) {

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.goal = goal;
    this.dietType = dietType;
    this.experience = experience;
    this.workoutDays = workoutDays;
}

    public double calculateProteinGoal() {
    if (goal.equalsIgnoreCase("Bulk") || goal.equalsIgnoreCase("Bulking")) {
        return weight * 2.0;
    } else if (goal.equalsIgnoreCase("Cut") || goal.equalsIgnoreCase("Cutting")) {
        return weight * 1.8;
    } else {
        return weight * 1.6;
    }
}

public double calculateBMI() {
    double heightInMeters = height / 100;
    return weight / (heightInMeters * heightInMeters);
    }
}