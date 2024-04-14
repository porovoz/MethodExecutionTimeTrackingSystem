package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    /**
     * Creation of a faculty object
     * @param facultyDTO object containing all necessary information for creation a faculty object
     */
    FacultyDTO createFaculty(FacultyDTO facultyDTO);

    /**
     * Getting faculty by id
     * @param facultyId faculty identification number in database
     */
    FacultyDTO findFacultyById(Long facultyId);

    /**
     * Getting faculty by name ignore case
     * @param facultyName faculty name in database
     */
    FacultyDTO findFacultyByNameIgnoreCase(String facultyName);

    /**
     * Getting faculty by student id
     * @param studentId student identification number in database
     */
    FacultyDTO findFacultyByStudentId(Long studentId);

    /**
     * Getting all faculties
     */
    List<FacultyDTO> findAllFaculties();

    /**
     * Updating faculty
     * @param facultyDTO object containing all necessary information for updating a faculty object
     */
    FacultyDTO updateFaculty(FacultyDTO facultyDTO);

    /**
     * Deleting faculty by id
     * @param facultyId faculty identification number in database
     */
    void deleteFacultyById(Long facultyId);
}
