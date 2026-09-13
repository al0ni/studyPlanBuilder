# Study Plan Builder

Alua Rakhimzhanova, SE-2509  
Software Design Patterns — Assignment 1

## Overview

A Java console application that builds weekly study plans.
Builder allows the title, goal, difficulty, resources, and sessions
to be configured step by step. The builder validates data before
creating the plan.

## Pattern roles

- Product: `StudyPlan`
- Builder interface: `StudyPlanBuilder`
- Concrete Builder: `DefaultStudyPlanBuilder`
- Director: `StudyPlanDirector`
- Client: `Main`

All configuration methods return `this` for method chaining.
`build()` returns the completed plan.

## Clean Code principles

### 1. Meaningful names

```java
sessions.add(new StudySession(day, topic, durationMinutes));
```

`durationMinutes` specifies the time unit, and `topic` describes
the subject of the session.

### 2. Small methods

```java
public StudyPlan build() {
    validateState();
    return new StudyPlan(title.strip(), learningGoal.strip(), difficulty,
            resources, sessions, progressTrackingEnabled);
}
```

`build()` keeps the construction sequence short by delegating
the checks to `validateState()`.

### 3. Validated construction

```java
if (sessions.size() < MINIMUM_SESSIONS) {
    throw new IllegalStateException(
            "A study plan must contain at least " + MINIMUM_SESSIONS + " sessions");
}
```

The builder rejects plans with fewer than two sessions.
The exception explains what is missing.

### 4. No magic numbers in validation rules

```java
private static final int MINIMUM_SESSION_MINUTES = 15;
private static final int MAXIMUM_SESSION_MINUTES = 240;
```

Named constants explain the allowed duration limits and are
reused in the check and error message.

### 5. DRY

```java
private void validateRequiredText(String value, String fieldName) {
    if (value == null || value.isBlank()) {
        throw new IllegalStateException(fieldName + " cannot be blank");
    }
}
```

The same helper validates the title and learning goal,
so the check is not duplicated.

## How to run

Open the project in IntelliJ IDEA, select JDK 25 as the Project SDK,
and run `Main.main()`. No external dependencies are required.

The program prints two Director plans and one custom plan,
then demonstrates validation with an invalid plan.
