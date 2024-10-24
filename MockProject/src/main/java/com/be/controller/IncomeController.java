package com.be.controller;

import com.be.dto.IncomeResponseDto;
import com.be.model.Income;

import com.be.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;


    @PostMapping
    public ResponseEntity<IncomeResponseDto> createIncome(@Valid @RequestBody Income income) {
        Income createdIncome = incomeService.createIncome(income);
        IncomeResponseDto responseDTO = createResponseDto(createdIncome);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponseDto> getIncomeById(@PathVariable Integer id) {
        try {
            Income income = incomeService.getIncomeById(id);
            IncomeResponseDto responseDTO = createResponseDto(income);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            System.err.println("Entity not found: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Internal server error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<IncomeResponseDto>> getAllIncomes() {
        try {
            List<Income> incomes = incomeService.getAllIncomes();
            List<IncomeResponseDto> responseDTOs = incomes.stream()
                    .map(this::createResponseDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Internal server error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<IncomeResponseDto> updateIncome(@PathVariable Integer id, @Valid @RequestBody Income incomeDetails) {
        try {
            Income updatedIncome = incomeService.updateIncome(id, incomeDetails);
            IncomeResponseDto responseDTO = createResponseDto(updatedIncome);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            System.err.println("Entity not found: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.err.println("Internal server error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Integer id) {
        try {
            incomeService.deleteIncome(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            System.err.println("Entity not found: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Internal server error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private IncomeResponseDto createResponseDto(Income income) {
        Integer employeeId = (income.getEmployee() != null) ? income.getEmployee().getEmployeeId() : null;
        Integer incomeTypeId = (income.getIncomeType() != null) ? income.getIncomeType().getIncomeTypeId() : null;

        return new IncomeResponseDto(
                income.getIncomeId(),
                employeeId,
                incomeTypeId,
                income.getAmount(),
                income.getDescription(),
                income.getReceivedDateTime()
        );
    }
}
