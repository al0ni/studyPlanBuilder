package kz.edu.aitu.studyplanfactory.abstractfactory;

public interface StudyTrackFactory {
    LearningMaterial createMaterial();
    Assessment createAssessment();
    Project createProject();
}
