package com.company.entity;

import com.company.entity.temp.AbsIntEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"firstName", "lastName","birthDate"})
})
public class Author extends AbsIntEntity {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    private String deathDate;


}
