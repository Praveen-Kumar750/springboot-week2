package com.praveen.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.praveen.springbootwebtutorial.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;

    @NotNull(message = "Name is Required here")
    @Size(min=3,max=10,message = "Number of characters in Name should be in the range of 3-10")
    private String name;

    @Email(message = "Email is not valid")
    private  String email;

    @Max(value = 80,message = "Age of employee  cannot greater than 80")
    @Min(value = 18,message = "Age of employee cannot be less than 18")
    private  Integer age;

    @NotBlank(message = "role cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of employee can be user or admin")
    @EmployeeRoleValidation
    private String role;//ADMIN,USER

    @NotNull(message = "Salary Of Employee sholud be not null")
    @Positive(message = "Salary Of Employee sholud be Positive")
    @Digits(integer = 6,fraction = 2,message = "Salary can be in the form xxxx.yy ")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "Date Of joining field cannot be future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

//
//
//    private Long id;
//
//    @NotNull(message = "Name is Required here")
//    @Size(min=3,max=10,message = "Number of characters in Name should be in the range of 3-10")
//    private String name;
//
//    @Email(message = "Email is not valid")
//    private  String email;
//
//    @Max(value = 80,message = "Age of employee  cannot greater than 80")
//    @Min(value = 18,message = "Age of employee cannot be less than 18")
//    private  Integer age;
//
//    @NotBlank(message = "role cannot be blank")
////    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of employee can be user or admin")
//    @EmployeeRoleValidation
//    private String role;//ADMIN,USER
//
//    @NotNull(message = "Salary Of Employee sholud be not null")
//    @Positive(message = "Salary Of Employee sholud be Positive")
//    @Digits(integer = 6,fraction = 2,message = "Salary can be in the form xxxx.yy ")
//    @DecimalMax(value = "100000.99")
//    @DecimalMin(value = "100.50")
//    private Double salary;
//
//    @PastOrPresent(message = "Date Of joining field cannot be future")
//    private LocalDate dateOfJoining;
//
//    @AssertTrue(message = "Employee should be active")
//    @JsonProperty("isActive")
//    private Boolean isActive;
}
