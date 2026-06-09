import javax.swing.*;
import java.awt.*;

public class FitForgeGUI extends JFrame {

    JTextField nameField, ageField, heightField, weightField;
    JRadioButton maleBtn, femaleBtn, vegBtn, nonVegBtn;
    JRadioButton bulkBtn, cutBtn, maintainBtn;
    JRadioButton beginnerBtn, intermediateBtn, advancedBtn;
    JComboBox<String> daysBox;
    JTextArea resultArea;

    CardLayout cardLayout;
    JPanel mainContainer, inputPage, reportPage;

    public FitForgeGUI() {
        setTitle("FitForge");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        inputPage = new GradientPanel();
        inputPage.setLayout(null);

        reportPage = new ReportPanel();
        reportPage.setLayout(null);

        mainContainer.add(inputPage, "input");
        mainContainer.add(reportPage, "report");

        setContentPane(mainContainer);

        buildInputPage();
        buildReportPage();

        setVisible(true);
    }

    class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            GradientPaint gp = new GradientPaint(
                    0, 0, new Color(10, 10, 10),
                    getWidth(), getHeight(), new Color(45, 45, 45)
            );

            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setColor(new Color(220, 20, 60));
            g2d.fillRect(0, 0, getWidth(), 8);

            g2d.setColor(new Color(255, 255, 255, 35));
            g2d.setFont(new Font("Segoe UI", Font.BOLD, 70));
            g2d.drawString("FITFORGE", 690, 170);

