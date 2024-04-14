package com.bestapp.MethodExecutionTimeTrackingSystem.service;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingStatsDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTrackingStats;

import java.util.List;

/**
 * The {@code MethodExecutionTimeTrackingMapper} is an interface responsible for converting
 * method execution time tracking entities (MethodExecutionTimeTracking) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
public interface MethodExecutionTimeTrackingMapper {

    MethodExecutionTimeTrackingDTO toMethodExecutionTimeTrackingDTO(MethodExecutionTimeTracking methodExecutionTimeTracking);
    List<MethodExecutionTimeTrackingDTO> toMethodExecutionTimeTrackingDTOS(List<MethodExecutionTimeTracking> methodExecutionTimeTrackingList);
    List<MethodExecutionTimeTrackingStatsDTO> toMethodExecutionTimeTrackingStatsDTOList(List<MethodExecutionTimeTrackingStats> methodExecutionTimeTrackingStatsList);
    MethodExecutionTimeTrackingStatsDTO toMethodExecutionTimeTrackingStatsDTO(MethodExecutionTimeTrackingStats methodExecutionTimeTrackingStats);
}
