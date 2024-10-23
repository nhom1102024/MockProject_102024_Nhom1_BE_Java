package com.be.service;

import com.be.model.Income;
import java.util.List;

public interface IncomeService {
    Income createIncome(Income income);
    List<Income> getAllIncomes();
    Income getIncomeById(Integer id);
    Income updateIncome(Integer id, Income income);
    void deleteIncome(Integer id);
}
