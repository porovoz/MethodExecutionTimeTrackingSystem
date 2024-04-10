package com.bestapp.MethodExecutionTimeTrackingSystem.dto;

import lombok.Data;

@Data
public class MethodExecutionTimeTrackingDTO {

    private Long id;
    private String methodName;
    private Long executionTime;
}
