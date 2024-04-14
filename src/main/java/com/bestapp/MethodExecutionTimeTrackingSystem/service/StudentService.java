package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    /**
     * Creation of a student object
     * @param studentDTO object containing all necessary information for creation a student object
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    /**
     * Getting student by id
     * @param studentId student identification number in database
     */
    StudentDTO findStudentById(Long studentId);

    /**
     * Getting students by age
     * @param age students age in database
     */
    List<StudentDTO> findStudentsByAge(int age);

    /**
     * Getting students by age between
     * @param min minimal students age in database
     * @param max maximal students age in database
     */
    List<StudentDTO> findStudentsByAgeBetween(int min, int max);

    /**
     * Getting students by faculty id
     * @param facultyId faculty identification number in database
     */
    List<StudentDTO> findStudentsByFacultyId(Long facultyId);

    /**
     * Getting all students
     */
    List<StudentDTO> findAllStudents();

    /**
     * Updating student
     * @param studentDTO object containing all necessary information for updating a student object
     */
    StudentDTO updateStudent(StudentDTO studentDTO);

    /**
     * Deleting student by id
     * @param studentId student identification number in database
     */
    void deleteStudentById(Long studentId);
}
