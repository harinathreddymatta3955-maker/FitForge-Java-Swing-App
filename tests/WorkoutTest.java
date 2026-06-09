import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Workout Model Test Suite")
public class WorkoutTest {

    private Workout workout;

    @BeforeEach
    void setUp() {
        workout = new Workout("Bench Press", 4, 8, 100.0);
    }

    @Test
    @DisplayName("Workout Creation - Attributes stored correctly")
    void testWorkoutCreation() {
        assertEquals("Bench Press", workout.exerciseName, "Exercise name should match");
        assertEquals(4, workout.sets, "Sets should match");
        assertEquals(8, workout.reps, "Reps should match");
        assertEquals(100.0, workout.weightUsed, "Weight should match");
    }

    @Test
    @DisplayName("Workout - Zero weight (bodyweight exercise)")
    void testWorkoutZeroWeight() {
        Workout bodyweightWorkout = new Workout("Push-ups", 3, 15, 0);
        assertEquals(0, bodyweightWorkout.weightUsed, "Should allow zero weight for bodyweight exercises");
        assertEquals("Push-ups", bodyweightWorkout.exerciseName);
        assertEquals(3, bodyweightWorkout.sets);
        assertEquals(15, bodyweightWorkout.reps);
    }

    @Test
    @DisplayName("Workout - Heavy weight compound exercise")
    void testWorkoutHeavyWeight() {
        Workout squat = new Workout("Squats", 5, 5, 150.0);
        assertEquals("Squats", squat.exerciseName);
        assertEquals(5, squat.sets);
        assertEquals(5, squat.reps);
        assertEquals(150.0, squat.weightUsed, "Should handle heavy weights");
    }

    @Test
    @DisplayName("Workout - High reps low weight")
    void testWorkoutHighRepsLowWeight() {
        Workout cardioExercise = new Workout("Treadmill Walking", 1, 25, 0);
        assertEquals(1, cardioExercise.sets, "Cardio typically has 1 set");
        assertEquals(25, cardioExercise.reps, "Reps represent minutes");
        assertEquals(0, cardioExercise.weightUsed);
    }

    @Test
    @DisplayName("Workout - Different exercises")
    void testWorkoutDifferentExercises() {
        String[] exercises = {"Bench Press", "Squats", "Deadlift", "Lat Pulldown", "Bicep Curls", "Plank", "Push-ups"};
        
        for (String exercise : exercises) {
            Workout testWorkout = new Workout(exercise, 3, 10, 50.0);
            assertEquals(exercise, testWorkout.exerciseName, "Exercise name should be stored correctly");
        }
    }

    @Test
    @DisplayName("Workout - Decimal weight precision")
    void testWorkoutDecimalWeightPrecision() {
        Workout precisionWorkout = new Workout("Dumbbell Press", 4, 10, 22.5);
        assertEquals(22.5, precisionWorkout.weightUsed, 0.01, "Should maintain decimal precision for weights");
    }

    @Test
    @DisplayName("Workout - Various set and rep schemes")
    void testWorkoutVariousSetsReps() {
        int[][] schemes = {
            {3, 8},   // Strength
            {4, 10},  // Hypertrophy
            {3, 12},  // Endurance
            {5, 5},   // Power
            {2, 20}   // High reps
        };
        
        for (int[] scheme : schemes) {
            Workout testWorkout = new Workout("Test Exercise", scheme[0], scheme[1], 50.0);
            assertEquals(scheme[0], testWorkout.sets, "Sets should match");
            assertEquals(scheme[1], testWorkout.reps, "Reps should match");
        }
    }

    @Test
    @DisplayName("Workout - Plank exercise (special case)")
    void testPlankExercise() {
        Workout plank = new Workout("Plank", 3, 45, 0);
        assertEquals("Plank", plank.exerciseName);
        assertEquals(3, plank.sets);
        assertEquals(45, plank.reps, "Reps represent seconds for plank");
        assertEquals(0, plank.weightUsed);
    }

    @Test
    @DisplayName("Workout - Cycling exercise (special case)")
    void testCyclingExercise() {
        Workout cycling = new Workout("Cycling", 1, 20, 0);
        assertEquals("Cycling", cycling.exerciseName);
        assertEquals(1, cycling.sets);
        assertEquals(20, cycling.reps, "Reps represent minutes for cycling");
        assertEquals(0, cycling.weightUsed);
    }

    @Test
    @DisplayName("Workout - Validation of realistic values")
    void testWorkoutRealisticValues() {
        Workout workout = new Workout("Bench Press", 4, 8, 100.0);
        
        assertTrue(workout.sets > 0, "Sets should be positive");
        assertTrue(workout.reps > 0, "Reps should be positive");
        assertTrue(workout.weightUsed >= 0, "Weight should be non-negative");
    }
}
