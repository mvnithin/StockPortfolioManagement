package stockportfolio;

public class Stock {
    private int id;
    private String name;
    private String symbol;
    private int quantity;
    private double buyprice;
    private double liveprice;
    private String buydate;
    Stock(int id,String name,String symbol,int quantity,double buyprice,String buydate){
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.quantity=quantity;
        this.buyprice=buyprice;
        this.buydate=buydate;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSymbol(){
        return symbol;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getBuyprice(){
        return buyprice;
    }
    public String getBuydate(){
        return buydate;
    }
    public double getLiveprice(){
        return liveprice;
    }

    public void setLiveprice(double liveprice){
        this.liveprice=liveprice;
    }

    @Override
    public String toString() {
        return String.format("Stock[ID=%d, Name=%s, Symbol=%s, Quantity=%d, Buy Price=%.2f, Live Price=%.2f ,Buy Date=%s]",
                id, name, symbol, quantity, buyprice,liveprice, buydate);
    }
}
