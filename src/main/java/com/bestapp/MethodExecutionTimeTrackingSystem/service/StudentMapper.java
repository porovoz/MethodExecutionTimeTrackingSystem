package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.StudentDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Student;

import java.util.List;

/**
 * The {@code StudentMapper} is an interface responsible for converting student entities (Student) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
    List<StudentDTO> toStudentDTOS(List<Student> students);
}
