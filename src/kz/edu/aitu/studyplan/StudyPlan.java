package kz.edu.aitu.studyplan;

import java.util.List;

public final class StudyPlan {
    private final String title;
    private final String learningGoal;
    private final Difficulty difficulty;
    private final List<String> resources;
    private final List<StudySession> sessions;
    private final boolean progressTrackingEnabled;

    StudyPlan(
            String title,
            String learningGoal,
            Difficulty difficulty,
            List<String> resources,
            List<StudySession> sessions,
            boolean progressTrackingEnabled
    ) {
        this.title = title;
        this.learningGoal = learningGoal;
        this.difficulty = difficulty;
        this.resources = List.copyOf(resources);
        this.sessions = List.copyOf(sessions);
        this.progressTrackingEnabled = progressTrackingEnabled;
    }

    public String getTitle() {
        return title;
    }

    public String getLearningGoal() {
        return learningGoal;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<String> getResources() {
        return resources;
    }

    public List<StudySession> getSessions() {
        return sessions;
    }

    public boolean isProgressTrackingEnabled() {
        return progressTrackingEnabled;
    }

    public long getTotalStudyMinutes() {
        long totalMinutes = 0;
        for (StudySession session : sessions) {
            totalMinutes += session.durationMinutes();
        }
        return totalMinutes;
    }

    @Override
    public String toString() {
        return "StudyPlan{title=" + title
                + ", learningGoal=" + learningGoal
                + ", difficulty=" + difficulty
                + ", resources=" + resources
                + ", sessions=" + sessions
                + ", progressTrackingEnabled=" + progressTrackingEnabled
                + "}";
    }
}