package com.company.service;

import com.company.entity.Author;
import com.company.exception.AppException;
import com.company.payload.ApiResult;
import com.company.payload.AuthorDTO;
import com.company.payload.AuthorResDTO;
import com.company.payload.AuthorResDTOMapper;
import com.company.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorResDTOMapper authorResDTOMapper;

    @Override
    public ApiResult<AuthorResDTO> add(AuthorDTO authorDTO) {
        checkAuthorDTO(authorDTO);
        checkAuthorBirthDate(authorDTO.getBirthDate());
        checkAuthorDeathDate(authorDTO.getDeathDate());
        exists(authorDTO);
        Author.AuthorBuilder authorBuilder = Author.builder();
        authorBuilder.firstName(authorDTO.getFirstName());
        authorBuilder.lastName(authorDTO.getLastName());
        checkAuthorBirthDate(authorDTO.getBirthDate());
        authorBuilder.birthDate(LocalDate.parse(authorDTO.getBirthDate()));
        authorBuilder.deathDate(authorDTO.getDeathDate());
        return ApiResult.successResponse(authorResDTOMapper.apply(authorRepository.save(authorBuilder.build())));
    }


    @Override
    public ApiResult<AuthorResDTO> getAuthor(Integer id) {
        checkAuthorById(id);
        return ApiResult.successResponse(authorResDTOMapper.apply(authorRepository.findById(id).orElseThrow()));
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        checkAuthorById(id);
        authorRepository.deleteById(id);
        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByFirstAndLastname(String firstName, String lastName) {
        List<Author> authorList = authorRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        if (authorList.isEmpty()) throw AppException.appThrow("No data found", HttpStatus.NOT_FOUND);
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByBirthDate(String birthDate) {
        checkAuthorBirthDate(birthDate);
        List<Author> authorList = authorRepository.findByBirthDate(LocalDate.parse(birthDate));
        if (authorList.isEmpty()) throw AppException.appThrow("No data found", HttpStatus.NOT_FOUND);
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }

    @Override
    public ApiResult<List<AuthorResDTO>> searchByDeathDate(String deathDate) {
        checkAuthorDeathDate(deathDate);
        List<Author> authorList = authorRepository.findByDeathDate(deathDate);
        if (authorList.isEmpty()) throw AppException.appThrow("No data found", HttpStatus.NOT_FOUND);
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByBirthDateAsc() {
        List<Author> authorList = authorRepository.findAll(Sort.by(Sort.Direction.ASC, "birthDate"));
        if (authorList.isEmpty()) throw AppException.appThrow("No data found", HttpStatus.NOT_FOUND);
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByBirthDateDesc() {
        List<Author> authorList = authorRepository.findAll(Sort.by(Sort.Direction.DESC, "birthDate"));
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }

    @Override
    public ApiResult<List<AuthorResDTO>> sortingByFirstNameAsc() {
        List<Author> authorList = authorRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        return ApiResult.successResponse(authorList.stream().map(authorResDTOMapper).collect(Collectors.toList()));
    }


    private void checkAuthorById(Integer id) {
        boolean exists = authorRepository.existsById(id);
        if (!exists) throw AppException.appThrow("The Author with this id doesn't exist");
    }


    private void exists(AuthorDTO authorDTO) {
        boolean exists = authorRepository.existsByFirstNameAndLastNameAndBirthDate(authorDTO.getFirstName(), authorDTO.getLastName(), LocalDate.parse(authorDTO.getBirthDate()));
        if (exists) throw AppException.appThrow("this author already exists");
    }


    private void checkAuthorBirthDate(String birthDate) {
        if (Objects.isNull(birthDate)) throw AppException.appThrow("Author's birth date is invalid");
        if (!Pattern.matches("[-0-9]{10}", birthDate)) throw AppException.appThrow("Invalid birth date");
    }

    private void checkAuthorDeathDate(String deathDate) {
        if (Objects.isNull(deathDate)) return;
        if (!Pattern.matches("[-0-9]{10}", deathDate)) throw AppException.appThrow("Invalid death date");

    }

    private void checkAuthorDTO(AuthorDTO authorDTO) {
        if (Objects.isNull(authorDTO)) throw AppException.appThrow("Author is fully null");

        if (authorDTO.getFirstName().isEmpty() || authorDTO.getFirstName().isBlank())
            throw AppException.appThrow("Author's first name is empty");


        if (authorDTO.getLastName().isEmpty() || authorDTO.getLastName().isBlank())
            throw AppException.appThrow("Author's last name is empty");
    }

    public static void main(String[] args) {
        //[a-zA-Z]{3}|^[^\\d].*|([\\w&&[^b]])
        boolean matches3 = Pattern.matches("[-0-9]{10}", "12-06-2023");
        boolean matches4 = Pattern.matches("[^\\w.]{2}", "--");
        System.out.println(matches3);
        System.out.println(matches4);
//    }
        //...
        //static Pattern p1 = Pattern.compile("[a-zA-Z]{3}");
        //static Pattern p2 = Pattern.compile("^[^\\d].*");
        //static Pattern p3 = Pattern.compile("([\\w&&[^b]])*");
        //
        //public static boolean test(String s){
        //   return p1.matcher(s).matches ? true:
        //        p2.matcher(s).matches ? true:
        //        p3.matcher(s).matches;
        //}
    }
}
