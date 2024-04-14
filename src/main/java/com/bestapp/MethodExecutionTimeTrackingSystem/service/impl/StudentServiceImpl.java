package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.annotation.TrackAsyncTime;
import com.bestapp.MethodExecutionTimeTrackingSystem.annotation.TrackTime;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.StudentDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.exception.StudentNotFoundException;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Student;
import com.bestapp.MethodExecutionTimeTrackingSystem.repository.StudentRepository;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.StudentMapper;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service to work with the students
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    /**
     * Creating a student object and saving it to a database.<br>
     * - The repository method is used {@link StudentRepository#save(Object)}. <br>
     * - Converting created student data transfer object into student object {@link StudentMapper#toStudent(StudentDTO)}.
     * @param studentDTO an object containing the necessary information to create a student. Must not be null.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     * @return {@link StudentDTO} - created student data transfer object
     */
    @Override
    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        log.info("Create student method was invoked");
        studentRepository.save(studentMapper.toStudent(studentDTO));
        log.info("Student {} was created successfully", studentDTO);
        return studentDTO;
    }

    /** Getting student by id.<br>
     * - Search for a student by id {@link StudentRepository#findById(Object)}.<br>
     * - Converting found student object into student data transfer object {@link StudentMapper#toStudentDTO(Student)}.
     * @param studentId student identification number in database
     * @throws IllegalArgumentException if {@literal studentId} is {@literal null}.
     * @return {@link StudentDTO} - found student data transfer object
     */
    @Override
    @TrackAsyncTime
    @Transactional(readOnly = true)
    public StudentDTO findStudentById(Long studentId) {
        log.info("Find student by id = {} method was invoked", studentId);
        Optional<Student> foundStudent = studentRepository.findById(studentId);
        if (foundStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            log.info("Student with id = {} was successfully found", studentId);
            return studentMapper.toStudentDTO(foundStudent.get());
        }
    }

    /** Getting students by age.<br>
     * - Search for students by age {@link StudentRepository#findStudentByAge(int)}.<br>
     * - Converting found student list into student data transfer object list {@link StudentMapper#toStudentDTOS(List)}.
     * @param age student age in database
     * @return found student data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findStudentsByAge(int age) {
        log.info("Find students by age = {} method was invoked", age);
        List<Student> students = studentRepository.findStudentByAge(age);
        log.info("Students with age = {} were successfully found", age);
        return studentMapper.toStudentDTOS(students);
    }

    /** Getting students by age between.<br>
     * - Search for students by age between {@link StudentRepository#findStudentByAgeBetween(int, int)}.<br>
     * - Converting found student list into student data transfer object list {@link StudentMapper#toStudentDTOS(List)}.
     * @param min minimal students age in database
     * @param max maximal students age in database
     * @return found student data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findStudentsByAgeBetween(int min, int max) {
        log.info("Find students by age between min = {} and max = {} method was invoked", min, max);
        List<Student> students = studentRepository.findStudentByAgeBetween(min, max);
        log.info("Students with age between min = {} and max = {} were successfully found", min, max);
        return studentMapper.toStudentDTOS(students);
    }

    /** Getting students by faculty id.<br>
     * - Search for student list by faculty id {@link StudentRepository#findStudentByFaculty_Id(Long)}.<br>
     * - Converting found student list into student data transfer object list {@link StudentMapper#toStudentDTOS(List)}.
     * @param facultyId faculty identification number in database
     * @throws IllegalArgumentException if {@literal facultyId} is {@literal null}.
     * @return found student data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findStudentsByFacultyId(Long facultyId) {
        log.info("Find students by faculty id = {} method was invoked", facultyId);
        List<Student> students = studentRepository.findStudentByFaculty_Id(facultyId);
        log.info("Students with faculty id = {} were successfully found", facultyId);
        return studentMapper.toStudentDTOS(students);
    }

    /** Getting all students.<br>
     * - Search for all students {@link StudentRepository#findAll()}.<br>
     * - Converting all student list into student data transfer object list {@link StudentMapper#toStudentDTOS(List)}.
     * @return all student data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    @TrackTime
    public List<StudentDTO> findAllStudents() {
        log.info("Find all students method was invoked");
        List<Student> students = studentRepository.findAll();
        log.info("All students were successfully found");
        return studentMapper.toStudentDTOS(students);
    }

    /**
     * Updating a student object and saving it to a database.<br>
     * - The repository method is used {@link StudentRepository#save(Object)}. <br>
     * - Converting updated student data transfer object into student object {@link StudentMapper#toStudent(StudentDTO)}.
     * @param studentDTO an object containing the necessary information to update a student. Must not be null.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     * @return {@link StudentDTO} - updated student data transfer object
     */
    @Override
    @Transactional
    public StudentDTO updateStudent(StudentDTO studentDTO) { // I need to think about different logic
        log.info("Update student: {} method was invoked", studentDTO);
        studentRepository.save(studentMapper.toStudent(studentDTO));
        log.info("Student {} was updated successfully", studentDTO);
        return studentDTO;
    }

    /**
     * Deleting student by id.<br>
     * - Deleting a student by id from the database {@link StudentRepository#deleteById(Object)}.<br>
     * @param studentId student identification number in database
     */
    @Override
    @Transactional
    public void deleteStudentById(Long studentId) {
        log.info("Delete student by id = {} method was invoked", studentId);
        studentRepository.deleteById(studentId);
        log.info("Student with id = {} was deleted successfully", studentId);
    }
}
