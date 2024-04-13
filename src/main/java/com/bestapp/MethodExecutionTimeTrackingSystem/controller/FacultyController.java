package com.bestapp.MethodExecutionTimeTrackingSystem.controller;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.FacultyDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.FacultyService;
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
 * Controller for the faculties
 * @see FacultyDTO
 * @see FacultyService
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/faculties")
@Tag(name = "Faculties")
public class FacultyController {

    private final FacultyService facultyService;

    /**
     * Creating a new faculty.
     * @return the response with the created faculty in JSON format and the HTTP 200 status code (Ok).<br>
     */
    @Operation(
            summary = "Create new faculty",
            description = "Create new faculty with faculty id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully created",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @PostMapping
    public ResponseEntity<FacultyDTO> createFaculty(@RequestBody FacultyDTO facultyDTO) {
        FacultyDTO createdFacultyDTO = facultyService.createFaculty(facultyDTO);
        return ResponseEntity.ok(createdFacultyDTO);
    }

    /**
     * Getting faculty by id.
     * @param id faculty identification number.
     * @return the response with the found faculty in JSON format and the HTTP 200 status code (Ok).<br>
     * If the faculty not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find faculty by faculty id",
            description = "Search faculty by faculty id"
    )
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculty not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(@PathVariable("id") Long id) {
        FacultyDTO foundFacultyDTO = facultyService.findFacultyById(id);
        if (foundFacultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFacultyDTO);
    }

    /**
     * Getting faculty by name.
     * @param facultyName faculty name.
     * @return the response with the found faculty in JSON format and the HTTP 200 status code (Ok).<br>
     * If the faculty not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find faculty by name",
            description = "Search faculty by name"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculty was not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/faculty-name")
    public ResponseEntity<FacultyDTO> getFacultyByName(@RequestParam("facultyName") String facultyName) {
        FacultyDTO foundFacultyDTO = facultyService.findFacultyByNameIgnoreCase(facultyName);
        if (foundFacultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFacultyDTO);
    }

    /**
     * Getting faculty by student id.
     * @param studentId student identification number.
     * @return the response with the found faculty in JSON format and the HTTP 200 status code (Ok).<br>
     * If the faculty not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find faculty by student id",
            description = "Search faculty by student id"
    )
    @Parameters(value = {
            @Parameter(name = "studentId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculty not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/faculty/student-id")
    public ResponseEntity<FacultyDTO> getFacultyByStudentId(@RequestParam("studentId") Long studentId) {
        FacultyDTO facultyDTO = facultyService.findFacultyByStudentId(studentId);
        if (facultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTO);
    }

    /**
     * Getting all faculties.
     * @return the response with the found faculty list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the faculty list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find all faculties",
            description = "Search for all faculties"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculties were successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculties were not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @GetMapping
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        List<FacultyDTO> foundFacultyDTOS = facultyService.findAllFaculties();
        if (foundFacultyDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFacultyDTOS);
    }

    /**
     * Updating faculty.
     * @return the response with the updated faculty in JSON format and the HTTP 200 status code (Ok).<br>
     */
    @Operation(
            summary = "Update faculty by faculty id",
            description = "Search faculty by faculty id to update"
    )
    @Parameters(value = {
            @Parameter(name = "facultyId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully updated",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculty not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = FacultyDTO.class))
                            )
                    }
            )
    })
    @PutMapping
    public ResponseEntity<FacultyDTO> updateFaculty(@RequestBody FacultyDTO facultyDTO) {
        FacultyDTO updatedFacultyDTO = facultyService.updateFaculty(facultyDTO);
        if (updatedFacultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFacultyDTO);
    }

    /**
     * Deleting faculty by id.
     * @param id faculty identification number.
     */
    @Operation(
            summary = "Delete faculty by faculty id",
            description = "Search faculty by faculty id to delete"
    )
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Faculty was successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Faculty not found"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultyById(@PathVariable("id") Long id) {
        facultyService.deleteFacultyById(id);
        return ResponseEntity.ok().build();
    }
}
