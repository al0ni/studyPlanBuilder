package kz.edu.aitu.studyplan;

import java.time.DayOfWeek;
import java.util.Objects;

public final class StudyPlanDirector {
    private static final int SHORT_SESSION_MINUTES = 45;
    private static final int LONG_SESSION_MINUTES = 90;

    public StudyPlan createExamPreparationPlan(StudyPlanBuilder builder) {
        return prepare(builder)
                .setTitle("Design Patterns Exam Preparation")
                .setLearningGoal("Explain and implement the main GoF design patterns")
                .setDifficulty(Difficulty.INTERMEDIATE)
                .addResource("Lecture notes")
                .addResource("Head First Design Patterns")
                .addSession(DayOfWeek.MONDAY, "Creational patterns", LONG_SESSION_MINUTES)
                .addSession(DayOfWeek.WEDNESDAY, "Structural patterns", LONG_SESSION_MINUTES)
                .addSession(DayOfWeek.FRIDAY, "Behavioral patterns", LONG_SESSION_MINUTES)
                .enableProgressTracking()
                .build();
    }

    public StudyPlan createBalancedWeeklyPlan(StudyPlanBuilder builder) {
        return prepare(builder)
                .setTitle("Balanced Java Practice")
                .setLearningGoal("Build a consistent Java problem-solving routine")
                .setDifficulty(Difficulty.BEGINNER)
                .addResource("Official Java documentation")
                .addSession(DayOfWeek.TUESDAY, "Language fundamentals", SHORT_SESSION_MINUTES)
                .addSession(DayOfWeek.THURSDAY, "Object-oriented programming", SHORT_SESSION_MINUTES)
                .addSession(DayOfWeek.SATURDAY, "Small coding project", LONG_SESSION_MINUTES)
                .build();
    }

    private StudyPlanBuilder prepare(StudyPlanBuilder builder) {
        return Objects.requireNonNull(builder, "Builder cannot be null").reset();
    }
}