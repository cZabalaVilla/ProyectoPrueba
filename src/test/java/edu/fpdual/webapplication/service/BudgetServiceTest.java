package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.dto.Budget;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BudgetServiceTest {

    static BudgetService budgetService;

    @BeforeAll
    static void beforeAll() {
        budgetService = new BudgetService(new BudgetClient());
    }

    @AfterAll
    static void afterAll() {
        budgetService = null;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ping() {
        String ping = "Service online";
        assertEquals(ping, budgetService.ping());
    }

    @Test
    void getBudgetByName() {
        String budgetName = "mensualidad";
        Budget budget = budgetService.getBudgetByName(budgetName);

        assertAll("Budget Properties",
                () -> assertEquals(1, budget.getBudgetId()),
                () -> assertEquals(2, budget.getUserId()),
                () -> assertEquals("Gastos mensuales", budget.getDescription()),
                () -> assertEquals(1, budget.getCurrencyId()),
                () -> assertEquals(Timestamp.valueOf("2023-05-01 02:00:00"), budget.getCreationDate())
        );
    }

    @Test
    void getBudgetById() {
        int budgetId = 1;
        Budget budget = budgetService.getBudgetById(budgetId);

        assertAll("Budget Properties",
                () -> assertEquals("mensualidad", budget.getBudgetName()),
                () -> assertEquals(2, budget.getUserId()),
                () -> assertEquals("Gastos mensuales", budget.getDescription()),
                () -> assertEquals(1, budget.getCurrencyId()),
                () -> assertEquals(Timestamp.valueOf("2023-05-01 02:00:00"), budget.getCreationDate())
        );
    }

    @Test
    void getAllBudgets() {
        List<Budget> budgets = budgetService.getAllBudgets();
        assertNotNull(budgets);

        Budget budget1 = budgets.get(0);
        assertEquals(1, budget1.getBudgetId());
        assertEquals(2, budget1.getUserId());
        assertEquals("Gastos mensuales", budget1.getDescription());
        assertEquals(1, budget1.getCurrencyId());
        assertEquals(Timestamp.valueOf("2023-05-01 02:00:00"), budget1.getCreationDate());
    }

    @Test
    void getAllBudgetsByUserId() {
        int userId = 2;
        List<Budget> budgets = budgetService.getAllBudgetsByUserId(userId);
        assertNotNull(budgets);
        assertFalse(budgets.isEmpty());

        for (Budget budget : budgets) {
            assertEquals(userId, budget.getUserId());
        }
    }

    @Test
    void updateBudget() {
        int budgetId = 1;
        Budget budgetToUpdate = new Budget();

        budgetToUpdate.setBudgetId(budgetId);
        budgetToUpdate.setBudgetName("mensualidad");
        budgetToUpdate.setDescription("Gastos mensuales");
        budgetToUpdate.setCurrencyId(1);


        Budget originalBudget = budgetService.getBudgetById(budgetId);
        int originalUserId = originalBudget.getUserId();
        String originalDescription = originalBudget.getDescription();

        boolean updatedBudget = budgetService.updateBudget(budgetToUpdate);

        assertTrue(updatedBudget);
        assertEquals(1, budgetService.getBudgetById(budgetId).getCurrencyId());
        assertEquals("Gastos mensuales", budgetService.getBudgetById(budgetId).getDescription());

        budgetToUpdate.setUserId(originalUserId);
        budgetToUpdate.setDescription(originalDescription);
    }

    @Test
    void createBudget() {
        Budget budgetToCreate = new Budget();
        budgetToCreate.setUserId(1);
        budgetToCreate.setBudgetName("test");
        budgetToCreate.setDescription("test");
        budgetToCreate.setCurrencyId(1);

        boolean createdBudget = budgetService.createBudget(budgetToCreate);

        assertTrue(createdBudget);

        int budgetId = budgetService.getBudgetByName("test").getBudgetId();
        assertEquals(1, budgetService.getBudgetById(budgetId).getUserId());
        assertEquals("test", budgetService.getBudgetById(budgetId).getDescription());

        budgetService.deleteBudget(budgetToCreate);
    }


    @Test
    void deleteBudget() {
        Budget budgetToCreate = new Budget();
        budgetToCreate.setUserId(1);
        budgetToCreate.setBudgetName("test");
        budgetToCreate.setDescription("Presupuesto a eliminar");
        budgetToCreate.setCurrencyId(1);

        boolean createdBudget = budgetService.createBudget(budgetToCreate);
        assertTrue(createdBudget);

        int budgetId =  budgetService.getBudgetByName("test").getBudgetId();

        boolean deletedBudget = budgetService.deleteBudget(budgetService.getBudgetById(budgetId));

        assertTrue(deletedBudget);

    }
}