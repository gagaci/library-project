package com.company.entity.temp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
public abstract class AbsEntity {
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(updatable = false)
    private Integer createdById;

    @LastModifiedBy
    private Integer updatedById;
}
