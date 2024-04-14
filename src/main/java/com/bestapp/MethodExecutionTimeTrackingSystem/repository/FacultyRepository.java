package com.bestapp.MethodExecutionTimeTrackingSystem.repository;

import com.bestapp.MethodExecutionTimeTrackingSystem.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * An interface containing methods for working with a database of objects of the Faculty class
 * @see Faculty
 * @see com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyService
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    /**
     * Getting faculty by name ignore case
     * @param facultyName faculty name in database
     */
    Faculty findFacultyByFacultyNameIgnoreCase(String facultyName);

    /**
     * Getting faculty by student id
     * @param studentId student identification number in database
     */
    Faculty findFacultyById(Long studentId);
}
