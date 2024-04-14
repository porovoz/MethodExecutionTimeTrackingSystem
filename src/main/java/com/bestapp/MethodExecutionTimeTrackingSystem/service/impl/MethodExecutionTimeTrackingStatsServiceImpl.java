package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.dto.MethodExecutionTimeTrackingStatsDTO;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTrackingStats;
import com.bestapp.MethodExecutionTimeTrackingSystem.repository.MethodExecutionTimeTrackingRepository;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingMapper;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the service to work with the method execution time tracking objects
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MethodExecutionTimeTrackingStatsServiceImpl implements MethodExecutionTimeTrackingStatsService {

    private final MethodExecutionTimeTrackingRepository methodExecutionTimeTrackingRepository;
    private final MethodExecutionTimeTrackingMapper methodExecutionTimeTrackingMapper;

    /** Getting all method execution time tracking pageable.<br>
     * - Search for all method execution time tracking pageable {@link MethodExecutionTimeTrackingRepository#findAll(Example, Pageable)}.<br>
     * - Converting all method execution time tracking list
     * into method execution time tracking data transfer object list {@link MethodExecutionTimeTrackingMapper#toMethodExecutionTimeTrackingDTOS(List)}.
     * @param pageNumber page number
     * @param pageSize page size
     * @return all method execution time tracking data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    public List<MethodExecutionTimeTrackingDTO> findAllMethodExecutionTimeTrackingPageable(Integer pageNumber, Integer pageSize) {
        log.info("Find all method execution time tracking pageable method was invoked");
        if (pageSize > 50 || pageSize <= 0) {
            pageSize = 50;
        }
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        List<MethodExecutionTimeTracking> methodExecutionTimeTrackingList =
                methodExecutionTimeTrackingRepository.findAll(pageRequest).getContent();
        log.info("Method execution time tracking pageable list successfully found");
        return methodExecutionTimeTrackingMapper.toMethodExecutionTimeTrackingDTOS(methodExecutionTimeTrackingList);
    }

    /** Getting all method execution time tracking statistics. <br>
     * - Search for all method execution time tracking statistics {@link MethodExecutionTimeTrackingRepository#findAllMethodExecutionTimeTrackingExecutionTimeStats(String)}.<br>
     * - Converting all method execution time tracking statistics list
     * into method execution time tracking statistics data transfer object list {@link MethodExecutionTimeTrackingMapper#toMethodExecutionTimeTrackingStatsDTOList(List)}.
     * @param methodName method name in database
     * @return all method execution time tracking statistics data transfer object list
     */
    @Override
    @Transactional(readOnly = true)
    public List<MethodExecutionTimeTrackingStatsDTO> findAllMethodExecutionTimeTrackingStats(String methodName) {
        log.info("Find all method execution time tracking pageable method was invoked");
         List<MethodExecutionTimeTrackingStats> methodExecutionTimeTrackingStats =
                 methodExecutionTimeTrackingRepository.findAllMethodExecutionTimeTrackingExecutionTimeStats(methodName);
        log.info("Method execution time tracking pageable list successfully found");
         return methodExecutionTimeTrackingMapper.toMethodExecutionTimeTrackingStatsDTOList(methodExecutionTimeTrackingStats);
    }
}
