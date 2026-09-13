package kz.edu.aitu.studyplan;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public final class DefaultStudyPlanBuilder implements StudyPlanBuilder {
    private static final int MINIMUM_SESSIONS = 2;

    private String title;
    private String learningGoal;
    private Difficulty difficulty = Difficulty.BEGINNER;
    private final List<String> resources = new ArrayList<>();
    private final List<StudySession> sessions = new ArrayList<>();
    private boolean progressTrackingEnabled;

    @Override
    public DefaultStudyPlanBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder setLearningGoal(String learningGoal) {
        this.learningGoal = learningGoal;
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder addResource(String resource) {
        if (resource == null || resource.isBlank()) {
            throw new IllegalArgumentException("Resource cannot be blank");
        }
        resources.add(resource.strip());
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder addSession(DayOfWeek day, String topic, int durationMinutes) {
        sessions.add(new StudySession(day, topic, durationMinutes));
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder enableProgressTracking() {
        progressTrackingEnabled = true;
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder disableProgressTracking() {
        progressTrackingEnabled = false;
        return this;
    }

    @Override
    public DefaultStudyPlanBuilder reset() {
        title = null;
        learningGoal = null;
        difficulty = Difficulty.BEGINNER;
        resources.clear();
        sessions.clear();
        progressTrackingEnabled = false;
        return this;
    }

    @Override
    public StudyPlan build() {
        validateState();
        return new StudyPlan(title.strip(), learningGoal.strip(), difficulty,
                resources, sessions, progressTrackingEnabled);
    }

    private void validateState() {
        validateRequiredText(title, "Plan title");
        validateRequiredText(learningGoal, "Learning goal");
        if (difficulty == null) {
            throw new IllegalStateException("Difficulty cannot be null");
        }
        if (sessions.size() < MINIMUM_SESSIONS) {
            throw new IllegalStateException(
                    "A study plan must contain at least " + MINIMUM_SESSIONS + " sessions");
        }
    }

    private void validateRequiredText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(fieldName + " cannot be blank");
        }
    }
}