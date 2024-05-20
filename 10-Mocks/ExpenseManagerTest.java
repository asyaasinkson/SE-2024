package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    public void testCalculateTotalAmount() {
        ExpenseRepository mockRepository = mock(ExpenseRepository.class);
        FancyService mockService = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(mockRepository, mockService);

        List<Expense> expenses = Arrays.asList(
            new Expense(100),
            new Expense(200),
            new Expense(300)
        );

        when(mockRepository.getExpenses()).thenReturn(expenses);

        assertEquals(600, manager.calculateTotal());
    }

    @Test
    public void testCalculateTotalByCategory() {
        ExpenseRepository mockRepository = mock(ExpenseRepository.class);
        FancyService mockService = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(mockRepository, mockService);

        List<Expense> homeExpenses = Arrays.asList(
            new Expense(100, "Home"),
            new Expense(200, "Home")
        );
        List<Expense> carExpenses = Arrays.asList(
            new Expense(300, "Car"),
            new Expense(400, "Car")
        );

        when(mockRepository.getExpensesByCategory("Home")).thenReturn(homeExpenses);
        when(mockRepository.getExpensesByCategory("Car")).thenReturn(carExpenses);

        assertEquals(300, manager.calculateTotalForCategory("Home"));
        assertEquals(700, manager.calculateTotalForCategory("Car"));
        assertEquals(0, manager.calculateTotalForCategory("Food"));
        assertEquals(0, manager.calculateTotalForCategory("Sport"));
    }

    @Test
    public void testCalculateTotalInUsd() throws ConnectException {
        ExpenseRepository mockRepository = mock(ExpenseRepository.class);
        FancyService mockService = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(mockRepository, mockService);

        List<Expense> expenses = Arrays.asList(
            new Expense(100),
            new Expense(200),
            new Expense(300)
        );

        when(mockRepository.getExpenses()).thenReturn(expenses);
        when(mockService.convert(anyDouble(), eq("PLN"), eq("USD")))
            .thenAnswer(invocation -> {
                double amount = invocation.getArgument(0);
                return amount / 4;
            });

        assertEquals(150, manager.calculateTotalInDollars());
    }
}

