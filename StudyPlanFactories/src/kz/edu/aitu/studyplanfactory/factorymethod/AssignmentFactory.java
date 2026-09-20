package kz.edu.aitu.studyplanfactory.factorymethod;

public class AssignmentFactory extends ModuleFactory {
    @Override
    protected CourseItem createModule(String title, int durationMinutes) {
        return new Assignment(title, durationMinutes);
    }
}
