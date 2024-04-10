package com.bestapp.MethodExecutionTimeTrackingSystem.repository;

import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTracking;
import com.bestapp.MethodExecutionTimeTrackingSystem.model.MethodExecutionTimeTrackingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * An interface containing methods for working with a database of objects of the MethodExecutionTimeTracking class
 * @see MethodExecutionTimeTracking
 * @see com.bestapp.MethodExecutionTimeTrackingSystem.service.MethodExecutionTimeTrackingService
 */
@Repository
public interface MethodExecutionTimeTrackingRepository extends JpaRepository<MethodExecutionTimeTracking, Long> {

    /**
     * Getting method execution time tracking statistics
     * @param methodName method name in database
     */
    @Query(value = "SELECT " +
            "m.method_name AS methodName, " +
            "AVG(m.execution_time) AS averageExecutionTime, " +
            "SUM(m.execution_time) AS totalExecutionTime " +
            "FROM method_execution_time_tracking m " +
            "WHERE (?1 IS NULL OR m.method_name IN(?1)) " +
            "GROUP BY m.method_name " +
            "ORDER BY averageExecutionTime",
            nativeQuery = true)
    List<MethodExecutionTimeTrackingStats> findAllMethodExecutionTimeTrackingExecutionTimeStats(@Param("methodName") String methodName);
}
