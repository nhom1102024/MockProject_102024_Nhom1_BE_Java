package com.be.controller;

import com.be.dto.IncomeResponseDto;
import com.be.model.Income;
import com.be.service.IncomeService;
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
    public ResponseEntity<IncomeResponseDto> createIncome(@RequestBody Income income) {
       
        Income createdIncome = incomeService.createIncome(income);
        IncomeResponseDto responseDTO = new IncomeResponseDto(
            createdIncome.getIncomeId(),
            createdIncome.getEmployee().getEmployeeId(), 
            createdIncome.getIncomeType().getIncomeTypeId(), 
            createdIncome.getAmount(),
            createdIncome.getDescription(),
            createdIncome.getReceivedDateTime()
        );
        
        
    
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IncomeResponseDto>> getAllIncomes() {
        List<Income> incomes = incomeService.getAllIncomes();
        List<IncomeResponseDto> responseDTOs = incomes.stream()
                .map(income -> new IncomeResponseDto(
                        income.getIncomeId(),
                        income.getEmployee().getEmployeeId(),
                        income.getIncomeType().getIncomeTypeId(), 
                        income.getAmount(),
                        income.getDescription(),
                        income.getReceivedDateTime()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponseDto> getIncomeById(@PathVariable Integer id) {
        Income income = incomeService.getIncomeById(id);
        IncomeResponseDto responseDTO = new IncomeResponseDto(
                income.getIncomeId(),
                income.getEmployee().getEmployeeId(),
                income.getIncomeType().getIncomeTypeId(), 
                income.getAmount(),
                income.getDescription(),
                income.getReceivedDateTime()
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeResponseDto> updateIncome(@PathVariable Integer id, @RequestBody Income income) {
        Income updatedIncome = incomeService.updateIncome(id, income);
        IncomeResponseDto responseDTO = new IncomeResponseDto(
                updatedIncome.getIncomeId(),
                updatedIncome.getEmployee().getEmployeeId(),
                updatedIncome.getIncomeType().getIncomeTypeId(), 
                updatedIncome.getAmount(),
                updatedIncome.getDescription(),
                updatedIncome.getReceivedDateTime()
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Integer id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
