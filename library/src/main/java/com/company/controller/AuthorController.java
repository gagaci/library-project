package com.company.controller;

import com.company.payload.ApiResult;
import com.company.payload.AuthorDTO;
import com.company.payload.AuthorResDTO;
import com.company.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthorController implements IAuthorController {

    private final IAuthorService authorService;


    @Override
    public ApiResult<AuthorResDTO> add(AuthorDTO authorDTO) {
        return authorService.add(authorDTO);
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByFirstNameAndLastName(String firstName, String lastName) {
        return authorService.searchByFirstAndLastname(firstName, lastName);
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByBirthDate(String birthDate) {
        return authorService.searchByBirthDate(birthDate);
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByDeathDate(String deathDate) {
        return authorService.searchByDeathDate(deathDate);
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByBirthDateAsc() {
        return authorService.sortingByBirthDateAsc();
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByBirthDateDesc() {
        return authorService.sortingByBirthDateDesc();
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByFirstNameAsc() {
        return authorService.sortingByFirstNameAsc();
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return authorService.delete(id);
    }

    @Override
    public ApiResult<AuthorResDTO> getAuthor(Integer id) {
        return authorService.getAuthor(id);
    }


}