            g2d.setFont(new Font("Segoe UI", Font.BOLD, 32));
            g2d.drawString("DISCIPLINE", 720, 270);
            g2d.drawString("FOCUS", 720, 330);
            g2d.drawString("CONSISTENCY", 720, 390);
            g2d.drawString("SUCCESS", 720, 450);
        }
    }

    class ReportPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            GradientPaint gp = new GradientPaint(
                    0, 0, new Color(5, 15, 35),
                    getWidth(), getHeight(), Color.BLACK
            );

            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setColor(new Color(0, 255, 200, 25));
            g2d.setFont(new Font("Segoe UI", Font.BOLD, 80));
            g2d.drawString("FITFORGE", 720, 160);

            g2d.setFont(new Font("Segoe UI", Font.BOLD, 32));
            g2d.drawString("BMI", 850, 280);
            g2d.drawString("CALORIES", 800, 350);
            g2d.drawString("PROTEIN", 810, 420);
        }
    }

    public void buildInputPage() {
        JLabel title = new JLabel("FITFORGE");
        title.setBounds(260, 40, 300, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 42));
        title.setForeground(new Color(255, 60, 60));
        inputPage.add(title);

        JLabel subtitle = new JLabel("Build Your Best Self");
        subtitle.setBounds(270, 90, 300, 30);
        subtitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        subtitle.setForeground(Color.WHITE);
        inputPage.add(subtitle);

        addLabel("Name:", 80, 150);
        nameField = addTextField(240, 150);

        addLabel("Age:", 80, 200);
        ageField = addTextField(240, 200);

        addLabel("Height (cm):", 80, 250);
        heightField = addTextField(240, 250);

        addLabel("Weight (kg):", 80, 300);
        weightField = addTextField(240, 300);

        addLabel("Gender:", 80, 350);
        maleBtn = radio("Male", 240, 350);
        femaleBtn = radio("Female", 340, 350);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        inputPage.add(maleBtn);
        inputPage.add(femaleBtn);

        addLabel("Diet Type:", 80, 400);
        vegBtn = radio("Veg", 240, 400);
        nonVegBtn = radio("Non-Veg", 340, 400);
        ButtonGroup dietGroup = new ButtonGroup();
        dietGroup.add(vegBtn);
        dietGroup.add(nonVegBtn);
        inputPage.add(vegBtn);
        inputPage.add(nonVegBtn);

        addLabel("Goal:", 80, 450);
        bulkBtn = radio("Bulk", 240, 450);
        cutBtn = radio("Cut", 330, 450);
        maintainBtn = radio("Maintain", 410, 450);
        ButtonGroup goalGroup = new ButtonGroup();
        goalGroup.add(bulkBtn);
        goalGroup.add(cutBtn);
        goalGroup.add(maintainBtn);
        inputPage.add(bulkBtn);
        inputPage.add(cutBtn);
        inputPage.add(maintainBtn);

        addLabel("Experience:", 80, 500);
        beginnerBtn = radio("Beginner", 240, 500);
        intermediateBtn = radio("Intermediate", 360, 500);
        advancedBtn = radio("Advanced", 510, 500);
        ButtonGroup expGroup = new ButtonGroup();
        expGroup.add(beginnerBtn);
        expGroup.add(intermediateBtn);
        expGroup.add(advancedBtn);
        inputPage.add(beginnerBtn);
        inputPage.add(intermediateBtn);
        inputPage.add(advancedBtn);

        addLabel("Workout Days:", 80, 550);
        daysBox = new JComboBox<>(new String[]{"3 Days", "4 Days", "5 Days", "6 Days"});
        daysBox.setBounds(240, 550, 180, 32);
        daysBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
        inputPage.add(daysBox);

        JButton generateBtn = new JButton("Generate Fitness Report");
        generateBtn.setBounds(240, 610, 260, 42);
        generateBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        generateBtn.setBackground(new Color(220, 20, 60));
        generateBtn.setForeground(Color.WHITE);
        inputPage.add(generateBtn);

        generateBtn.addActionListener(e -> generateReport());
    }

    public void buildReportPage() {
        JLabel title = new JLabel("FITFORGE FITNESS REPORT");
        title.setBounds(50, 20, 600, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(0, 255, 200));
        reportPage.add(title);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBackground(new Color(8, 18, 35));
        resultArea.setForeground(new Color(240, 240, 240));
        resultArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        resultArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane reportScroll = new JScrollPane(resultArea);
        reportScroll.setBounds(50, 80, 1050, 500);
        reportScroll.setBorder(BorderFactory.createLineBorder(new Color(0, 220, 180), 3));
        reportPage.add(reportScroll);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(50, 610, 130, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.setBackground(new Color(220, 20, 60));
        backBtn.setForeground(Color.WHITE);
        reportPage.add(backBtn);

        backBtn.addActionListener(e -> cardLayout.show(mainContainer, "input"));
    }

    public void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        inputPage.add(label);
    }

    public JTextField addTextField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 280, 32);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(new Color(30, 30, 30));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 1));
        inputPage.add(field);
        return field;
    }

    public JRadioButton radio(String text, int x, int y) {
        JRadioButton btn = new JRadioButton(text);
        btn.setBounds(x, y, 140, 30);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setOpaque(false);
        return btn;
    }

    public void generateReport() {
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

            if (gender.equals("Not selected") || dietType.equals("Not selected") ||
                    goal.equals("Not selected") || experience.equals("Not selected")) {
                JOptionPane.showMessageDialog(this, "Please select all options.");
                return;
            }

            double bmi = calculateBMI(height, weight);
            String ageCategory = getAgeCategory(age);
            String bmiCategory = getBMICategory(bmi);
            String weightCategory = getWeightCategory(weight);
            double protein = calculateProtein(weight, age, goal);
            double calories = calculateCalories(weight, age, goal);

            String mealPlan = generateMealPlan(ageCategory, goal, dietType, protein, calories);
            String workoutPlan = generateWorkoutPlan(ageCategory, goal, experience, days);

            resultArea.setText(
                    "================ FITFORGE FITNESS REPORT ================\n\n" +
                            "PERSONAL DETAILS\n" +
                            "---------------------------------------------------------\n" +
                            "Name            : " + name + "\n" +
                            "Age             : " + age + "\n" +
                            "Age Category    : " + ageCategory + "\n" +
                            "Gender          : " + gender + "\n" +
                            "Diet Type       : " + dietType + "\n" +
                            "Height          : " + height + " cm\n" +
                            "Weight          : " + weight + " kg\n" +
                            "Weight Category : " + weightCategory + "\n\n" +

                            "ANALYSIS\n" +
                            "---------------------------------------------------------\n" +
                            "BMI             : " + String.format("%.2f", bmi) + "\n" +
                            "BMI Category    : " + bmiCategory + "\n" +
                            "Calories Target : " + String.format("%.0f", calories) + " kcal\n" +
                            "Protein Goal    : " + String.format("%.0f", protein) + " g\n\n" +

                            "GOALS\n" +
                            "---------------------------------------------------------\n" +
                            "Goal            : " + goal + "\n" +
                            "Experience      : " + experience + "\n" +
                            "Workout Days    : " + days + "\n" +

                            mealPlan +
                            workoutPlan
            );

            cardLayout.show(mainContainer, "report");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers for age, height and weight.");
        }
    }

    public double calculateBMI(double heightCm, double weightKg) {
        double heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }

    public String getAgeCategory(int age) {
        if (age < 13) return "Child";
        else if (age < 18) return "Teenager";
        else if (age < 60) return "Adult";
        else return "Senior";
    }

    public String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
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

    public double calculateProtein(double weight, int age, String goal) {
        if (age < 13) return weight * 1.0;
        if (age < 18) return weight * 1.5;
        if (age >= 60) return weight * 1.2;

        if (goal.equals("Bulk")) return weight * 2.0;
        if (goal.equals("Cut")) return weight * 1.8;
        return weight * 1.6;
    }

    public double calculateCalories(double weight, int age, String goal) {
        if (age < 13) return weight * 35;
        if (age < 18) return weight * 38;
        if (age >= 60) return weight * 28;

        if (goal.equals("Bulk")) return weight * 40;
        if (goal.equals("Cut")) return weight * 30;
        return weight * 35;
    }

    public String generateMealPlan(String ageCategory, String goal, String dietType,
                                   double protein, double calories) {

        if (ageCategory.equals("Child")) {
            return "\n\nCHILD MEAL PLAN\n" +
                    "---------------------------------------------------------\n" +
                    "Focus: Growth, immunity and energy.\n" +
                    "Breakfast : Milk + Banana + Idli/Oats\n" +
                    "Lunch     : Rice + Dal + Vegetables + Curd\n" +
                    "Snack     : Fruits + Nuts\n" +
                    "Dinner    : Chapati/Rice + Dal + Vegetables\n" +
                    "Avoid     : Heavy gym diet and supplements\n";
        }

        if (ageCategory.equals("Teenager")) {
            if (dietType.equals("Veg")) {
                return "\n\nTEEN VEG MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: Oats + Milk + Banana | Rice + Dal + Paneer\n" +
                        "Option 2: Dosa + Peanut Chutney | Rice + Sambar + Curd\n" +
                        "Option 3: Idli + Milk | Rice + Soya Chunks + Vegetables\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            } else {
                return "\n\nTEEN NON-VEG MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: Eggs + Milk + Banana | Rice + Chicken\n" +
                        "Option 2: Oats + Milk + Eggs | Rice + Egg Curry\n" +
                        "Option 3: Dosa + Omelette | Rice + Fish Curry\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            }
        }

        if (ageCategory.equals("Adult")) {
            if (goal.equals("Bulk") && dietType.equals("Non-Veg")) {
                return "\n\nADULT NON-VEG BULKING MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: 5 Eggs + Milk + Banana | Rice + Chicken + Curd\n" +
                        "Option 2: Oats + Milk + Eggs | Rice + Egg Curry + Dal\n" +
                        "Option 3: Dosa + Omelette | Rice + Fish Curry\n" +
                        "Option 4: Upma + Eggs | Rice + Chicken Breast\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            }

            if (goal.equals("Bulk") && dietType.equals("Veg")) {
                return "\n\nADULT VEG BULKING MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: Oats + Milk + Banana | Rice + Dal + Paneer\n" +
                        "Option 2: Chapati + Paneer Bhurji | Rice + Chana\n" +
                        "Option 3: Dosa + Milk | Rice + Sambar + Paneer\n" +
                        "Option 4: Upma + Banana | Rice + Rajma + Curd\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            }

            if (goal.equals("Cut") && dietType.equals("Non-Veg")) {
                return "\n\nADULT NON-VEG CUTTING MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: Boiled Eggs + Fruits | Chicken + Salad\n" +
                        "Option 2: Omelette + Milk | Fish + Vegetables\n" +
                        "Option 3: Eggs + Apple | Grilled Chicken + Dal\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            }

            if (goal.equals("Cut") && dietType.equals("Veg")) {
                return "\n\nADULT VEG CUTTING MEAL OPTIONS\n" +
                        "---------------------------------------------------------\n" +
                        "Option 1: Oats + Fruits | Dal + Vegetables + Small Rice\n" +
                        "Option 2: Milk + Apple | Chapati + Dal + Curd\n" +
                        "Option 3: Idli + Sambar | Paneer + Vegetables\n" +
                        "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                        "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
            }

            return "\n\nADULT MAINTENANCE MEAL OPTIONS\n" +
                    "---------------------------------------------------------\n" +
                    "Option 1: Milk + Oats | Rice + Dal + Curd + Vegetables\n" +
                    "Option 2: Idli/Dosa | Rice + Paneer/Chicken + Vegetables\n" +
                    "Required Protein : " + String.format("%.0f", protein) + " g\n" +
                    "Required Calories: " + String.format("%.0f", calories) + " kcal\n";
        }

        return "\n\nSENIOR MEAL PLAN\n" +
                "---------------------------------------------------------\n" +
                "Focus: Digestion, strength and joint health.\n" +
                "Breakfast : Oats + Milk + Fruits\n" +
                "Lunch     : Rice/Chapati + Dal + Vegetables + Curd\n" +
                "Snack     : Fruits / Buttermilk\n" +
                "Dinner    : Light protein + Vegetables\n";
    }

    public String generateWorkoutPlan(String ageCategory, String goal, String experience, String days) {
        if (ageCategory.equals("Child")) {
            return "\n\nCHILD ACTIVITY PLAN\n" +
                    "---------------------------------------------------------\n" +
                    "No heavy gym workout recommended.\n" +
                    "Activities: Running, cycling, swimming, outdoor games.\n" +
                    "Duration: 30-45 minutes daily.\n";
        }

        if (ageCategory.equals("Teenager")) {
            if (experience.equals("Beginner")) {
                return "\n\nTEEN BEGINNER WORKOUT PLAN\n" +
                        "---------------------------------------------------------\n" +
                        "Push-ups: 3 x 10\nSquats: 3 x 15\nPlank: 3 x 30 sec\nJogging: 20 min\n";
            } else if (experience.equals("Intermediate")) {
                return "\n\nTEEN INTERMEDIATE WORKOUT PLAN\n" +
                        "---------------------------------------------------------\n" +
                        "Day 1: Upper Body\nDay 2: Lower Body\nDay 3: Cardio + Core\nDay 4: Full Body\n";
            } else {
                return "\n\nTEEN ADVANCED WORKOUT PLAN\n" +
                        "---------------------------------------------------------\n" +
                        "Day 1: Push\nDay 2: Pull\nDay 3: Legs\nDay 4: Upper\nDay 5: Lower\n";
            }
        }

        if (ageCategory.equals("Adult")) {
            if (goal.equals("Bulk")) {
                return "\n\nADULT BULKING WORKOUT PLAN\n" +
                        "---------------------------------------------------------\n" +
                        "3 Days: Full Body Split\n4 Days: Upper/Lower Split\n5 Days: Push Pull Legs + Upper Lower\n6 Days: Push Pull Legs Repeat\nSelected: " + days + "\n";
            }

            if (goal.equals("Cut")) {
                return "\n\nADULT CUTTING WORKOUT PLAN\n" +
                        "---------------------------------------------------------\n" +
                        "Strength training + Cardio + Core work\nSelected: " + days + "\n";
            }

            return "\n\nADULT MAINTENANCE WORKOUT PLAN\n" +
                    "---------------------------------------------------------\n" +
                    "Push workout, Pull workout, Legs, Cardio + Core\nSelected: " + days + "\n";
        }

        return "\n\nSENIOR FITNESS PLAN\n" +
                "---------------------------------------------------------\n" +
                "Walking: 20-30 minutes\nStretching\nChair Squats: 2 x 10\nWall Pushups: 2 x 10\nBalance Practice: 5-10 minutes\n";
    }

    public static void main(String[] args) {
        new FitForgeGUI();
    }
}