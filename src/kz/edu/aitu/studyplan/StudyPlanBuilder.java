package kz.edu.aitu.studyplan;

import java.time.DayOfWeek;

public interface StudyPlanBuilder {
    StudyPlanBuilder setTitle(String title);
    StudyPlanBuilder setLearningGoal(String learningGoal);
    StudyPlanBuilder setDifficulty(Difficulty difficulty);
    StudyPlanBuilder addResource(String resource);
    StudyPlanBuilder addSession(DayOfWeek day, String topic, int durationMinutes);
    StudyPlanBuilder enableProgressTracking();
    StudyPlanBuilder disableProgressTracking();
    StudyPlanBuilder reset();
    StudyPlan build();
}