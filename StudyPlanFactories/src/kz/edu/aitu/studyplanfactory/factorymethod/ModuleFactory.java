package kz.edu.aitu.studyplanfactory.factorymethod;

public abstract class ModuleFactory {
    public CourseItem prepareModule(String title, int durationMinutes) {
        validateInput(title, durationMinutes);
        CourseItem item = createModule(title.strip(), durationMinutes);
        item.display();
        return item;
    }

    protected abstract CourseItem createModule(String title, int durationMinutes);

    private void validateInput(String title, int durationMinutes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Module title cannot be blank");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero");
        }
    }
}
