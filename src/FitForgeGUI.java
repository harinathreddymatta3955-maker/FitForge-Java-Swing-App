import javax.swing.*;
import java.awt.*;

public class FitForgeGUI extends JFrame { 
   class BackgroundPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(15, 15, 15),
                getWidth(), getHeight(), new Color(45, 45, 45)
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(new Color(220, 20, 60));
        g2d.fillRect(0, 0, getWidth(), 8);

        g2d.setColor(new Color(255, 255, 255, 25));
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 80));
        g2d.drawString("FITFORGE", 650, 180);

        g2d.setFont(new Font("Segoe UI", Font.BOLD, 34));
        g2d.drawString("DISCIPLINE", 700, 280);
        g2d.drawString("FOCUS", 700, 340);
        g2d.drawString("CONSISTENCY", 700, 400);
        g2d.drawString("SUCCESS", 700, 460);
    }
}
class ReportBackgroundPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(10, 20, 40),
                getWidth(), getHeight(), new Color(0, 0, 0)
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(new Color(0, 255, 255, 25));
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 90));

        g2d.drawString("FITFORGE", 450, 150);

        g2d.setFont(new Font("Segoe UI", Font.BOLD, 30));

        g2d.drawString("BMI", 900, 300);
        g2d.drawString("CALORIES", 850, 380);
        g2d.drawString("PROTEIN", 850, 460);
    }
}

    JTextField nameField, ageField, heightField, weightField;
    JRadioButton maleBtn, femaleBtn;
    JRadioButton vegBtn, nonVegBtn;
    JTextArea resultArea;
    CardLayout cardLayout;
    JPanel mainContainer;
    JPanel inputPage;
    JPanel reportPage;

    public FitForgeGUI() {
        setTitle("FitForge");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);
                inputPage = new BackgroundPanel();
                inputPage.setLayout(null);

        reportPage = new ReportBackgroundPanel();
        reportPage.setLayout(null);

        mainContainer.add(inputPage, "input");
        mainContainer.add(reportPage, "report");

        setContentPane(mainContainer);

        addLabel("Name:", 30, 20);
        nameField = addTextField(150, 20);

        addLabel("Age:", 30, 60);
        ageField = addTextField(150, 60);

        addLabel("Gender:", 30, 100);
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        maleBtn.setBounds(150, 100, 80, 25);
        femaleBtn.setBounds(240, 100, 100, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);

        inputPage.add(maleBtn);
        inputPage.add(femaleBtn);

        addLabel("Diet Type:", 30, 140);
        vegBtn = new JRadioButton("Veg");
        nonVegBtn = new JRadioButton("Non-Veg");
        vegBtn.setBounds(150, 140, 80, 25);
        nonVegBtn.setBounds(240, 140, 100, 25);

        ButtonGroup dietGroup = new ButtonGroup();
        dietGroup.add(vegBtn);
        dietGroup.add(nonVegBtn);
        inputPage.add(vegBtn);
        inputPage.add(nonVegBtn);

        addLabel("Height (cm):", 30, 180);
        heightField = addTextField(150, 180);

        addLabel("Weight (kg):", 30, 220);
        weightField = addTextField(150, 220);

        addLabel("Select Goal:", 30, 270);
        JRadioButton bulkBtn = new JRadioButton("Bulk");
        JRadioButton cutBtn = new JRadioButton("Cut");
        JRadioButton maintainBtn = new JRadioButton("Maintain");

        bulkBtn.setBounds(30, 300, 150, 25);
        cutBtn.setBounds(30, 330, 150, 25);
        maintainBtn.setBounds(30, 360, 150, 25);

        ButtonGroup goalGroup = new ButtonGroup();
        goalGroup.add(bulkBtn);
        goalGroup.add(cutBtn);
        goalGroup.add(maintainBtn);

        inputPage.add(bulkBtn);
        inputPage.add(cutBtn);
        inputPage.add(maintainBtn);

        addLabel("Select Experience:", 30, 400);
        JRadioButton beginnerBtn = new JRadioButton("Beginner");
        JRadioButton intermediateBtn = new JRadioButton("Intermediate");
        JRadioButton advancedBtn = new JRadioButton("Advanced");

        beginnerBtn.setBounds(30, 430, 150, 25);
        intermediateBtn.setBounds(30, 460, 150, 25);
        advancedBtn.setBounds(30, 490, 150, 25);

        ButtonGroup expGroup = new ButtonGroup();
        expGroup.add(beginnerBtn);
        expGroup.add(intermediateBtn);
        expGroup.add(advancedBtn);

        inputPage.add(beginnerBtn);
        inputPage.add(intermediateBtn);
        inputPage.add(advancedBtn);

        addLabel("Workout Days:", 30, 530);
        JComboBox<String> daysBox = new JComboBox<>(
                new String[]{"3 Days", "4 Days", "5 Days", "6 Days"}
        );
        daysBox.setBounds(30, 560, 150, 30);
        inputPage.add(daysBox);

        JButton submitBtn = new JButton("Generate Plan");
        submitBtn.setBounds(30, 610, 150, 35);
        inputPage.add(submitBtn);

       resultArea = new JTextArea();
