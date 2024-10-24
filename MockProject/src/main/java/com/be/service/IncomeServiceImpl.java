package com.be.service;

import com.be.model.Income;
import com.be.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income createIncome(Income income) {
        Income createdIncome = incomeRepository.save(income);
        System.out.println("Created Income: " + createdIncome); 
        return createdIncome;
    }
    

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public Income getIncomeById(Integer id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income not found with id: " + id));
    }
    

    @Override
    public Income updateIncome(Integer id, Income income) {

        Income existingIncome = incomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income not found with id: " + id));

        existingIncome.setAmount(income.getAmount());
        existingIncome.setDescription(income.getDescription());
        existingIncome.setReceivedDateTime(income.getReceivedDateTime());
        
        if (income.getEmployee() != null) {
            existingIncome.setEmployee(income.getEmployee());
        }
        if (income.getIncomeType() != null) {
            existingIncome.setIncomeType(income.getIncomeType());
        }
        return incomeRepository.save(existingIncome);
    }


        @Override
        public void deleteIncome(Integer id) {
        
            if (!incomeRepository.existsById(id)) {
                throw new RuntimeException("Income not found with id: " + id);
            }
            incomeRepository.deleteById(id);
        }
    }
