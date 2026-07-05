public class Stock {
    private String company;
    private int price;
    public Stock(String company, int price) {
        this.company = company;
        this.price = price;
    }
    public String getCompany() {
        return company;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void display() {
        System.out.println(company + " : $" + price);
    }
}