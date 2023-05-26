package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.dto.Budget;

import java.util.List;

public class BudgetService {
    private final BudgetClient budgetClient;

    public BudgetService(BudgetClient budgetClient) {
        this.budgetClient = budgetClient;
    }

    public String ping() {
        return budgetClient.ping();
    }
    public Budget getBudget(String budgetName) {
        return budgetClient.get(budgetName);
    }

    public List<Budget> getAllBudgets() {
        return budgetClient.get();
    }

    public boolean updateBudget(Budget budget) {
        return budgetClient.put(budget);
    }

    public boolean createBudget(Budget budget) {
        return budgetClient.post(budget);
    }

    public boolean deleteBudget(Budget budget) {
        return budgetClient.delete(budget);
    }

}
