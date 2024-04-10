package com.bestapp.MethodExecutionTimeTrackingSystem.controller;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.StudentDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for the students
 * @see StudentDTO
 * @see StudentService
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
@Tag(name = "Students")
public class StudentController {

    private final StudentService studentService;

    /**
     * Creating a new student.
     * @return the response with the created student in JSON format and the HTTP 200 status code (Ok).<br>
     */
    @Operation(
            summary = "Create new student",
            description = "Create new student with student id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student was successfully created",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudentDTO = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(createdStudentDTO);
    }

    /**
     * Getting student by id.
     * @param studentId student identification number.
     * @return the response with the found student in JSON format and the HTTP 200 status code (Ok).<br>
     * If the student not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find student by student id",
            description = "Search by student id"
    )
    @Parameters(value = {
            @Parameter(name = "studentId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId) {
        StudentDTO foundStudentDTO = studentService.findStudentById(studentId);
        if (foundStudentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudentDTO);
    }

    /**
     * Getting students by age.
     * @param age student age.
     * @return the response with the found student list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the student list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find student list by age",
            description = "Search for student list by age"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student list was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student list was not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/age")
    public ResponseEntity<List<StudentDTO>> getStudentsByAge(@RequestParam("age") int age) {
        List<StudentDTO> foundStudentDTOS = studentService.findStudentsByAge(age);
        if (foundStudentDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudentDTOS);
    }

    /**
     * Getting students by age between.
     * @param min minimal student age.
     * @param max maximal student age.
     * @return the response with the found student list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the student list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find student list by age between",
            description = "Search for student list by age between"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student list was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student list was not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/age-between")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeBetween(@RequestParam("min") int min, @RequestParam("max") int max) {
        List<StudentDTO> foundStudentDTOS = studentService.findStudentsByAgeBetween(min, max);
        if (foundStudentDTOS == null) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudentDTOS);
    }

    /**
     * Getting students by faculty id.
     * @param facultyId faculty identification number.
     * @return the response with the found student list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the student list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find students by faculty id",
            description = "Search for students by faculty id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Students were successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Students not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/faculty-id")
    public ResponseEntity<List<StudentDTO>> getStudentsByFacultyId(@RequestParam ("facultyId") Long facultyId) {
        List<StudentDTO> foundStudentDTOS = studentService.findStudentsByFacultyId(facultyId);
        if (foundStudentDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudentDTOS);
    }

    /**
     * Getting all students.
     * @return the response with the found student list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the student list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find all students",
            description = "Search for all students"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Students were successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Students were not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> foundStudentDTOS = studentService.findAllStudents();
        if (foundStudentDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudentDTOS);
    }

    /**
     * Updating student.
     * @return the response with the updated student in JSON format and the HTTP 200 status code (Ok).<br>
     */
    @Operation(
            summary = "Update student by student id",
            description = "Search student by student id to update"
    )
    @Parameters(value = {
            @Parameter(name = "studentId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student was successfully updated",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = StudentDTO.class))
                            )
                    }
            )
    })
    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(studentDTO);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * Deleting student by id.
     * @param studentId student identification number.
     */
    @Operation(
            summary = "Delete student by student id",
            description = "Search student by student id to delete"
    )
    @Parameters(value = {
            @Parameter(name = "studentId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student was successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found"
            )
    })
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok().build();
    }
}
