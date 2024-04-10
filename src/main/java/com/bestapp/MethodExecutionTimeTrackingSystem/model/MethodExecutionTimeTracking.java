package com.bestapp.MethodExecutionTimeTrackingSystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "method_execution_time_tracking")
public class MethodExecutionTimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(name = "execution_time")
    private Long executionTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodExecutionTimeTracking that = (MethodExecutionTimeTracking) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
