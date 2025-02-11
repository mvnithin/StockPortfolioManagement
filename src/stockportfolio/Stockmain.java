package stockportfolio;

import java.sql.SQLException;
import java.util.Scanner;

public class Stockmain {
    private static StockDAO stockdao=new StockDAO();
    private static StockService stockservice = new StockService();
    private static Scanner myobj=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

        while (true){
            System.out.println("----- Stock Portfolio Manager -----");
            System.out.println("1. Add Stock");
            System.out.println("2. View Portfolio");
            System.out.println("3. Update Stock Holdings");
            System.out.println("4. Delete Stock");
            //System.out.println("5. Check Live Stock Price");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch=myobj.nextInt();
            switch (ch){
                case 1:
                    addStock();
                    break;
                case 2:
                    stockservice.displayPortfolio();
                    break;
                case 3:
                    updateStock();
                    break;
                case 4:
                    deleteStock();
                    break;
                case 5:
                    System.out.println(" Exiting... Thank you!");
                    return;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        }
    }
    private static void addStock() throws SQLException {
        System.out.println("Enter Stock Name: ");
        String name = myobj.next();
        System.out.println("Enter Symbol: ");
        String symbol = myobj.next();
        System.out.println("Enter Quantity: ");
        int quantity = myobj.nextInt();
        System.out.println("Enter Buy Price: ");
        double price = myobj.nextDouble();
       // myobj.nextLine();
        System.out.println("Enter Buy Date (YYYY-MM-DD): ");
        String date = myobj.next();
        stockdao.addstock(name,symbol,quantity,price,date);
    }
    private static void updateStock() throws SQLException {
        System.out.println("Enter Stock ID to update: ");
        int id = myobj.nextInt();
        System.out.print("Enter New Quantity: ");
        int newQuantity = myobj.nextInt();
        stockdao.updatestock(id,newQuantity);
    }
    private static void deleteStock() throws SQLException {
        System.out.print("Enter Stock ID to delete: ");
        int id = myobj.nextInt();
        stockdao.deletestock(id);
    }
}
