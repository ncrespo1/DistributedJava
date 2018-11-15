import java.sql.*;

public class FruitDB {

    public FruitDB() {

        try {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:FruitDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Fruit table.
            buildFruitTable(conn);

            // Build the Cart table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e) {
            System.out.println("Error Creating the Fruit Table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Fruit");
                System.out.println("Fruit table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void buildFruitTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Fruit (" +
                    "ProdName CHAR(25), " +
                    "ProdNum INT NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            stmt.execute("INSERT INTO Fruit VALUES ( " +
                    "'Apple', " +
                    "1, " +
                    "8.95 )");

            stmt.execute("INSERT INTO Fruit VALUES ( " +
                    "'Orange', " +
                    "2, " +
                    "5.95 )");

            stmt.execute("INSERT INTO Fruit VALUES ( " +
                    "'Pear', " +
                    "3, " +
                    "4.95 )");

            stmt.execute("INSERT INTO Fruit VALUES ( " +
                    "'Peach', " +
                    "4, " +
                    "6.95 )");

            stmt.execute("INSERT INTO Fruit VALUES ( " +
                    "'Plum', " +
                    "5, " +
                    "9.95 )");

            System.out.println("Fruit table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart" +
                    "( ItemNum INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "  ProdNum INT," +
                    "  Price DOUBLE," +
                    "CONSTRAINT fruit_fk FOREIGN KEY (ProdNum) REFERENCES Fruit(ProdNum))");

            // Add some rows to the new table.

            System.out.println("Cart table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void outputDB() {
        final String DB_URL = "jdbc:derby:FruitDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, ProdName, Price FROM Fruit";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("==============Fruit===========================");
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ProdNum");
                double price = rs.getDouble("Price");
                String name = rs.getString("ProdName");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Price: " + price);
                System.out.println(", Name: " + name);
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
