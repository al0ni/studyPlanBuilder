package kz.edu.aitu.studyplanfactory.abstractfactory;

public class HumanitiesTrackFactory implements StudyTrackFactory {
    @Override
    public LearningMaterial createMaterial() {
        return new HumanitiesMaterial();
    }

    @Override
    public Assessment createAssessment() {
        return new HumanitiesAssessment();
    }

    @Override
    public Project createProject() {
        return new HumanitiesProject();
    }
}
