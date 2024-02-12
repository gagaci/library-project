package com.company.entity;

import com.company.entity.temp.AbsIntEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Souvenir extends AbsIntEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Value("${app.default.price}")
    private Double price;
}
