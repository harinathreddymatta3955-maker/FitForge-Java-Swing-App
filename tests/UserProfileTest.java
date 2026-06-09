import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserProfile Calculations Test Suite")
public class UserProfileTest {

    private UserProfile profile;

    @BeforeEach
    void setUp() {
        profile = new UserProfile("John Doe", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
    }

    // ==================== BMI CALCULATION TESTS ====================

    @Test
    @DisplayName("BMI Calculation - Normal weight person")
    void testBMICalculationNormal() {
        // Height: 170cm, Weight: 70kg => BMI = 70 / (1.7 * 1.7) = 24.22
        UserProfile normalProfile = new UserProfile("Alice", 25, "Female", 170, 70, "Maintain", "Veg", "Beginner", 3);
        double bmi = normalProfile.calculateBMI();
        assertTrue(bmi >= 18.5 && bmi < 25, "BMI should be in normal range (18.5-24.9)");
        assertEquals(24.22, Math.round(bmi * 100.0) / 100.0, 0.1);
    }

    @Test
    @DisplayName("BMI Calculation - Overweight person")
    void testBMICalculationOverweight() {
        // Height: 170cm, Weight: 90kg => BMI = 90 / (1.7 * 1.7) = 31.14 (Obese)
        UserProfile overweightProfile = new UserProfile("Bob", 40, "Male", 170, 90, "Cut", "Non-Veg", "Advanced", 6);
        double bmi = overweightProfile.calculateBMI();
        assertTrue(bmi > 25, "BMI should indicate overweight or obese");
    }

    @Test
    @DisplayName("BMI Calculation - Underweight person")
    void testBMICalculationUnderweight() {
        // Height: 180cm, Weight: 50kg => BMI = 50 / (1.8 * 1.8) = 15.43
        UserProfile underweightProfile = new UserProfile("Charlie", 20, "Male", 180, 50, "Bulk", "Veg", "Beginner", 3);
        double bmi = underweightProfile.calculateBMI();
        assertTrue(bmi < 18.5, "BMI should indicate underweight");
        assertEquals(15.43, Math.round(bmi * 100.0) / 100.0, 0.1);
    }

    @Test
    @DisplayName("BMI Calculation - Different heights and weights")
    void testBMICalculationVariations() {
        double[][] testCases = {
            {150, 50}, // BMI ≈ 22.2
            {180, 80}, // BMI ≈ 24.7
            {200, 100} // BMI = 25.0
        };

        for (double[] testCase : testCases) {
            UserProfile testProfile = new UserProfile("Test", 30, "Male", testCase[0], testCase[1], "Maintain", "Veg", "Beginner", 3);
            double bmi = testProfile.calculateBMI();
            assertTrue(bmi > 0, "BMI should be positive");
            assertTrue(bmi < 100, "BMI should be realistic");
        }
    }

    // ==================== PROTEIN GOAL CALCULATION TESTS ====================

    @Test
    @DisplayName("Protein Goal - Bulking phase")
    void testProteinGoalBulking() {
        // Weight: 80kg, Goal: Bulk => Protein = 80 * 2.0 = 160g
        UserProfile bulkProfile = new UserProfile("Bulk User", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
        double protein = bulkProfile.calculateProteinGoal();
        assertEquals(160.0, protein, "Bulking: Protein should be 2.0g per kg");
    }

    @Test
    @DisplayName("Protein Goal - Bulking phase (case insensitive)")
    void testProteinGoalBulkingCaseInsensitive() {
        UserProfile bulkProfile = new UserProfile("User", 30, "Male", 180, 80, "BULK", "Veg", "Beginner", 3);
        double protein = bulkProfile.calculateProteinGoal();
        assertEquals(160.0, protein, "Should handle case insensitivity");

        UserProfile bulkingProfile = new UserProfile("User2", 30, "Male", 180, 80, "BULKING", "Veg", "Beginner", 3);
        protein = bulkingProfile.calculateProteinGoal();
        assertEquals(160.0, protein, "Should handle 'BULKING' variant");
    }

    @Test
    @DisplayName("Protein Goal - Cutting phase")
    void testProteinGoalCutting() {
        // Weight: 80kg, Goal: Cut => Protein = 80 * 1.8 = 144g
        UserProfile cutProfile = new UserProfile("Cut User", 30, "Male", 180, 80, "Cut", "Veg", "Intermediate", 5);
        double protein = cutProfile.calculateProteinGoal();
        assertEquals(144.0, protein, "Cutting: Protein should be 1.8g per kg");
    }

    @Test
    @DisplayName("Protein Goal - Cutting phase (case insensitive)")
    void testProteinGoalCuttingCaseInsensitive() {
        UserProfile cutProfile = new UserProfile("User", 30, "Male", 180, 80, "CUT", "Veg", "Beginner", 3);
        double protein = cutProfile.calculateProteinGoal();
        assertEquals(144.0, protein, "Should handle case insensitivity");

        UserProfile cuttingProfile = new UserProfile("User2", 30, "Male", 180, 80, "CUTTING", "Veg", "Beginner", 3);
        protein = cuttingProfile.calculateProteinGoal();
        assertEquals(144.0, protein, "Should handle 'CUTTING' variant");
    }

    @Test
    @DisplayName("Protein Goal - Maintenance phase")
    void testProteinGoalMaintenance() {
        // Weight: 80kg, Goal: Maintain => Protein = 80 * 1.6 = 128g
        UserProfile maintainProfile = new UserProfile("Maintain User", 30, "Male", 180, 80, "Maintain", "Veg", "Intermediate", 5);
        double protein = maintainProfile.calculateProteinGoal();
        assertEquals(128.0, protein, "Maintenance: Protein should be 1.6g per kg");
    }

    @Test
    @DisplayName("Protein Goal - Maintenance phase (case insensitive)")
    void testProteinGoalMaintenanceCaseInsensitive() {
        UserProfile maintainProfile = new UserProfile("User", 30, "Male", 180, 80, "MAINTAIN", "Veg", "Beginner", 3);
        double protein = maintainProfile.calculateProteinGoal();
        assertEquals(128.0, protein, "Should handle case insensitivity");

        UserProfile maintenanceProfile = new UserProfile("User2", 30, "Male", 180, 80, "MAINTENANCE", "Veg", "Beginner", 3);
        protein = maintenanceProfile.calculateProteinGoal();
        assertEquals(128.0, protein, "Should handle 'MAINTENANCE' variant");
    }

    @Test
    @DisplayName("Protein Goal - Different weights")
    void testProteinGoalDifferentWeights() {
        double[] weights = {50, 70, 80, 90, 100};
        double goalMultiplier = 2.0; // Bulk

        for (double weight : weights) {
            UserProfile testProfile = new UserProfile("Test", 30, "Male", 180, weight, "Bulk", "Veg", "Beginner", 3);
            double protein = testProfile.calculateProteinGoal();
            assertEquals(weight * goalMultiplier, protein, "Protein should be accurate for weight: " + weight);
        }
    }

    // ==================== EDGE CASES & VALIDATION ====================

    @Test
    @DisplayName("Edge Case - Very light person")
    void testVeryLightPerson() {
        UserProfile lightProfile = new UserProfile("Light", 20, "Female", 150, 40, "Bulk", "Veg", "Beginner", 3);
        double protein = lightProfile.calculateProteinGoal();
        assertEquals(80.0, protein, "Should calculate protein for light person");
        
        double bmi = lightProfile.calculateBMI();
        assertTrue(bmi > 0, "BMI should be valid");
    }

    @Test
    @DisplayName("Edge Case - Very heavy person")
    void testVeryHeavyPerson() {
        UserProfile heavyProfile = new UserProfile("Heavy", 50, "Male", 200, 150, "Cut", "Non-Veg", "Advanced", 6);
        double protein = heavyProfile.calculateProteinGoal();
        assertEquals(270.0, protein, "Should calculate protein for heavy person");
        
        double bmi = heavyProfile.calculateBMI();
        assertTrue(bmi > 0, "BMI should be valid");
    }

    @Test
    @DisplayName("Protein Calculation - All goal types consistency")
    void testProteinConsistencyAcrossGoals() {
        UserProfile baseProfile = new UserProfile("Test", 30, "Male", 180, 100, "Maintain", "Veg", "Beginner", 3);
        
        UserProfile bulkProfile = new UserProfile("Test", 30, "Male", 180, 100, "Bulk", "Veg", "Beginner", 3);
        UserProfile cutProfile = new UserProfile("Test", 30, "Male", 180, 100, "Cut", "Veg", "Beginner", 3);
        UserProfile maintainProfile = new UserProfile("Test", 30, "Male", 180, 100, "Maintain", "Veg", "Beginner", 3);

        double bulkProtein = bulkProfile.calculateProteinGoal();
        double cutProtein = cutProfile.calculateProteinGoal();
        double maintainProtein = maintainProfile.calculateProteinGoal();

        assertTrue(bulkProtein > cutProtein, "Bulking protein should be > Cutting protein");
        assertTrue(cutProtein > maintainProtein, "Cutting protein should be > Maintenance protein");
        assertTrue(bulkProtein > maintainProtein, "Bulking protein should be > Maintenance protein");
    }

    @Test
    @DisplayName("Profile attributes stored correctly")
    void testProfileAttributesStorage() {
        assertEquals("John Doe", profile.name);
        assertEquals(30, profile.age);
        assertEquals("Male", profile.gender);
        assertEquals(180, profile.height);
        assertEquals(80, profile.weight);
        assertEquals("Bulk", profile.goal);
        assertEquals("Veg", profile.dietType);
        assertEquals("Intermediate", profile.experience);
        assertEquals(5, profile.workoutDays);
    }
}
