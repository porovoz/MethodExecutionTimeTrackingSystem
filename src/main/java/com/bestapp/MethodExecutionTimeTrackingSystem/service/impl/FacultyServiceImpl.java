package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.annotation.TrackAsyncTime;
import com.bestapp.MethodExecutionTimeTrackingSystem.annotation.TrackTime;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.FacultyDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.exception.FacultyNotFoundException;
import com.bestapp.MethodExecutionTimeTrackingSystem.exception.StudentNotFoundException;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Faculty;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Student;
import com.bestapp.MethodExecutionTimeTrackingSystem.repository.FacultyRepository;
import com.bestapp.MethodExecutionTimeTrackingSystem.repository.StudentRepository;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyMapper;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service to work with the faculties
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final StudentRepository studentRepository;

    /**
     * Creating a faculty object and saving it to a database.<br>
     * - The repository method is used {@link FacultyRepository#save(Object)}. <br>
     * - Converting created faculty data transfer object into faculty object {@link FacultyMapper#toFaculty(FacultyDTO)}.
     * @param facultyDTO an object containing the necessary information to create a faculty. Must not be null.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     * @return {@link FacultyDTO} - created faculty data transfer object
     */
    @Override
    @Transactional
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        log.info("Create faculty method was invoked");
        facultyRepository.save(facultyMapper.toFaculty(facultyDTO));
        log.info("Faculty {} was created successfully", facultyDTO);
        return facultyDTO;
    }

    /** Getting faculty by id.<br>
     * - Search for a faculty by id {@link FacultyRepository#findById(Object)}.<br>
     * - Converting found faculty object into faculty data transfer object {@link FacultyMapper#toFacultyDTO(Faculty)}.
     * @param facultyId faculty identification number in database
     * @throws IllegalArgumentException if {@literal facultyId} is {@literal null}.
     * @return {@link FacultyDTO} - found faculty data transfer object
     */
    @Override
    @TrackAsyncTime
    @Transactional(readOnly = true)
    public FacultyDTO findFacultyById(Long facultyId) {
        log.info("Find faculty by id = {} method was invoked", facultyId);
        Optional<Faculty> foundFaculty = facultyRepository.findById(facultyId);
        if (foundFaculty.isEmpty()) {
            throw new FacultyNotFoundException();
        } else {
            log.info("Faculty with id = {} was successfully found", facultyId);
            return facultyMapper.toFacultyDTO(foundFaculty.get());
        }
    }

    /** Getting faculty by name ignore case.<br>
     * - Search for faculty by name ignore case {@link FacultyRepository#findFacultyByFacultyNameIgnoreCase(String)}.<br>
     * - Converting found faculty into faculty data transfer object {@link FacultyMapper#toFacultyDTO(Faculty)}.
     * @param facultyName faculty name in database
     * @return found faculty data transfer object
     */
    @Override
    @Transactional(readOnly = true)
    public FacultyDTO findFacultyByNameIgnoreCase(String facultyName) {
        log.info("Find faculty by name: {} ignore case method was invoked", facultyName);
        Faculty foundFaculty = facultyRepository.findFacultyByFacultyNameIgnoreCase(facultyName);
        log.info("Faculty with name: {} was successfully found", facultyName);
        return facultyMapper.toFacultyDTO(foundFaculty);
    }

    /** Getting faculty by student id.<br>
     * - Search for student by student id {@link StudentRepository#findById(Object)}.<br>
     * - Converting found faculty into faculty data transfer object {@link FacultyMapper#toFacultyDTO(Faculty)}.
     * @param studentId student identification number in database
     * @throws IllegalArgumentException if {@literal studentId} is {@literal null}.
     * @return found faculty data transfer object
     */
    @Override
    @Transactional(readOnly = true)
    public FacultyDTO findFacultyByStudentId(Long studentId) {
    log.info("Find faculty by student id = {} method was invoked", studentId);
        Optional<Student> foundStudent = studentRepository.findById(studentId);
        if (foundStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            log.info("Faculty with student id = {} was successfully found", studentId);
            return facultyMapper.toFacultyDTO(facultyRepository.findFacultyById(foundStudent.get().getFaculty().getId()));
        }
    }

    /** Getting all faculties.<br>
     * - Search for all faculties {@link FacultyRepository#findAll()}.<br>
     * - Converting all faculty list into faculty data transfer object list {@link FacultyMapper#toFacultyDTOS(List)}.
     * @return all faculty data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    @TrackTime
    public List<FacultyDTO> findAllFaculties() {
        log.info("Find all faculties method was invoked");
        List<Faculty> faculties = facultyRepository.findAll();
        log.info("All faculties were successfully found");
        return facultyMapper.toFacultyDTOS(faculties);
    }

    /**
     * Updating a faculty object and saving it to a database.<br>
     * - The repository method is used {@link FacultyRepository#save(Object)}. <br>
     * - Converting updated faculty data transfer object into faculty object {@link FacultyMapper#toFaculty(FacultyDTO)}.
     * @param facultyDTO an object containing the necessary information to update a faculty. Must not be null.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     * @return {@link FacultyDTO} - updated faculty data transfer object
     */
    @Override
    @Transactional
    public FacultyDTO updateFaculty(FacultyDTO facultyDTO) { // I need to think about different logic
        log.info("Update faculty {} method was invoked", facultyDTO);
        facultyRepository.save(facultyMapper.toFaculty(facultyDTO));
        log.info("Faculty {} was updated successfully", facultyDTO);
        return facultyDTO;
    }

    /**
     * Deleting faculty by id.<br>
     * - Deleting a faculty by id from the database {@link FacultyRepository#deleteById(Object)}.<br>
     * @param facultyId faculty identification number in database
     */
    @Override
    @Transactional
    public void deleteFacultyById(Long facultyId) {
        log.info("Delete faculty by id = {} method was invoked", facultyId);
        facultyRepository.deleteById(facultyId);
        log.info("Faculty with id = {} was deleted successfully", facultyId);
    }
}
