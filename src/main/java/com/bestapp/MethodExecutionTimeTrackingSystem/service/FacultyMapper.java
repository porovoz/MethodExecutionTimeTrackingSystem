package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.FacultyDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Faculty;

import java.util.List;

/**
 * The {@code FacultyMapper} is an interface responsible for converting faculty entities (Faculty) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
public interface FacultyMapper {

    FacultyDTO toFacultyDTO(Faculty faculty);
    Faculty toFaculty(FacultyDTO facultyDTO);
    List<FacultyDTO> toFacultyDTOS(List<Faculty> faculties);
}
