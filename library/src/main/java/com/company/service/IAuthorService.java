package com.company.service;

import com.company.payload.ApiResult;
import com.company.payload.AuthorDTO;
import com.company.payload.AuthorResDTO;

import java.util.List;


public interface IAuthorService {
    ApiResult<AuthorResDTO> add(AuthorDTO authorDTO);


    ApiResult<AuthorResDTO> getAuthor(Integer id);

    ApiResult<?> delete(Integer id);
    ApiResult<List<AuthorResDTO>> searchByFirstAndLastname(String firstName, String lastName);

    ApiResult<List<AuthorResDTO>> searchByBirthDate(String birthDate);

    ApiResult<List<AuthorResDTO>> searchByDeathDate(String deathDate);

    ApiResult<List<AuthorResDTO>> sortingByBirthDateAsc();

    ApiResult<List<AuthorResDTO>> sortingByBirthDateDesc();

    ApiResult<List<AuthorResDTO>> sortingByFirstNameAsc();
}

