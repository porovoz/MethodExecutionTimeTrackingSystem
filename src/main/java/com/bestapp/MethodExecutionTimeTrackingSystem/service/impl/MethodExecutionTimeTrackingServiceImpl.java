package com.bestapp.MethodExecutionTimeTrackingSystem.service.impl;

import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.repository.MethodExecutionTimeTrackingRepository;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the service to work with the method execution time tracking objects
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MethodExecutionTimeTrackingServiceImpl implements MethodExecutionTimeTrackingService {

    private final MethodExecutionTimeTrackingRepository methodExecutionTimeTrackingRepository;

    /**
     * Saving a method execution time tracking object to a database.<br>
     * - The repository method is used {@link MethodExecutionTimeTrackingRepository#save(Object)}. <br>
     * @param methodExecutionTimeTracking method execution time tracking object. Must not be null.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    @Override
    @Transactional
    @Async
    public void saveMethodExecutionTimeTracking(MethodExecutionTimeTracking methodExecutionTimeTracking) {
        log.info("Save method execution time tracking method was invoked");
        methodExecutionTimeTrackingRepository.save(methodExecutionTimeTracking);
        log.info("Method execution time tracking {} was saved successfully", methodExecutionTimeTracking);
    }
}
