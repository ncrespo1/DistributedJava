import java.sql.*;
import java.util.Scanner;

public class ShoppingCart {
    Scanner keyboard = new Scanner(System.in);
    public ShoppingCart() {

    }

    public void Menu() {
        final String DB_URL = "jdbc:derby:FruitDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            String input;
            do {
                FruitDB.outputDB();
                System.out.println("Please Select from the following menu:\n" +
                        "1) Add item to cart\n" +
                        "2) Remove Item from cart\n" +
                        "3) View Cart\n" +
                        "4) Exit Application\n");

                input = keyboard.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Enter the Product Number you would like to add");
                        String input2 = keyboard.nextLine();

                        switch (input2) {
                            case "1": {
                                stmt = conn.createStatement();
                                String sql = "INSERT INTO Cart(ProdNum, Price) " +
                                        "VALUES (1,  8.95)";
                                stmt.executeUpdate(sql);
                                stmt.close();
                                System.out.println("Item added to cart!");
                                break;
                            }
                            case "2": {
                                stmt = conn.createStatement();
                                String sql = "INSERT INTO Cart(ProdNum, Price) " +
                                        "VALUES (2,  5.95)";
                                stmt.executeUpdate(sql);
                                stmt.close();
                                System.out.println("Item added to cart!");
                                break;
                            }
                            case "3": {
                                stmt = conn.createStatement();
                                String sql = "INSERT INTO Cart(ProdNum, Price) " +
                                        "VALUES (3,  8.95)";
                                stmt.executeUpdate(sql);
                                stmt.close();
                                System.out.println("Item added to cart!");
                                break;
                            }
                            case "4": {
                                stmt = conn.createStatement();
                                String sql = "INSERT INTO Cart(ProdNum, Price) " +
                                        "VALUES (4,  6.95)";
                                stmt.executeUpdate(sql);
                                stmt.close();
                                System.out.println("Item added to cart!");
                                break;
                            }
                            case "5": {
                                stmt = conn.createStatement();
                                String sql = "INSERT INTO Cart(ProdNum, Price) " +
                                        "VALUES (5,  9.95)";
                                stmt.executeUpdate(sql);
                                stmt.close();
                                System.out.println("Item added to cart!");
                                break;
                            }
                            default:
                                System.out.println("Invalid Number");
                                break;
                        }
                        break;
                    case "2":
                        outputCart();
                        System.out.println("Enter the item number you wish to remove:");
                        String input3 = keyboard.nextLine();
                        stmt = conn.createStatement();
                        String sql = "DELETE FROM Cart WHERE ItemNum = " + input3;
                        stmt.executeUpdate(sql);
                        stmt.close();
                        break;
                    case "3":
                        outputCart();
                        break;
                    case "4":
                        conn.close();
                        System.exit(0);
                        break;
                }
            } while (!input.equals("4"));
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public void outputCart() {
        final String DB_URL = "jdbc:derby:FruitDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Cart.ItemNum, Fruit.ProdName, Cart.Price " +
                    "FROM Cart JOIN Fruit ON " +
                    "Cart.ProdNum = Fruit.ProdNum";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("===================Cart=======================");
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ItemNum");
                String name = rs.getString("ProdName");
                double price = rs.getDouble("Price");


                //Display values
                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
            }
            System.out.println("==============================================");
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}