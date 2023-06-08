package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Budget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BudgetManagerImplTest {

    private static final String TABLE_NAME = "BUDGET";
    @InjectMocks
    private BudgetManagerImpl underTest;

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @Test
    void findAll() throws SQLException {
        // Configurar el mock de Connection
        Connection con = Mockito.mock(Connection.class);

        // Configurar el mock de Statement
        Statement stm = Mockito.mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stm);

        // Configurar el mock de ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(stm.executeQuery(Mockito.anyString())).thenReturn(resultSet);

        // Configurar el comportamiento del mock ResultSet
        Mockito.when(resultSet.next()).thenReturn(true,true, false);  // Simular dos filas en el resultado
        Mockito.when(resultSet.getString(Mockito.anyString())).thenReturn("value");  // Simular valores de columna

        // Crear una instancia de la clase bajo prueba
        BudgetManagerImpl budgetManager = new BudgetManagerImpl();

        // Llamar al método bajo prueba
        List<Budget> result = budgetManager.findAll(con);

        // Verificar el resultado
        assertNotNull(result);
        assertEquals(2, result.size());
        // ... verificaciones adicionales

        // Verificar que los métodos del mock se hayan llamado correctamente
        Mockito.verify(con).createStatement();
        Mockito.verify(stm).executeQuery(Mockito.anyString());
        // ... verificaciones adicionales
    }

    @Test
    void findAllBy() throws SQLException {
        // Configurar el mock de Connection
        Connection con = Mockito.mock(Connection.class);

        // Configurar el mock de PreparedStatement
        PreparedStatement stm = Mockito.mock(PreparedStatement.class);
        Mockito.when(con.prepareStatement(Mockito.anyString())).thenReturn(stm);

        // Configurar el mock de ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(stm.executeQuery()).thenReturn(resultSet);

        // Configurar el comportamiento del mock ResultSet
        Mockito.when(resultSet.next()).thenReturn(true, true, false);  // Simular dos filas en el resultado
        Mockito.when(resultSet.getString(Mockito.anyString())).thenReturn("value");  // Simular valores de columna

        // Valores de prueba
        String fieldName = "someField";
        Object value = "someValue";

        // Crear una instancia de la clase bajo prueba
        BudgetManagerImpl budgetManager = new BudgetManagerImpl();

        // Llamar al método bajo prueba
        List<Budget> result = budgetManager.findAllBy(con, fieldName, value);

        // Verificar el resultado
        assertNotNull(result);
        assertEquals(2, result.size());
        // ... verificaciones adicionales

        // Verificar que los métodos del mock se hayan llamado correctamente
        Mockito.verify(con).prepareStatement(Mockito.anyString());
        Mockito.verify(stm).setObject(1, value);
        Mockito.verify(stm).executeQuery();
        // ... verificaciones adicionales
    }


    @Test
    void findBy() throws SQLException {
        // Configurar el mock de Connection
        Connection con = Mockito.mock(Connection.class);

        // Configurar el mock de PreparedStatement
        PreparedStatement stm = Mockito.mock(PreparedStatement.class);
        Mockito.when(con.prepareStatement(Mockito.anyString())).thenReturn(stm);

        // Configurar el mock de ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(stm.executeQuery()).thenReturn(resultSet);

        // Configurar el comportamiento del mock ResultSet
        Mockito.when(resultSet.next()).thenReturn(true, false);  // Simular una fila en el resultado y luego el fin del resultado
        Mockito.when(resultSet.getString(Mockito.anyString())).thenReturn("value");  // Simular valores de columna

        // Valores de prueba
        String fieldName = "someField";
        Object value = "someValue";

        // Crear una instancia de la clase bajo prueba
        BudgetManagerImpl budgetManager = new BudgetManagerImpl();

        // Llamar al método bajo prueba
        Budget result = budgetManager.findBy(con, fieldName, value);

        // Verificar el resultado
        assertNotNull(result);
        // ... verificaciones adicionales

        // Verificar que los métodos del mock se hayan llamado correctamente
        Mockito.verify(con).prepareStatement(Mockito.anyString());
        Mockito.verify(stm).setObject(1, value);
        Mockito.verify(stm).executeQuery();
        Mockito.verify(stm).close();  // Asegurarse de que el PreparedStatement se cierre correctamente
        // ... verificaciones adicionales
    }





    @Test
    void delete() throws SQLException {
        int budgetId = 1;
        Budget budget = new Budget();
        budget.setBudgetId(budgetId);

        // Configurar el mock del PreparedStatement y del Connection para que no devuelvan excepciones
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setInt(Mockito.anyInt(), Mockito.anyInt());
        Mockito.doNothing().when(preparedStatement).executeUpdate();

        // Ejecutar el método a probar
        boolean deleted = underTest.delete(connection,budget);

        // Verificar los resultados
        assertTrue(deleted);
    }

    @Test
    void create() throws SQLException {
        Budget budget = new Budget();
        budget.setBudgetName("Budget 1");

        // Configurar el mock del PreparedStatement y del Connection para que no devuelvan excepciones
        Mockito.when(connection.prepareStatement(Mockito.anyString(), Mockito.eq(Statement.RETURN_GENERATED_KEYS))).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setString(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(preparedStatement).executeUpdate();
        Mockito.when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(resultSet.getInt(1)).thenReturn(1);

        // Ejecutar el método a probar
        boolean createdBudget = underTest.create(connection,budget);

        // Verificar los resultados
        assertTrue(createdBudget);
    }

    @Test
    void update() throws SQLException {
        Budget budget = new Budget();
        budget.setBudgetId(1);
        budget.setBudgetName("Budget 1");

        // Configurar el mock del PreparedStatement y del Connection para que no devuelvan excepciones
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setString(Mockito.anyInt(), Mockito.anyString());
        Mockito.doNothing().when(preparedStatement).setInt(Mockito.anyInt(), Mockito.anyInt());
        Mockito.doNothing().when(preparedStatement).executeUpdate();

        // Ejecutar el método a probar
        boolean updated = underTest.update(connection,budget);

        // Verificar los resultados
        assertTrue(updated);
    }
}