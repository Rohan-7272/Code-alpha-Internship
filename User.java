import java.util.HashMap;
import java.util.ArrayList;
public class User {
    private String name;
    private double balance;
    private HashMap<String,Integer> portfolio;
    private ArrayList<Transaction> transactions;
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        portfolio = new HashMap<>();
        transactions = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public void showPortfolio(){
        System.out.println("\nPortfolio:");
        if(portfolio.isEmpty()){
            System.out.println("No Stocks owned");
            return;
        }
        for(String company : portfolio.keySet()){
            System.out.println(company + " : " + portfolio.get(company) + "shares");
        }
        System.out.println("Balance: $" + balance);
    }
    public void buyStock(Stock stock, int quantity) {
        Transaction transaction = new Transaction(
                stock.getCompany(),
                stock.getPrice(),
                quantity,
                "BUY");
        transactions.add(transaction);
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(
                    stock.getCompany(),
                    portfolio.getOrDefault(stock.getCompany(), 0) + quantity
            );
            System.out.println("Purchased successfully!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void sellStock(Stock stock, int quantity) {
        Transaction transaction = new Transaction(
                stock.getCompany(),
                stock.getPrice(),
                quantity,
                "SELL"
        );
        transactions.add(transaction);
        String company = stock.getCompany();
        if (!portfolio.containsKey(company)) {
            System.out.println("You don't own this stock.");
            return;
        }
        int owned = portfolio.get(company);
        if (owned < quantity) {
            System.out.println("Not enough shares.");
            return;
        }
        balance += stock.getPrice() * quantity;
        if (owned == quantity) {
            portfolio.remove(company);
        } else {
            portfolio.put(company, owned - quantity);
        }
        System.out.println("Sold successfully!");
    }
    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction transaction : transactions) {
            transaction.display();
        }
    }
}
