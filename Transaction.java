import java.time.LocalDateTime;

public class Transaction {
    private String company;
    private int price;
    private int quantity;
    private String type;
    private LocalDateTime date;
    public Transaction(String company, int price, int quantity, String type) {
        this.company = company;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.date = LocalDateTime.now();
    }
    public void display() {
        System.out.println("----------------------");
        System.out.println("Type: " + type);
        System.out.println("Company: " + company);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: $" + (price * quantity));
        System.out.println("Date: " + date);
        System.out.println("----------------------");

    }
}
