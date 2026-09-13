package kz.edu.aitu.studyplan;

import java.time.DayOfWeek;
import java.util.Objects;

public final class StudyPlanDirector {
    private static final int SHORT_SESSION_MINUTES = 45;
    private static final int LONG_SESSION_MINUTES = 90;

    public StudyPlan createExamPreparationPlan(StudyPlanBuilder builder) {
        return prepare(builder)
                .setTitle("Design Patterns Exam Preparation")
                .setLearningGoal("Learn all patterns, history and classification")
                .setDifficulty(Difficulty.INTERMEDIATE)
                .addResource("Lecture notes")
                .addResource("Head First Design Patterns")
                .addSession(DayOfWeek.MONDAY, "Design Patterns, Benefits, Classification, History, Criticism", 240)
                .addSession(DayOfWeek.WEDNESDAY, "Creational and Structural Design Patterns", 120)
                .addSession(DayOfWeek.FRIDAY, "Behavioral Design Patterns, Catalog of patterns", 60)
                .enableProgressTracking()
                .build();
    }

    public StudyPlan createBalancedWeeklyPlan(StudyPlanBuilder builder) {
        return prepare(builder)
                .setTitle("SDP Labs and Homeworks")
                .setLearningGoal("Close all deadlines for Software Design Patterns")
                .setDifficulty(Difficulty.BEGINNER)
                .addResource("AITU Moodle presentations")
                .addResource("StackOverflow and GitHub repos")
                .addSession(DayOfWeek.TUESDAY, "Reading lab requirements and watching guides", SHORT_SESSION_MINUTES)
                .addSession(DayOfWeek.THURSDAY, "Writing base classes and interfaces", SHORT_SESSION_MINUTES)
                .addSession(DayOfWeek.SATURDAY, "Refactoring, testing and pushing to GitHub", LONG_SESSION_MINUTES)
                .build();
    }

    private StudyPlanBuilder prepare(StudyPlanBuilder builder) {
        return Objects.requireNonNull(builder, "Builder cannot be null").reset();
    }
}