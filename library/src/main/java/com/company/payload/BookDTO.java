package com.company.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {
    @NotBlank
    private String title;
    @NotBlank
    private LocalDate publishedAt;

    private Double price;

    private Double discount;
}
