# Study Plan Factories

Software Design Patterns — Assignment 2

## Overview

This Java console application creates study modules and complete study tracks. Part A demonstrates Factory Method by creating individual lectures, assignments, and quizzes. Part B demonstrates Abstract Factory by creating consistent families of learning material, assessment, and project objects for STEM and Humanities tracks.

The project uses only standard Java and has no external dependencies.

## Part A Factory Method

| Pattern role | Project class |
|---|---|
| Product | `CourseItem` |
| Concrete Products | `Lecture`, `Assignment`, `Quiz` |
| Creator | `ModuleFactory` |
| Concrete Creators | `LectureFactory`, `AssignmentFactory`, `QuizFactory` |

`ModuleFactory.prepareModule()` contains the common creation workflow. Each concrete factory overrides `createModule()` and decides which concrete product is returned.

## Part B Abstract Factory

| Pattern role | Project class |
|---|---|
| Abstract Products | `LearningMaterial`, `Assessment`, `Project` |
| STEM Products | `StemMaterial`, `StemAssessment`, `StemProject` |
| Humanities Products | `HumanitiesMaterial`, `HumanitiesAssessment`, `HumanitiesProject` |
| Abstract Factory | `StudyTrackFactory` |
| Concrete Factories | `StemTrackFactory`, `HumanitiesTrackFactory` |
| Client | `Client` |

The `Client` depends only on `StudyTrackFactory`, `LearningMaterial`, `Assessment`, and `Project`. It never creates concrete products directly. Replacing the factory changes the complete family without changing client logic.

## Clean Code Principles

### 1 Meaningful names

Before:

```java
Object x = f.make("Topic", 50);
```

After:

```java
CourseItem lecture = factory.prepareModule("Factory Method Basics", 50);
```

Names such as `lecture`, `factory`, `prepareModule`, and `durationMinutes` reveal the purpose and measurement unit.

### 2 Small methods

Before:

```java
public static void main(String[] args) {
    // all creation and output logic in one long method
}
```

After:

```java
public static void main(String[] args) {
    demonstrateFactoryMethod();
    demonstrateAbstractFactory();
}
```

Each demonstration method has one responsibility, while `main()` only controls the program flow.

### 3 Validated construction

Before:

```java
return createModule(title, durationMinutes);
```

After:

```java
validateInput(title, durationMinutes);
CourseItem item = createModule(title.strip(), durationMinutes);
```

The creator rejects blank titles and non-positive durations with clear exceptions before an invalid object can be created.

### 4 Programming to interfaces

Before:

```java
StemMaterial material = new StemMaterial();
```

After:

```java
LearningMaterial material = factory.createMaterial();
```

The client works through abstract types. This reduces coupling and allows an entire family to be replaced through one factory object.

### 5 DRY

Before:

```java
new Lecture(title, duration);
new Assignment(title, duration);
```

After:

```java
CourseItem item = createModule(title.strip(), durationMinutes);
item.display();
```

The common validation, creation flow, and display call are defined once in `ModuleFactory.prepareModule()`. Concrete factories contain only the part that varies.

### 6 Consistent focused classes

Before:

```java
class StudyObject {
    // lecture, test, project, and track responsibilities mixed together
}
```

After:

```java
public class StemProject implements Project {
    public String getDescription() {
        return "Build and demonstrate a working software prototype";
    }
}
```

Every product and factory has one clear responsibility, and all files follow the same formatting style.

## How to Run

### IntelliJ IDEA

1. Open the `StudyPlanFactories` folder.
2. Select JDK 17 or newer as the Project SDK.
3. Open `src/kz/edu/aitu/studyplanfactory/Main.java`.
4. Run `Main.main()`.

### Terminal

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out kz.edu.aitu.studyplanfactory.Main
```

## Expected Output

```text
FACTORY METHOD
Lecture: Factory Method Basics (50 minutes)
Assignment: Create Module Factories (90 minutes)
Quiz: Factory Method Quiz (20 minutes)
Total module time: 160 minutes

ABSTRACT FACTORY
STEM Track
Material: Interactive lesson with formulas and coding examples
Assessment: Problem-solving test with practical calculations
Project: Build and demonstrate a working software prototype

Humanities Track
Material: Reading collection with historical sources and essays
Assessment: Written analysis with evidence-based questions
Project: Research presentation based on primary sources
```

## Design Choice

Factory Method is appropriate when the program needs one course item and the chosen creator decides its concrete type. Abstract Factory is appropriate when the program must create several related objects that belong to one consistent study track. The two patterns are separated into packages so their responsibilities remain clear.
