import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock database;
    private Transaction transaction;

    @Before
    public void setup() {
        this.database = new ChainblockImpl();
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Ivan", "Stoqn", 150.90);
    }

    //add
    //1. добавяме транзакция, която я няма
    @Test
    public void testAddCorrectTransaction() {
        assertEquals(0, this.database.getCount());
        this.database.add(transaction);

        assertEquals(1, database.getCount());
        assertTrue(this.database.contains(transaction));
        assertTrue(this.database.contains(transaction.getId()));


    }

    //2. добавяме транзакция, която я има
    @Test
    public void testAddExistingTransaction() {
        assertEquals(0, this.database.getCount());
        this.database.add(transaction);

        assertEquals(1, database.getCount());

        this.database.add(transaction);
        assertEquals(1, database.getCount());
    }

    @Test
    public void testChangeTransactionStatus() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);

        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Transaction expectedTransactionAfterChangeStatus = new TransactionImpl(1, TransactionStatus.ABORTED, "Ivan", "Stoqn", 150.90);
        assertEquals(TransactionStatus.ABORTED, database.getById(1).getStatus());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusInvalidId() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);

        database.changeTransactionStatus(2, TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByIdShouldReturnTransactionWhitThisId() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);

        Transaction expectedTransaction = database.getById(1);
        //може да се провери всяко едно поле за да се знае кое е фейлнало
        assertEquals(expectedTransaction, transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowWhenIdIsIncorrect() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);

        database.getById(3);
    }

    @Test
    public void testRemoveTransactionByIdWithCorrectId() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Gosho", "Stoqn", 120.50);
        database.add(transaction2);
        assertEquals(2, database.getCount());
        database.removeTransactionById(2);
        assertEquals(1, database.getCount());
        assertFalse(database.contains(2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowWhenIdIsIncorrect() {
        assertEquals(0, this.database.getCount());
        database.add(transaction);
        database.removeTransactionById(3);
    }

    @Test
    public void testGetByTransactionStatus() {
        addMultiplyTransactions();

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> returnTransactions = new ArrayList<>();
        result.forEach(returnTransactions::add);

        assertEquals(3, returnTransactions.size());

        returnTransactions.forEach(t -> assertEquals(TransactionStatus.SUCCESSFUL, t.getStatus()));

        for (int i = 1; i < returnTransactions.size(); i++) {
            assertTrue(returnTransactions.get(i - 1).getAmount() >= returnTransactions.get(i).getAmount());
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetByMissingTransactionStatus() {
        addMultiplyTransactions();

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.FAILED);

    }

    @Test
    public void testGetAllSendersWithTransactionStatus() {
        addMultiplyTransactions();

        Iterable<String> result = database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> resultSenders = new ArrayList<>();
        result.forEach(resultSenders::add);

        assertEquals(3, resultSenders.size());
        assertEquals("Dragan",resultSenders.get(0));
        assertEquals("Iva",resultSenders.get(1));
        assertEquals("Gosho",resultSenders.get(2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithMissingTransactionStatus() {
        addMultiplyTransactions();
        database.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatus(){
        addMultiplyTransactions();

        Iterable<String> result = database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> resultSenders = new ArrayList<>();
        result.forEach(resultSenders::add);

        assertEquals(3, resultSenders.size());
        assertEquals("Stoqn",resultSenders.get(0));
        assertEquals("Bobi",resultSenders.get(1));
        assertEquals("Pesho",resultSenders.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithMissingTransactionStatus(){
        addMultiplyTransactions();
        database.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById(){
        addMultiplyTransactions();
        List<Transaction> orderedTransactions = iterableToList(database.getAllOrderedByAmountDescendingThenById());
        assertEquals(database.getCount(),orderedTransactions.size());

        assertEquals(database.getById(1).getAmount(),orderedTransactions.get(0).getAmount(),0.00);
        assertEquals(database.getById(4).getId(),orderedTransactions.get(1).getId(),0.00);
        assertEquals(database.getById(5).getId(),orderedTransactions.get(2).getId(),0.00);
        assertEquals(database.getById(2).getAmount(),orderedTransactions.get(3).getAmount(),0.00);
        assertEquals(database.getById(3).getAmount(),orderedTransactions.get(4).getAmount(),0.00);

    }


    private void addMultiplyTransactions() {
        assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Dragan", "Stoqn", 150.90);//1
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Gosho", "Pesho", 120.50);//4
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Petar", "Eli", 90.00);//5
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Iva", "Bobi", 150.90);//2
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, "Ema", "Bobi", 150.90);//3
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);
        database.add(transaction5);
        assertEquals(5, this.database.getCount());
    }

    private List<Transaction> iterableToList(Iterable<Transaction> orderedTransactions) {
        List<Transaction> list = new ArrayList<>();
        orderedTransactions.forEach(tr-> list.add(tr));

        return list;
    }

}