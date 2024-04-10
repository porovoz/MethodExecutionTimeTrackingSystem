package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.StudentDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.Student;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyMapper;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code StudentMapperImpl} class is a component responsible for converting student entities (Student) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
@Component
public class StudentMapperImpl implements StudentMapper {

    private final FacultyMapper facultyMapper;

    public StudentMapperImpl(FacultyMapper facultyMapper) {
        this.facultyMapper = facultyMapper;
    }

    @Override
    public StudentDTO toStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFullName(student.getFullName());
        studentDTO.setAge(student.getAge());
        studentDTO.setFacultyDTO(facultyMapper.toFacultyDTO(student.getFaculty()));
        return studentDTO;
    }

    @Override
    public Student toStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFullName(studentDTO.getFullName());
        student.setAge(studentDTO.getAge());
        student.setFaculty(facultyMapper.toFaculty(studentDTO.getFacultyDTO()));
        return student;
    }

    @Override
    public List<StudentDTO> toStudentDTOS(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = toStudentDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }
}
