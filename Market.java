import java.util.ArrayList;

public class Market {
    private ArrayList<Stock> stocks;
    public Market() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("Apple", 700));
        stocks.add(new Stock("Google", 500));
        stocks.add(new Stock("IBM", 1000));
        stocks.add(new Stock("Meta", 900));
        stocks.add(new Stock("MSFT", 300));
        stocks.add(new Stock("Tesla", 1000));
        stocks.add(new Stock("Nvidia", 5000));
        stocks.add(new Stock("Adobe", 2000));
        stocks.add(new Stock("Tata", 3000));
        stocks.add(new Stock("Reliance", 800));
    }
    public void showStocks(){
        for(Stock stock : stocks){
            stock.display();
        }
    }
    public Stock findStock(String company) {
        for (Stock stock : stocks) {
            if (stock.getCompany().equalsIgnoreCase(company)) {
                return stock;
            }
        }
        return null;
    }
}