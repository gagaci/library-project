package com.company.controller;

import com.company.payload.ApiResult;
import com.company.payload.AuthorDTO;
import com.company.payload.AuthorResDTO;
import com.company.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(IAuthorController.BASE_PATH_FOR_AUTHOR_CONT)
public interface IAuthorController {

    String BASE_PATH_FOR_AUTHOR_CONT = AppConstants.BASE_PATH_FOR_ALL_PR + "/author";
    String SEARCH_BY_LAST_AND_FIRST_NAME = "/search-by-last-and-first-name";

    String SEARCH_BY_BIRTH_DATE = "/search-by-birth-date";

    String SEARCH_BY_DEATH_DATE = "/search-by-death-date";

    String SORTING_BY_BIRTH_DATE_ASC = "/sorting-by-birth-date-asc";
    String SORTING_BY_BIRTH_DATE_DESC = "/sorting-by-birth-date-desc";

    String SORTING_BY_FIRST_NAME_ASC = "/sorting-by-first-name-asc";


    @PostMapping
    ApiResult<AuthorResDTO> add(@Valid @RequestBody AuthorDTO authorDTO);

    @GetMapping(IAuthorController.SEARCH_BY_LAST_AND_FIRST_NAME)
    ApiResult<List<AuthorResDTO>> searchByFirstNameAndLastName(@RequestParam("first-name") String firstName, @RequestParam("last-name") String lastName);

    @GetMapping(IAuthorController.SEARCH_BY_BIRTH_DATE)
    ApiResult<List<AuthorResDTO>> searchByBirthDate(@RequestParam("birth-date") String birthDate);

    @GetMapping(IAuthorController.SEARCH_BY_DEATH_DATE)
    ApiResult<List<AuthorResDTO>> searchByDeathDate(@RequestParam("death-date") String deathDate);

    @GetMapping(IAuthorController.SORTING_BY_BIRTH_DATE_ASC)
    ApiResult<List<AuthorResDTO>> sortingByBirthDateAsc();
    @GetMapping(IAuthorController.SORTING_BY_BIRTH_DATE_DESC)
    ApiResult<List<AuthorResDTO>> sortingByBirthDateDesc();
    @GetMapping(IAuthorController.SORTING_BY_FIRST_NAME_ASC)
    ApiResult<List<AuthorResDTO>> sortingByFirstNameAsc();


    @DeleteMapping("/{id}")
    ApiResult<?> delete(@PathVariable Integer id);

    @GetMapping("/{id}")
    ApiResult<AuthorResDTO> getAuthor(@PathVariable Integer id);


}
