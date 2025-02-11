package stockportfolio;

import java.sql.SQLException;
import java.util.List;

public class StockService {
    StockDAO stockdao=new StockDAO();
    public void displayPortfolio() throws SQLException {
        List<Stock> stocks=stockdao.getallstocks();
        if(stocks.isEmpty()){
            System.out.println("No Stocks in Portfolio");
            return;
        }
        System.out.println("---------YOUR PORTFOLIO---------");
        for(Stock stock:stocks){
            double liveprice=Stockapi.getLiveStockPrice(stock.getSymbol());
            stock.setLiveprice(liveprice);
            System.out.println(stock);
        }
    }
}
