package com.bestapp.MethodExecutionTimeTrackingSystem.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String fullName;
    private int age;
    private FacultyDTO facultyDTO;
}
