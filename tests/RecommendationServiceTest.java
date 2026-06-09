import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecommendationService Test Suite")
public class RecommendationServiceTest {

    private UserProfile profile;
    private ArrayList<Workout> workouts;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        profile = new UserProfile("Test User", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
        workouts = new ArrayList<>();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    // ==================== BULKING PLAN TESTS ====================

    @Test
    @DisplayName("Bulking Plan - Light weight person (< 60kg)")
    void testBulkingPlanLightWeight() {
        UserProfile lightProfile = new UserProfile("Light", 25, "Male", 180, 55, "Bulk", "Veg", "Beginner", 3);
        ArrayList<Workout> lightWorkouts = new ArrayList<>();
        
        RecommendationService.showBulkingPlan(lightProfile, lightWorkouts);
        
        assertEquals(6, lightWorkouts.size(), "Should add 6 bulking workouts");
    }

    @Test
    @DisplayName("Bulking Plan - Normal weight person (>= 60kg)")
    void testBulkingPlanNormalWeight() {
        UserProfile normalProfile = new UserProfile("Normal", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
        ArrayList<Workout> normalWorkouts = new ArrayList<>();
        
        RecommendationService.showBulkingPlan(normalProfile, normalWorkouts);
        
        assertEquals(6, normalWorkouts.size(), "Should add 6 bulking workouts");
    }

    @Test
    @DisplayName("Bulking Workouts Added to List")
    void testBulkingWorkoutsAdded() {
        UserProfile bulkProfile = new UserProfile("Bulk", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
        ArrayList<Workout> bulkWorkouts = new ArrayList<>();
        
        RecommendationService.showBulkingPlan(bulkProfile, bulkWorkouts);
        
        assertEquals(6, bulkWorkouts.size(), "Should have 6 workouts");
        
        assertTrue(bulkWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Bench Press")), "Should include Bench Press");
        assertTrue(bulkWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Squats")), "Should include Squats");
        assertTrue(bulkWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Lat Pulldown")), "Should include Lat Pulldown");
    }

    // ==================== CUTTING PLAN TESTS ====================

    @Test
    @DisplayName("Cutting Plan - Overweight person (BMI > 25)")
    void testCuttingPlanOverweight() {
        // Height: 170cm, Weight: 90kg => BMI ≈ 31.1 (Obese)
        UserProfile overweightProfile = new UserProfile("Overweight", 35, "Male", 170, 90, "Cut", "Non-Veg", "Advanced", 5);
        ArrayList<Workout> cuttingWorkouts = new ArrayList<>();
        
        RecommendationService.showCuttingPlan(overweightProfile, cuttingWorkouts);
        
        assertEquals(6, cuttingWorkouts.size(), "Should add 6 cutting workouts");
    }

    @Test
    @DisplayName("Cutting Plan - Normal weight person (BMI <= 25)")
    void testCuttingPlanNormalWeight() {
        // Height: 180cm, Weight: 75kg => BMI ≈ 23.1 (Normal)
        UserProfile normalProfile = new UserProfile("Normal", 28, "Male", 180, 75, "Cut", "Veg", "Intermediate", 4);
        ArrayList<Workout> normalWorkouts = new ArrayList<>();
        
        RecommendationService.showCuttingPlan(normalProfile, normalWorkouts);
        
        assertEquals(6, normalWorkouts.size(), "Should add 6 cutting workouts");
    }

    @Test
    @DisplayName("Cutting Workouts Added to List")
    void testCuttingWorkoutsAdded() {
        UserProfile cutProfile = new UserProfile("Cut", 30, "Male", 180, 90, "Cut", "Non-Veg", "Advanced", 5);
        ArrayList<Workout> cutWorkouts = new ArrayList<>();
        
        RecommendationService.showCuttingPlan(cutProfile, cutWorkouts);
        
        assertEquals(6, cutWorkouts.size(), "Should have 6 workouts");
        
        assertTrue(cutWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Squats")), "Should include Squats");
        assertTrue(cutWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Treadmill Walking")), "Should include cardio");
        assertTrue(cutWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Cycling")), "Should include Cycling");
    }

    // ==================== MAINTENANCE PLAN TESTS ====================

    @Test
    @DisplayName("Maintenance Plan - Workouts Added")
    void testMaintenanceWorkoutsAdded() {
        UserProfile maintainProfile = new UserProfile("Maintain", 32, "Male", 180, 80, "Maintain", "Veg", "Intermediate", 4);
        ArrayList<Workout> maintainWorkouts = new ArrayList<>();
        
        RecommendationService.showMaintainPlan(maintainProfile, maintainWorkouts);
        
        assertEquals(6, maintainWorkouts.size(), "Should have 6 workouts");
        
        assertTrue(maintainWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Bench Press")), "Should include Bench Press");
        assertTrue(maintainWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Lat Pulldown")), "Should include Lat Pulldown");
        assertTrue(maintainWorkouts.stream().anyMatch(w -> w.exerciseName.equals("Squats")), "Should include Squats");
    }

    @Test
    @DisplayName("Maintenance Plan - Meal Recommendations")
    void testMaintenanceMealRecommendations() {
        UserProfile maintainProfile = new UserProfile("Maintain", 32, "Male", 180, 80, "Maintain", "Veg", "Intermediate", 4);
        ArrayList<Workout> maintainWorkouts = new ArrayList<>();
        
        RecommendationService.showMaintainPlan(maintainProfile, maintainWorkouts);
        
        String output = outContent.toString();
        assertTrue(output.contains("Balanced fitness plan"), "Should show balanced plan");
        assertTrue(output.contains("Rice + Dal + Vegetables + Curd"), "Should include maintenance meals");
    }

    // ==================== SHOW RECOMMENDATIONS TESTS ====================

    @Test
    @DisplayName("Show Recommendations - Bulking")
    void testShowRecommendationsBulking() {
        UserProfile bulkProfile = new UserProfile("Bulk", 30, "Male", 180, 80, "Bulk", "Veg", "Intermediate", 5);
        ArrayList<Workout> bulkWorkouts = new ArrayList<>();
        
        RecommendationService.showRecommendations(bulkProfile, bulkWorkouts);
        
        // Just verify the method runs without exceptions
        assertTrue(bulkWorkouts.size() > 0, "Should add workouts for bulk profile");
    }

    @Test
    @DisplayName("Show Recommendations - Cutting")
    void testShowRecommendationsCutting() {
        UserProfile cutProfile = new UserProfile("Cut", 30, "Male", 180, 90, "Cut", "Non-Veg", "Advanced", 5);
        ArrayList<Workout> cutWorkouts = new ArrayList<>();
        
        RecommendationService.showRecommendations(cutProfile, cutWorkouts);
        
        assertTrue(cutWorkouts.size() > 0, "Should add workouts for cut profile");
    }

    @Test
    @DisplayName("Show Recommendations - Maintenance")
    void testShowRecommendationsMaintenance() {
        UserProfile maintainProfile = new UserProfile("Maintain", 30, "Male", 180, 80, "Maintain", "Veg", "Intermediate", 5);
        ArrayList<Workout> maintainWorkouts = new ArrayList<>();
        
        RecommendationService.showRecommendations(maintainProfile, maintainWorkouts);
        
        assertTrue(maintainWorkouts.size() > 0, "Should add workouts for maintain profile");
    }

    @Test
    @DisplayName("Show Recommendations - Case insensitive goals")
    void testShowRecommendationsCaseInsensitive() {
        UserProfile bulkProfile = new UserProfile("Bulk", 30, "Male", 180, 80, "BULK", "Veg", "Intermediate", 5);
        ArrayList<Workout> workouts = new ArrayList<>();
        
        RecommendationService.showRecommendations(bulkProfile, workouts);
        
        assertTrue(workouts.size() > 0, "Should handle case insensitive goal");
    }

    @Test
    @DisplayName("Show Recommendations - Invalid goal")
    void testShowRecommendationsInvalidGoal() {
        UserProfile invalidProfile = new UserProfile("Invalid", 30, "Male", 180, 80, "InvalidGoal", "Veg", "Intermediate", 5);
        ArrayList<Workout> workouts = new ArrayList<>();
        
        // Just verify the method handles invalid goals without exceptions
        RecommendationService.showRecommendations(invalidProfile, workouts);
        
        assertTrue(true, "Should handle invalid goal gracefully");
    }
}
