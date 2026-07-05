import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        User user = new User("Rohan", 10000);
        boolean running = true;
        while (running) {
            System.out.println("\n====== STOCK MARKET ======");
            System.out.println("1. Show Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. Show Portfolio");
            System.out.println("5. Show Transactions");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    market.showStocks();
                    break;
                case 2:
                    System.out.print("Company: ");
                    String buyCompany = sc.next();
                    Stock buyStock = market.findStock(buyCompany);
                    if (buyStock != null) {
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        user.buyStock(buyStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    System.out.print("Company: ");
                    String sellCompany = sc.next();
                    Stock sellStock = market.findStock(sellCompany);
                    if (sellStock != null) {
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        user.sellStock(sellStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 4:
                    user.showPortfolio();
                    break;
                case 5:
                    user.showTransactions();
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}