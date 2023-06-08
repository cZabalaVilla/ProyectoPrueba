package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.annotations.Model;
import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.dto.Budget;

import java.util.List;

@Model(type = "Service", version = "1.0", date = "01/06/2023")
public class BudgetService {

    private final BudgetClient budgetClient;

    public BudgetService(BudgetClient budgetClient) {
        this.budgetClient = budgetClient;
    }
    public String ping() {
        return budgetClient.ping();
    }
    public Budget getBudgetByName(String budgetName) {
        return budgetClient.get(budgetName);
    }
    public Budget getBudgetById(int budgetId) {return budgetClient.get(budgetId); }
    public List<Budget> getAllBudgets() {
        return budgetClient.get();
    }
    public List<Budget> getAllBudgetsByUserId(int userId) {return budgetClient.getAllBy(userId);}
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
