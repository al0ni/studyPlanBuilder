package kz.edu.aitu.studyplanfactory.abstractfactory;

public class StemTrackFactory implements StudyTrackFactory {
    @Override
    public LearningMaterial createMaterial() {
        return new StemMaterial();
    }

    @Override
    public Assessment createAssessment() {
        return new StemAssessment();
    }

    @Override
    public Project createProject() {
        return new StemProject();
    }
}
