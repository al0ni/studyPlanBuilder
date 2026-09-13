package kz.edu.aitu.studyplan;

import java.time.DayOfWeek;

public final class Main {
    private static final int SEARCH_SESSION_MINUTES = 60;
    private static final int PATHFINDING_SESSION_MINUTES = 75;
    private static final int VALIDATION_DEMO_MINUTES = 30;

    private Main() {
    }

    public static void main(String[] args) {
        StudyPlanBuilder builder = new DefaultStudyPlanBuilder();
        StudyPlanDirector director = new StudyPlanDirector();

        StudyPlan examPlan = director.createExamPreparationPlan(builder);
        StudyPlan courseworkPlan = director.createCourseworkPlan(builder);

        printPlan("Director configuration 1", examPlan);
        printPlan("Director configuration 2", courseworkPlan);
        printPlan("Custom client configuration", createCustomPlan());
        demonstrateValidation();
    }

    private static StudyPlan createCustomPlan() {
        return new DefaultStudyPlanBuilder()
                .setTitle("Algorithms Sprint")
                .setLearningGoal("Improve graph algorithm skills")
                .setDifficulty(Difficulty.ADVANCED)
                .addResource("Algorithms textbook")
                .addSession(DayOfWeek.MONDAY, "Breadth-first search", SEARCH_SESSION_MINUTES)
                .addSession(DayOfWeek.THURSDAY, "Dijkstra algorithm", PATHFINDING_SESSION_MINUTES)
                .enableProgressTracking()
                .build();
    }

    private static void printPlan(String label, StudyPlan plan) {
        System.out.println(label + ":");
        System.out.println("Title: " + plan.getTitle());
        System.out.println("Goal: " + plan.getLearningGoal());
        System.out.println("Difficulty: " + plan.getDifficulty());
        System.out.println("Resources: " + plan.getResources());
        for (StudySession session : plan.getSessions()) {
            System.out.printf("  %s | %s | %d min%n",
                    session.day(), session.topic(), session.durationMinutes());
        }
        System.out.println("Total: " + plan.getTotalStudyMinutes() + " min/week");
        System.out.println("Progress tracking: " + plan.isProgressTrackingEnabled());
        System.out.println();
    }

    private static void demonstrateValidation() {
        try {
            new DefaultStudyPlanBuilder()
                    .setTitle("Invalid plan")
                    .setLearningGoal("Demonstrate build validation")
                    .addSession(DayOfWeek.MONDAY, "Only one session", VALIDATION_DEMO_MINUTES)
                    .build();
        } catch (IllegalStateException exception) {
            System.out.println("Validation works: " + exception.getMessage());
        }
    }
}