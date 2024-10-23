package com.be.service;

import com.be.model.Income;
import com.be.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public Income getIncomeById(Integer id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found with id: " + id));
    }

    @Override
    public Income updateIncome(Integer id, Income income) {
        if (!incomeRepository.existsById(id)) {
            throw new RuntimeException("Income not found with id: " + id);
        }
        income.setIncomeId(id);
        return incomeRepository.save(income);
    }

    @Override
    public void deleteIncome(Integer id) {
        incomeRepository.deleteById(id);
    }
}
