package com.bestapp.MethodExecutionTimeTrackingSystem.repository;

import com.bestapp.MethodExecutionTimeTrackingSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * An interface containing methods for working with a database of objects of the Student class
 * @see Student
 * @see com.bestapp.MethodExecutionTimeTrackingSystem.service.StudentService
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Getting students by age
     * @param age students age in database
     */
    List<Student> findStudentByAge(int age);

    /**
     * Getting students by age between
     * @param min minimal students age in database
     * @param max maximal students age in database
     */
    List<Student> findStudentByAgeBetween(int min, int max);

    /**
     * Getting students by faculty id
     * @param facultyId faculty identification number in database
     */
    List<Student> findStudentByFaculty_Id(Long facultyId);
}
