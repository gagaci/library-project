package com.company.entity;

import com.company.entity.temp.AbsIntEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book extends AbsIntEntity {
    @Column(nullable = false, unique = true)
    private String title;

    private LocalDate publishedAt;
    @Value("${app.default.price}")
    private Double price;
    @ManyToMany
    @JoinTable(name = "authors_of_book",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
    @Value("${app.default.price}")
    private Double discount;

}
