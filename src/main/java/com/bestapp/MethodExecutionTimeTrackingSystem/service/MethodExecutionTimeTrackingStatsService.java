package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingStatsDTO;

import java.util.List;

public interface MethodExecutionTimeTrackingStatsService {

    /**
     * Getting all method execution time tracking pageable
     */
    List<MethodExecutionTimeTrackingDTO> findAllMethodExecutionTimeTrackingPageable(Integer pageNumber, Integer pageSize);

    /**
     * Getting all method execution time tracking statistics
     * @param methodName method name in database
     */
    List<MethodExecutionTimeTrackingStatsDTO> findAllMethodExecutionTimeTrackingStats(String methodName);
}
