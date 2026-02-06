package com.praveen.springbootwebtutorial.controllers;


import com.praveen.springbootwebtutorial.dto.EmployeeDTO;
import com.praveen.springbootwebtutorial.entities.EmployeeEntity;
import com.praveen.springbootwebtutorial.exception.ResourceNotFoundException;
import com.praveen.springbootwebtutorial.repositories.EmployeeRepository;
import com.praveen.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ UPDATED PART ONLY
    @GetMapping(path="/{empid}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long empid) {

        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(empid);

        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + empid));
    }

    @GetMapping(path="")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String sortBy) {

        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmp(
            @RequestBody @Valid EmployeeDTO input) {

        EmployeeDTO saveEmployee = employeeService.createNewEmp(input);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(
            @RequestBody @Valid EmployeeDTO employeeDTO,
            @PathVariable Long empId) {
        EmployeeDTO std=employeeService.updateEmployeeById(empId, employeeDTO);

        return ResponseEntity.ok(
                std);
    }

    @DeleteMapping(path="{empId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long empId) {

        boolean gotDeleted = employeeService.deleteEmployeeById(empId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{empId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @RequestBody Map<String, Object> updates,
            @PathVariable Long empId) {

        EmployeeDTO employeeDTO =
                employeeService.updatePartialEmployeeById(empId, updates);

        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}