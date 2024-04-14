package com.bestapp.MethodExecutionTimeTrackingSystem.dto;

import lombok.Data;

@Data
public class MethodExecutionTimeTrackingStatsDTO {

    private String methodName;
    private Long averageExecutionTime;
    private Long totalExecutionTime;
}
