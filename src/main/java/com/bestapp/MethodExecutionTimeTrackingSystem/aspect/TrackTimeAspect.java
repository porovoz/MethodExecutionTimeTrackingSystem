package com.bestapp.MethodExecutionTimeTrackingSystem.aspect;

import com.bestapp.MethodExecutionTimeTrackingSystem.exception.MethodExecutionTimeTrackingException;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final MethodExecutionTimeTrackingService methodExecutionTimeTrackingService;

    @Pointcut("@annotation(com.bestapp.MethodExecutionTimeTrackingSystem.annotation.TrackTime)")
    public void trackTimePointcut() {}

    @Around("trackTimePointcut()")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            long startTime = System.currentTimeMillis();
            String methodName = proceedingJoinPoint.getSignature().getName();
            Object[] methodArgs = proceedingJoinPoint.getArgs();
            log.info("Method execution: {} with arguments: {}", methodName, methodArgs);
            Object result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long methodExecutionTime = endTime - startTime;
            log.info("Method {} was executed in {} ms with the result {}", methodName, methodExecutionTime, result);
            MethodExecutionTimeTracking methodExecutionTimeTracking = buildMethodExecutionTimeTracking(proceedingJoinPoint, methodExecutionTime);
            methodExecutionTimeTrackingService.saveMethodExecutionTimeTracking(methodExecutionTimeTracking);
            return result;
        } catch (Throwable e) {
            log.error("An error occurred in method: {}", proceedingJoinPoint.getSignature().toLongString(), e);
            throw new MethodExecutionTimeTrackingException(e);
        }
    }

    private MethodExecutionTimeTracking buildMethodExecutionTimeTracking(ProceedingJoinPoint proceedingJoinPoint, long methodExecutionTime) {
        String methodName = proceedingJoinPoint.getSignature().getName();
        return MethodExecutionTimeTracking.builder()
                .methodName(methodName)
                .executionTime(methodExecutionTime)
                .build();
    }
}
