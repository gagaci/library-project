package com.company.payload;

import com.company.entity.Author;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class AuthorResDTOMapper implements Function<Author,AuthorResDTO> {
    @Override
    public AuthorResDTO apply(Author author) {
        return new AuthorResDTO(author.getId(),
                author.getFirstName(), author.getLastName(),
                author.getBirthDate(), author.getDeathDate());
    }
}
