package kz.edu.aitu.studyplanfactory;

import kz.edu.aitu.studyplanfactory.abstractfactory.Client;
import kz.edu.aitu.studyplanfactory.abstractfactory.HumanitiesTrackFactory;
import kz.edu.aitu.studyplanfactory.abstractfactory.StemTrackFactory;
import kz.edu.aitu.studyplanfactory.abstractfactory.StudyTrackFactory;
import kz.edu.aitu.studyplanfactory.factorymethod.AssignmentFactory;
import kz.edu.aitu.studyplanfactory.factorymethod.CourseItem;
import kz.edu.aitu.studyplanfactory.factorymethod.LectureFactory;
import kz.edu.aitu.studyplanfactory.factorymethod.ModuleFactory;
import kz.edu.aitu.studyplanfactory.factorymethod.QuizFactory;

public class Main {
    public static void main(String[] args) {
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("FACTORY METHOD");

        ModuleFactory factory = new LectureFactory();
        CourseItem lecture = factory.prepareModule("Factory Method Basics", 50);

        factory = new AssignmentFactory();
        CourseItem assignment = factory.prepareModule("Create Module Factories", 90);

        factory = new QuizFactory();
        CourseItem quiz = factory.prepareModule("Factory Method Quiz", 20);

        int totalMinutes = lecture.getDurationMinutes()
                + assignment.getDurationMinutes()
                + quiz.getDurationMinutes();
        System.out.println("Total module time: " + totalMinutes + " minutes");
    }

    private static void demonstrateAbstractFactory() {
        System.out.println("\nABSTRACT FACTORY");

        StudyTrackFactory factory = new StemTrackFactory();
        Client client = new Client(factory);
        client.showStudyPlan("STEM Track");

        System.out.println();

        factory = new HumanitiesTrackFactory();
        client = new Client(factory);
        client.showStudyPlan("Humanities Track");
    }
}
