package com.bestapp.MethodExecutionTimeTrackingSystem.model;

public interface MethodExecutionTimeTrackingStats {

    String getMethodName();
    Long getAverageExecutionTime();
    Long getTotalExecutionTime();
}
