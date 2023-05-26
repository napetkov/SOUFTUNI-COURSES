import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionMap;

    public int getCount() {
        return this.transactionMap.size();
    }

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            this.transactionMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return transactionMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (contains(id)) {
            Transaction transactionForChange = transactionMap.get(id);
            transactionForChange.setStatus(newStatus);
            transactionMap.put(transactionForChange.getId(), transactionForChange);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void removeTransactionById(int id) {
        if (contains(id)) {
            transactionMap.remove(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Transaction getById(int id) {
        if (contains(id)) {
            return transactionMap.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus() == status) {
                filteredTransactions.add(transaction);
            }
        }
        if (filteredTransactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        return filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        //може да преизползваме гоният метод
        List<Transaction> filteredList = new ArrayList<>();
                getByTransactionStatus(status).forEach(filteredList::add);

        if(filteredList.size()==0){
            throw new IllegalArgumentException();
        }
            return filteredList.stream()
                    .map(Transaction::getSender)
                    .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredList = new ArrayList<>();
        getByTransactionStatus(status).forEach(filteredList::add);

        if(filteredList.size()==0){
            throw new IllegalArgumentException();
        }
        return filteredList.stream()
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionMap.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparingInt(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
