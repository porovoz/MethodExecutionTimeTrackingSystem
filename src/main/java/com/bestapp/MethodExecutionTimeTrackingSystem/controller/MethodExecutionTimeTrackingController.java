package com.bestapp.MethodExecutionTimeTrackingSystem.controller;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingStatsDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingStatsService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller for the method execution time tracking objects
 * @see MethodExecutionTimeTrackingDTO
 * @see MethodExecutionTimeTrackingStatsDTO
 * @see MethodExecutionTimeTrackingStatsService
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/method-execution-time-tracking")
@Tag(name = "Method execution time tracking")
public class MethodExecutionTimeTrackingController {

    private final MethodExecutionTimeTrackingStatsService methodExecutionTimeTrackingStatsService;

    /**
     * Getting all method execution time tracking.
     * @param pageNumber page number
     * @param pageSize page size
     * @return the response with the found method execution time tracking list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the method execution time tracking list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find all method execution time tracking pageable",
            description = "Search all method execution time tracking pageable"
    )
    @Parameters(value = {
            @Parameter(name = "pageNumber", example = "1"),
            @Parameter(name = "pageSize", example = "20")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "All method execution time tracking successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = MethodExecutionTimeTrackingDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Method execution time tracking not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = MethodExecutionTimeTrackingDTO.class))
                            )
                    }
            )
    })
    @GetMapping
    public ResponseEntity<List<MethodExecutionTimeTrackingDTO>> getAllMethodExecutionTimeTrackingPageable(
            @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize) {
        List<MethodExecutionTimeTrackingDTO> methodExecutionTimeTrackingDTOS =
                methodExecutionTimeTrackingStatsService.findAllMethodExecutionTimeTrackingPageable(pageNumber, pageSize);
        if (methodExecutionTimeTrackingDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(methodExecutionTimeTrackingDTOS);
    }

    /**
     * Getting all method execution time tracking statistics.
     * @param methodName page number
     * @return the response with the found method execution time tracking statistics list in JSON format and the HTTP 200 status code (Ok).<br>
     * If the method execution time tracking statistics list not found the HTTP status code 404 (Not found).
     */
    @Operation(
            summary = "Find all method execution time tracking statistics",
            description = "Search all method execution time tracking statistics"
    )
    @Parameters(value = {
            @Parameter(name = "methodName", example = "findAllStudents")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "All method execution time tracking statistics successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = MethodExecutionTimeTrackingStatsDTO.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Method execution time tracking statistics not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = MethodExecutionTimeTrackingStatsDTO.class))
                            )
                    }
            )
    })
    @GetMapping("/all-stats")
    public ResponseEntity<List<MethodExecutionTimeTrackingStatsDTO>> getAllMethodExecutionTimeTrackingStats(@RequestParam(name = "methodName", required = false) String methodName) {
        List<MethodExecutionTimeTrackingStatsDTO> methodExecutionTimeTrackingStatsDTOS =
                methodExecutionTimeTrackingStatsService.findAllMethodExecutionTimeTrackingStats(methodName);
        if (methodExecutionTimeTrackingStatsDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(methodExecutionTimeTrackingStatsDTOS);
    }
}
