package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingStatsDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTrackingStats;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MethodExecutionTimeTrackingMapperImpl} class is a component responsible for converting
 * method execution time tracking entities (MethodExecutionTimeTracking) and DTO
 * (Data Transfer Object) to various formats and vice versa.
 */
@Component
public class MethodExecutionTimeTrackingMapperImpl implements MethodExecutionTimeTrackingMapper {

    @Override
    public MethodExecutionTimeTrackingDTO toMethodExecutionTimeTrackingDTO(MethodExecutionTimeTracking methodExecutionTimeTracking) {
        MethodExecutionTimeTrackingDTO methodExecutionTimeTrackingDTO = new MethodExecutionTimeTrackingDTO();
        methodExecutionTimeTrackingDTO.setId(methodExecutionTimeTracking.getId());
        methodExecutionTimeTrackingDTO.setMethodName(methodExecutionTimeTracking.getMethodName());
        methodExecutionTimeTrackingDTO.setExecutionTime(methodExecutionTimeTracking.getExecutionTime());
        return methodExecutionTimeTrackingDTO;
    }

    @Override
    public List<MethodExecutionTimeTrackingDTO> toMethodExecutionTimeTrackingDTOS(List<MethodExecutionTimeTracking> methodExecutionTimeTrackingList) {
        List<MethodExecutionTimeTrackingDTO> methodExecutionTimeTrackingDTOS = new ArrayList<>();
        for (MethodExecutionTimeTracking methodExecutionTimeTracking : methodExecutionTimeTrackingList) {
            MethodExecutionTimeTrackingDTO methodExecutionTimeTrackingDTO = toMethodExecutionTimeTrackingDTO(methodExecutionTimeTracking);
            methodExecutionTimeTrackingDTOS.add(methodExecutionTimeTrackingDTO);
        }
        return methodExecutionTimeTrackingDTOS;
    }

    @Override
    public List<MethodExecutionTimeTrackingStatsDTO> toMethodExecutionTimeTrackingStatsDTOList(List<MethodExecutionTimeTrackingStats> methodExecutionTimeTrackingStatsList) {
        List<MethodExecutionTimeTrackingStatsDTO> methodExecutionTimeTrackingStatsDTOS = new ArrayList<>();
        for (MethodExecutionTimeTrackingStats methodExecutionTimeTrackingStats : methodExecutionTimeTrackingStatsList) {
            MethodExecutionTimeTrackingStatsDTO methodExecutionTimeTrackingStatsDTO = toMethodExecutionTimeTrackingStatsDTO(methodExecutionTimeTrackingStats);
            methodExecutionTimeTrackingStatsDTOS.add(methodExecutionTimeTrackingStatsDTO);
        }
        return methodExecutionTimeTrackingStatsDTOS;
    }

    @Override
    public MethodExecutionTimeTrackingStatsDTO toMethodExecutionTimeTrackingStatsDTO(MethodExecutionTimeTrackingStats methodExecutionTimeTrackingStats) {
        MethodExecutionTimeTrackingStatsDTO methodExecutionTimeTrackingStatsDTO = new MethodExecutionTimeTrackingStatsDTO();
        methodExecutionTimeTrackingStatsDTO.setMethodName(methodExecutionTimeTrackingStats.getMethodName());
        methodExecutionTimeTrackingStatsDTO.setAverageExecutionTime(methodExecutionTimeTrackingStats.getAverageExecutionTime());
        methodExecutionTimeTrackingStatsDTO.setTotalExecutionTime(methodExecutionTimeTrackingStats.getTotalExecutionTime());
        return methodExecutionTimeTrackingStatsDTO;
    }
}
