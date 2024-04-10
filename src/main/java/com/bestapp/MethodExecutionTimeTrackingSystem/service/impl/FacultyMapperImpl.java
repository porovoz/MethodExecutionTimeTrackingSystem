package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.FacultyDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Faculty;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code FacultyMapperImpl} class is a component responsible for converting faculty entities (Faculty) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDTO toFacultyDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setId(faculty.getId());
        facultyDTO.setFacultyName(faculty.getFacultyName());
        return facultyDTO;
    }

    @Override
    public Faculty toFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setId(facultyDTO.getId());
        faculty.setFacultyName(facultyDTO.getFacultyName());
        return faculty;
    }

    @Override
    public List<FacultyDTO> toFacultyDTOS(List<Faculty> faculties) {
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = toFacultyDTO(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }
}
