package kz.edu.aitu.studyplanfactory.factorymethod;

public class Lecture implements CourseItem {
    private final String title;
    private final int durationMinutes;

    public Lecture(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void display() {
        System.out.println("Lecture: " + title + " (" + durationMinutes + " minutes)");
    }
}
