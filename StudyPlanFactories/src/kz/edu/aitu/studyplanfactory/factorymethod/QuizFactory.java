package kz.edu.aitu.studyplanfactory.factorymethod;

public class QuizFactory extends ModuleFactory {
    @Override
    protected CourseItem createModule(String title, int durationMinutes) {
        return new Quiz(title, durationMinutes);
    }
}
