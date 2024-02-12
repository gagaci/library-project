package com.company.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResDTO {
    public Integer id;

    public String title;

    private LocalDate publishedAt;

    private Double price;

    private Double discount;

    private Set<AuthorResDTO> authorResDTOSet;
}
