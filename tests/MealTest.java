import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Meal Model Test Suite")
public class MealTest {

    private Meal meal;

    @BeforeEach
    void setUp() {
        meal = new Meal("Chicken Rice", 45.5, 800.0);
    }

    @Test
    @DisplayName("Meal Creation - Attributes stored correctly")
    void testMealCreation() {
        assertEquals("Chicken Rice", meal.foodName, "Food name should match");
        assertEquals(45.5, meal.protein, "Protein should match");
        assertEquals(800.0, meal.calories, "Calories should match");
    }

    @Test
    @DisplayName("Meal - Zero protein")
    void testMealZeroProtein() {
        Meal lowProteinMeal = new Meal("Salad", 0, 100.0);
        assertEquals(0, lowProteinMeal.protein, "Should allow zero protein");
        assertEquals(100.0, lowProteinMeal.calories, "Calories should be set");
    }

    @Test
    @DisplayName("Meal - High protein vegetarian")
    void testHighProteinVegetarian() {
        Meal vegMeal = new Meal("Paneer Tikka", 28.0, 350.0);
        assertEquals("Paneer Tikka", vegMeal.foodName);
        assertEquals(28.0, vegMeal.protein, "Vegetarian protein should be stored");
        assertEquals(350.0, vegMeal.calories);
    }

    @Test
    @DisplayName("Meal - Zero calories")
    void testMealZeroCalories() {
        Meal zeroCal = new Meal("Water", 0, 0);
        assertEquals(0, zeroCal.calories, "Should allow zero calories");
        assertEquals(0, zeroCal.protein, "Should allow zero protein");
    }

    @Test
    @DisplayName("Meal - Large values")
    void testMealLargeValues() {
        Meal largeMeal = new Meal("Bulk Meal", 200.0, 5000.0);
        assertEquals(200.0, largeMeal.protein, "Should handle large protein values");
        assertEquals(5000.0, largeMeal.calories, "Should handle large calorie values");
    }

    @Test
    @DisplayName("Meal - Decimal precision")
    void testMealDecimalPrecision() {
        Meal precisionMeal = new Meal("Test", 25.75, 350.25);
        assertEquals(25.75, precisionMeal.protein, 0.01, "Should maintain decimal precision");
        assertEquals(350.25, precisionMeal.calories, 0.01, "Should maintain calorie precision");
    }

    @Test
    @DisplayName("Meal - Different food names")
    void testMealDifferentFoodNames() {
        String[] foods = {"Eggs", "Milk", "Oats", "Almonds", "Broccoli", "Chicken", "Fish", "Paneer"};
        
        for (String food : foods) {
            Meal testMeal = new Meal(food, 20.0, 300.0);
            assertEquals(food, testMeal.foodName, "Food name should be stored correctly");
        }
    }

    @Test
    @DisplayName("Meal - Protein calorie ratio")
    void testMealProteinCalorieRatio() {
        Meal meal1 = new Meal("High Protein", 50.0, 300.0);
        Meal meal2 = new Meal("Low Protein", 10.0, 300.0);
        
        assertEquals(50.0, meal1.protein);
        assertEquals(10.0, meal2.protein);
        assertEquals(300.0, meal1.calories);
        assertEquals(300.0, meal2.calories);
    }
}

