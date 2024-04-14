package com.bestapp.MethodExecutionTimeTrackingSystem.exception;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
