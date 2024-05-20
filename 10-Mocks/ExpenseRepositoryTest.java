package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void shouldLoadExpensesCorrectly() {
        IFancyDatabase actualDatabase = new MyDatabase();
        ExpenseRepository repo = new ExpenseRepository(actualDatabase);
        repo.loadExpenses();

        assertTrue(repo.getExpenses().isEmpty());

        IFancyDatabase mockedDatabase = mock(FancyDatabase.class);
        when(mockedDatabase.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository repoWithMock = new ExpenseRepository(mockedDatabase);
        repoWithMock.loadExpenses();

        InOrder inOrder = inOrder(mockedDatabase);
        inOrder.verify(mockedDatabase).connect();
        inOrder.verify(mockedDatabase).queryAll();
        inOrder.verify(mockedDatabase).close();

        assertTrue(repoWithMock.getExpenses().isEmpty());
    }

    @Test
    void shouldSaveExpensesProperly() {
        IFancyDatabase mockedDatabase = mock(FancyDatabase.class);
        ExpenseRepository repoWithMock = new ExpenseRepository(mockedDatabase);

        Expense exp1 = new Expense();
        Expense exp2 = new Expense();
        Expense exp3 = new Expense();
        Expense exp4 = new Expense();
        Expense exp5 = new Expense();

        repoWithMock.addExpense(exp1);
        repoWithMock.addExpense(exp2);
        repoWithMock.addExpense(exp3);
        repoWithMock.addExpense(exp4);
        repoWithMock.addExpense(exp5);
        repoWithMock.saveExpenses();

        InOrder inOrder = inOrder(mockedDatabase);
        inOrder.verify(mockedDatabase).connect();
        inOrder.verify(mockedDatabase, times(5)).persist(any(Expense.class));
        inOrder.verify(mockedDatabase).close();
    }
}

