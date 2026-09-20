package kz.edu.aitu.studyplanfactory.factorymethod;

public class LectureFactory extends ModuleFactory {
    @Override
    protected CourseItem createModule(String title, int durationMinutes) {
        return new Lecture(title, durationMinutes);
    }
}
