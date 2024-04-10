package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;

public interface MethodExecutionTimeTrackingService {

    /**
     * Saving method execution time tracking object
     * @param methodExecutionTimeTracking method execution time tracking object
     */
    void saveMethodExecutionTimeTracking(MethodExecutionTimeTracking methodExecutionTimeTracking);
}