resultArea.setEditable(false);
resultArea.setLineWrap(true);
resultArea.setWrapStyleWord(true);
resultArea.setOpaque(true);
resultArea.setBackground(new Color(8, 18, 35));
resultArea.setForeground(new Color(230, 230, 230));
resultArea.setForeground(Color.WHITE);
resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
resultArea.setFont(new Font("Consolas", Font.PLAIN, 16));
resultArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
resultArea.setFont(new Font("Consolas", Font.PLAIN, 16));

JScrollPane reportScroll = new JScrollPane(resultArea);
reportScroll.setBounds(50, 50, 1050, 540);
reportScroll.setBorder(
    BorderFactory.createLineBorder(new Color(0, 220, 180), 3)
);
reportPage.add(reportScroll);

JButton backBtn = new JButton("Back");
backBtn.setBounds(50, 610, 120, 35);
reportPage.add(backBtn);

backBtn.addActionListener(e -> {
    cardLayout.show(mainContainer, "input");
});

        submitBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());

                String gender = maleBtn.isSelected() ? "Male" :
                        femaleBtn.isSelected() ? "Female" : "Not selected";

                String dietType = vegBtn.isSelected() ? "Veg" :
                        nonVegBtn.isSelected() ? "Non-Veg" : "Not selected";

                String goal = bulkBtn.isSelected() ? "Bulk" :
                        cutBtn.isSelected() ? "Cut" :
                                maintainBtn.isSelected() ? "Maintain" : "Not selected";

                String experience = beginnerBtn.isSelected() ? "Beginner" :
                        intermediateBtn.isSelected() ? "Intermediate" :
                                advancedBtn.isSelected() ? "Advanced" : "Not selected";

                String days = daysBox.getSelectedItem().toString();

                if (gender.equals("Not selected") || dietType.equals("Not selected")
                        || goal.equals("Not selected") || experience.equals("Not selected")) {
                    JOptionPane.showMessageDialog(this, "Please select all options.");
                    return;
                }

                double bmi = calculateBMI(height, weight);
                String bmiCategory = getBMICategory(bmi);
                String ageCategory = getAgeCategory(age);
                String weightCategory = getWeightCategory(weight);

                double protein = calculateProtein(weight, age, goal);
                double calories = calculateCalories(weight, age, goal);

                String mealPlan = generateMealPlan(ageCategory, goal, dietType, protein, calories);
                String workoutPlan = generateWorkoutPlan(ageCategory, goal, experience, days);

                resultArea.setText(
                        "===== FITFORGE FITNESS REPORT =====\n\n" +
                                "Name: " + name +
                                "\nAge: " + age +
                                "\nAge Category: " + ageCategory +
                                "\nGender: " + gender +
                                "\nDiet Type: " + dietType +
                                "\nHeight: " + height + " cm" +
                                "\nWeight: " + weight + " kg" +
                                "\nWeight Category: " + weightCategory +
                                "\n\nBMI: " + String.format("%.2f", bmi) +
                                "\nBMI Category: " + bmiCategory +
                                "\nCalories Target: " + String.format("%.0f", calories) + " kcal" +
                                "\nProtein Goal: " + String.format("%.0f", protein) + " g" +
                                "\n\nGoal: " + goal +
                                "\nExperience: " + experience +
                                "\nWorkout Days: " + days +
                                mealPlan +
                                workoutPlan
                );
                cardLayout.show(mainContainer, "report");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid numbers for age, height, and weight.");
            }
        });

        setVisible(true);
    }

    public void addLabel(String text, int x, int y) {
    JLabel label = new JLabel(text);
    label.setBounds(x, y, 120, 25);
    inputPage.add(label);
}

    public JTextField addTextField(int x, int y) {
    JTextField field = new JTextField();
    field.setBounds(x, y, 200, 25);
    inputPage.add(field);
    return field;
}

    public double calculateBMI(double heightCm, double weight) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }

    public String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public String getAgeCategory(int age) {
        if (age < 13) return "Child";
        else if (age < 18) return "Teenager";
        else if (age < 60) return "Adult";
        else return "Senior";
    }

    public double calculateProtein(double weight, int age, String goal) {
        if (age < 13) return weight * 1.0;
        else if (age < 18) return weight * 1.5;
        else if (age >= 60) return weight * 1.2;

        if (goal.equals("Bulk")) return weight * 2.0;
        else if (goal.equals("Cut")) return weight * 1.8;
        else return weight * 1.6;
    }

    public double calculateCalories(double weight, int age, String goal) {
        if (age < 13) return weight * 35;
        else if (age < 18) return weight * 38;
        else if (age >= 60) return weight * 28;

        if (goal.equals("Bulk")) return weight * 40;
        else if (goal.equals("Cut")) return weight * 30;
        else return weight * 35;
    }

    public String getWeightCategory(double weight) {
        if (weight <= 40) return "Below 40 kg";
        else if (weight <= 50) return "41-50 kg";
        else if (weight <= 60) return "51-60 kg";
        else if (weight <= 70) return "61-70 kg";
        else if (weight <= 80) return "71-80 kg";
        else if (weight <= 90) return "81-90 kg";
        else if (weight <= 100) return "91-100 kg";
        else if (weight <= 110) return "101-110 kg";
        else if (weight <= 120) return "111-120 kg";
        else if (weight <= 130) return "121-130 kg";
        else if (weight <= 140) return "131-140 kg";
        else return "Above 140 kg";
    }

    public String generateMealPlan(String ageCategory, String goal, String dietType,
                                   double protein, double calories) {

        if (ageCategory.equals("Child")) {
            return "\n\n===== CHILD MEAL PLAN OPTIONS =====" +
                    "\nFocus: Growth, energy, immunity, and bone health." +

                    "\n\n[OPTION 1]" +
                    "\nBreakfast: Milk + Banana + Idli" +
                    "\nLunch: Rice + Dal + Vegetables + Curd" +
                    "\nSnack: Fruit + Nuts" +
                    "\nDinner: Chapati + Dal + Vegetables" +

                    "\n\n[OPTION 2]" +
                    "\nBreakfast: Oats + Milk + Apple" +
                    "\nLunch: Rice + Sambar + Curd" +
                    "\nSnack: Peanut Chikki / Fruit" +
                    "\nDinner: Rice + Egg/Paneer + Vegetables" +

                    "\n\nAvoid: Heavy dieting, bodybuilding diet, excess supplements." +
                    "\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                    "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
        }

        if (ageCategory.equals("Teenager")) {
            if (dietType.equals("Veg")) {
                return "\n\n===== TEEN VEG MEAL OPTIONS =====" +
                        "\nFocus: Growth + fitness. Avoid extreme dieting." +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Oats + Milk + Banana" +
                        "\nLunch: Rice + Dal + Paneer + Vegetables" +
                        "\nSnack: Curd + Peanuts" +
                        "\nDinner: Chapati/Rice + Rajma/Chana" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Dosa + Peanut Chutney + Milk" +
                        "\nLunch: Rice + Sambar + Curd" +
                        "\nSnack: Banana Shake" +
                        "\nDinner: Chapati + Paneer + Vegetables" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: Idli + Sambar + Milk" +
                        "\nLunch: Rice + Dal + Soya Chunks" +
                        "\nSnack: Fruits + Nuts" +
                        "\nDinner: Rice + Chana + Vegetables" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            } else {
                return "\n\n===== TEEN NON-VEG MEAL OPTIONS =====" +
                        "\nFocus: Growth + fitness. Avoid extreme dieting." +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Eggs + Milk + Banana" +
                        "\nLunch: Rice + Chicken + Vegetables" +
                        "\nSnack: Curd + Fruits" +
                        "\nDinner: Rice/Chapati + Eggs/Fish" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Oats + Milk + 2 Eggs" +
                        "\nLunch: Rice + Egg Curry + Dal" +
                        "\nSnack: Banana + Peanuts" +
                        "\nDinner: Chapati + Chicken + Vegetables" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: Dosa + Omelette + Milk" +
                        "\nLunch: Rice + Fish Curry + Vegetables" +
                        "\nSnack: Curd + Fruit" +
                        "\nDinner: Rice + Eggs + Dal" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }
        }

        if (ageCategory.equals("Adult")) {

            if (goal.equals("Bulk") && dietType.equals("Veg")) {
                return "\n\n===== ADULT VEG BULKING MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Oats + Milk + Banana + Peanut Butter" +
                        "\nLunch: Rice + Dal + Paneer + Curd" +
                        "\nSnack: Milk + Dry Fruits" +
                        "\nDinner: Rice + Rajma + Vegetables" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: 3 Chapatis + Paneer Bhurji + Milk" +
                        "\nLunch: Rice + Chana + Curd" +
                        "\nSnack: Banana Shake + Peanuts" +
                        "\nDinner: Chapati + Dal + Soya Chunks" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: Dosa + Peanut Chutney + Milk" +
                        "\nLunch: Rice + Sambar + Paneer" +
                        "\nSnack: Curd + Nuts" +
                        "\nDinner: Rice + Dal + Vegetables + Ghee" +

                        "\n\n[OPTION 4]" +
                        "\nBreakfast: Upma + Milk + Banana" +
                        "\nLunch: Rice + Rajma + Curd" +
                        "\nSnack: Peanut Butter Sandwich" +
                        "\nDinner: Chapati + Paneer + Vegetables" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }

            if (goal.equals("Bulk") && dietType.equals("Non-Veg")) {
                return "\n\n===== ADULT NON-VEG BULKING MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: 5 Eggs + Bread/Chapati + 300 ml Milk + Banana" +
                        "\nLunch: Rice + 150 g Chicken + Vegetables" +
                        "\nSnack: Peanut Butter Sandwich + Curd" +
                        "\nDinner: Rice + Chicken/Fish + Vegetables" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Oats + Milk + 3 Boiled Eggs" +
                        "\nLunch: Rice + Egg Curry + Dal" +
                        "\nSnack: Banana Shake + Peanuts" +
                        "\nDinner: Chapati + Chicken + Curd" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: Dosa + Omelette + Milk" +
                        "\nLunch: Rice + Fish Curry + Vegetables" +
                        "\nSnack: Curd + Nuts" +
                        "\nDinner: Rice + 3 Eggs + Dal" +

                        "\n\n[OPTION 4]" +
                        "\nBreakfast: Upma + 4 Eggs + Banana" +
                        "\nLunch: Rice + Chicken Breast + Curd" +
                        "\nSnack: Milk + Peanut Butter" +
                        "\nDinner: Chapati + Fish/Chicken + Vegetables" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }

            if (goal.equals("Cut") && dietType.equals("Veg")) {
                return "\n\n===== ADULT VEG CUTTING MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Oats + Fruits" +
                        "\nLunch: Dal + Vegetables + Small Rice" +
                        "\nSnack: Sprouts / Buttermilk" +
                        "\nDinner: Paneer + Salad" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Milk + Apple + Nuts" +
                        "\nLunch: Chapati + Dal + Curd" +
                        "\nSnack: Fruits" +
                        "\nDinner: Soya Chunks + Vegetables" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: Idli + Sambar" +
                        "\nLunch: Rice + Dal + Salad" +
                        "\nSnack: Buttermilk" +
                        "\nDinner: Paneer + Vegetables" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }

            if (goal.equals("Cut") && dietType.equals("Non-Veg")) {
                return "\n\n===== ADULT NON-VEG CUTTING MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Boiled Eggs + Fruits" +
                        "\nLunch: Chicken + Salad + Small Rice" +
                        "\nSnack: Buttermilk / Curd" +
                        "\nDinner: Eggs + Vegetables" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Omelette + Milk" +
                        "\nLunch: Fish + Vegetables + Small Rice" +
                        "\nSnack: Curd" +
                        "\nDinner: Chicken Soup + Salad" +

                        "\n\n[OPTION 3]" +
                        "\nBreakfast: 3 Eggs + Apple" +
                        "\nLunch: Grilled Chicken + Dal" +
                        "\nSnack: Buttermilk" +
                        "\nDinner: Fish/Eggs + Vegetables" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }

            if (dietType.equals("Veg")) {
                return "\n\n===== ADULT VEG MAINTENANCE MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Milk + Oats + Banana" +
                        "\nLunch: Rice + Dal + Curd + Vegetables" +
                        "\nSnack: Fruits + Nuts" +
                        "\nDinner: Chapati + Paneer + Vegetables" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Idli/Dosa + Milk" +
                        "\nLunch: Rice + Rajma + Curd" +
                        "\nSnack: Buttermilk + Peanuts" +
                        "\nDinner: Chapati + Dal + Salad" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            } else {
                return "\n\n===== ADULT NON-VEG MAINTENANCE MEAL OPTIONS =====" +

                        "\n\n[OPTION 1]" +
                        "\nBreakfast: Eggs + Milk + Fruit" +
                        "\nLunch: Rice + Chicken + Vegetables + Curd" +
                        "\nSnack: Fruits + Nuts" +
                        "\nDinner: Chapati + Eggs/Fish + Vegetables" +

                        "\n\n[OPTION 2]" +
                        "\nBreakfast: Oats + Milk + Boiled Eggs" +
                        "\nLunch: Rice + Fish Curry + Vegetables" +
                        "\nSnack: Curd + Fruit" +
                        "\nDinner: Rice/Chapati + Chicken + Salad" +

                        "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                        "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
            }
        }

        return "\n\n===== SENIOR MEAL PLAN OPTIONS =====" +
                "\nFocus: Easy digestion, strength, heart health, and joint support." +

                "\n\n[OPTION 1]" +
                "\nBreakfast: Oats + Milk + Fruits" +
                "\nLunch: Rice/Chapati + Dal + Vegetables + Curd" +
                "\nSnack: Fruits / Buttermilk" +
                "\nDinner: Light Protein + Vegetables" +

                "\n\n[OPTION 2]" +
                "\nBreakfast: Idli + Sambar" +
                "\nLunch: Soft Rice + Dal + Curd" +
                "\nSnack: Banana / Buttermilk" +
                "\nDinner: Chapati + Vegetables + Light Dal" +

                "\n\nRequired Protein: " + String.format("%.0f", protein) + " g" +
                "\nRequired Calories: " + String.format("%.0f", calories) + " kcal";
    }

    public String generateWorkoutPlan(String ageCategory, String goal, String experience, String days) {

        if (ageCategory.equals("Child")) {
            return "\n\n===== CHILD ACTIVITY PLAN =====" +
                    "\nNo heavy gym workout recommended." +
                    "\nRecommended Activities:" +
                    "\n- Outdoor games" +
                    "\n- Running" +
                    "\n- Cycling" +
                    "\n- Swimming" +
                    "\n- Stretching" +
                    "\nDuration: 30-45 minutes daily.";
        }

        if (ageCategory.equals("Teenager")) {
            if (experience.equals("Beginner")) {
                return "\n\n===== TEEN BEGINNER WORKOUT PLAN =====" +
                        "\nFocus: Bodyweight strength and safe form." +
                        "\n- Push-ups: 3 sets x 10 reps" +
                        "\n- Squats: 3 sets x 15 reps" +
                        "\n- Plank: 3 sets x 30 seconds" +
                        "\n- Jogging/Cycling: 20 minutes";
            } else if (experience.equals("Intermediate")) {
                return "\n\n===== TEEN INTERMEDIATE WORKOUT PLAN =====" +
                        "\nFocus: Controlled gym training." +
                        "\nDay 1: Upper Body" +
                        "\nDay 2: Lower Body" +
                        "\nDay 3: Cardio + Core" +
                        "\nDay 4: Full Body";
            } else {
                return "\n\n===== TEEN ADVANCED WORKOUT PLAN =====" +
                        "\nFocus: Strength + muscle gain safely." +
                        "\nDay 1: Push" +
                        "\nDay 2: Pull" +
                        "\nDay 3: Legs" +
                        "\nDay 4: Upper Body" +
                        "\nDay 5: Lower Body";
            }
        }

        if (ageCategory.equals("Adult")) {
            if (goal.equals("Bulk")) {
                return "\n\n===== ADULT BULKING WORKOUT PLAN =====" +
                        "\nGoal: Muscle gain with progressive overload" +
                        "\n3 Days: Full Body Split" +
                        "\n4 Days: Upper / Lower Split" +
                        "\n5 Days: Push Pull Legs + Upper Lower" +
                        "\n6 Days: Push Pull Legs Repeat" +
                        "\nSelected: " + days +
                        "\nExperience Level: " + experience;
            }

            if (goal.equals("Cut")) {
                return "\n\n===== ADULT CUTTING WORKOUT PLAN =====" +
                        "\nGoal: Fat loss while maintaining muscle" +
                        "\nDay 1: Full Body Strength" +
                        "\nDay 2: Cardio + Core" +
                        "\nDay 3: Upper Body + Cardio" +
                        "\nDay 4: Lower Body + Cardio" +
                        "\nSelected: " + days +
                        "\nExperience Level: " + experience;
            }

            return "\n\n===== ADULT MAINTENANCE WORKOUT PLAN =====" +
                    "\nGoal: Maintain strength and fitness" +
                    "\nDay 1: Push Workout" +
                    "\nDay 2: Pull Workout" +
                    "\nDay 3: Legs" +
                    "\nDay 4: Cardio + Core" +
                    "\nSelected: " + days +
                    "\nExperience Level: " + experience;
        }

        return "\n\n===== SENIOR FITNESS PLAN =====" +
                "\nGoal: Mobility, balance, and light strength." +
                "\n- Walking: 20-30 minutes" +
                "\n- Light stretching" +
                "\n- Chair squats: 2 sets x 10 reps" +
                "\n- Wall push-ups: 2 sets x 10 reps" +
                "\n- Balance practice: 5-10 minutes";
    }

    public static void main(String[] args) {
        new FitForgeGUI();
    }
}