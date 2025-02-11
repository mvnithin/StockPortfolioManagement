package stockportfolio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
    public void addstock(String name,String symbol,int quantity,double buyprice,String buydate) throws SQLException {
        Connection con=DBconnection.getconnection();
        String query="INSERT INTO stocks (stock_name,symbol,quantity,buy_price,buy_date) VALUES (?,?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1,name);
        pstm.setString(2,symbol);
        pstm.setInt(3,quantity);
        pstm.setDouble(4,buyprice);
        pstm.setDate(5,Date.valueOf(buydate));
        pstm.executeUpdate();
        System.out.println("Stock Added Successfully!");
    }
    public void updatestock(int id,int newQuantity) throws SQLException {
        Connection con=DBconnection.getconnection();
        String query="UPDATE stocks SET quantity=? WHERE id=?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setInt(1,newQuantity);
        pstm.setInt(2,id);
        int row=pstm.executeUpdate();
        System.out.println(row>0?"Stock Updated Successfully":"No Stock found");
    }
    public void deletestock(int id) throws SQLException {
        Connection con=DBconnection.getconnection();
        String query="DELETE FROM stocks WHERE id=?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setInt(1,id);
        int row=pstm.executeUpdate();
        System.out.println(row>0?"Stock deleted Successfully":"Stock not found");
    }
    public List<Stock> getallstocks() throws SQLException {
        Connection con=DBconnection.getconnection();
        List<Stock> stocks=new ArrayList<>();
        String query="SELECT * FROM stocks";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        while (rs.next()){
            stocks.add(new Stock(rs.getInt("id"),rs.getString("stock_name"),rs.getString("symbol"),rs.getInt("quantity"),rs.getDouble("buy_price"),rs.getDate("buy_date").toString()));
        }
        return stocks;
    }
}
