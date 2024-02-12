package com.company.entity;

import com.company.entity.temp.AbsIntEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User extends AbsIntEntity {
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    public String password;
    @OneToMany
    @JoinTable(
            name = "orders",
            joinColumns ={@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Book> books;

    @Value("${app.users.default.balance}")
    private Double balance;
}
