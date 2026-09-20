package kz.edu.aitu.studyplanfactory.abstractfactory;

public class Client {
    private final LearningMaterial material;
    private final Assessment assessment;
    private final Project project;

    public Client(StudyTrackFactory factory) {
        material = factory.createMaterial();
        assessment = factory.createAssessment();
        project = factory.createProject();
    }

    public void showStudyPlan(String trackName) {
        System.out.println(trackName);
        System.out.println("Material: " + material.getDescription());
        System.out.println("Assessment: " + assessment.getDescription());
        System.out.println("Project: " + project.getDescription());
    }
}
