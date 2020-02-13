package Utils;

import java.sql.*;

public class dbConnection {
    Connection conn = null;

    // Object of Statement. It is used to create a Statement to execute the query
    Statement stmt = null;

    //Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
    ResultSet resultSet = null;
    protected static String Data1, Data2, Data3, uri;
    protected static String dbUrl = "jdbc:postgresql://10.16.1.51:5432/aosweb";
    protected static String dbUrl1 = "jdbc:postgresql://10.16.1.51:5432/aosdb";

    public void SetUpConnection(String Query, int i, int j, int dburi) throws SQLException, ClassNotFoundException {
        try {
            // Register JDBC driver (JDBC driver name and Database URL)
            Class.forName("org.postgresql.Driver");

            if (dburi==1) {
                 uri = dbUrl;
            }if (dburi==0){
                 uri = dbUrl1;
            }
            //Database Username
            String username = "postgres";

            //Database Password
            String password = "4lt0@1234";

            //Create Connection to DB
            Connection con = DriverManager.getConnection(uri, username, password);

            //Create Statement Object
            Statement stmt = con.createStatement();

            // Execute the SQL Query. Store results in ResultSet
            ResultSet rs = stmt.executeQuery(Query);

            // While Loop to iterate through all data and print results
            while (rs.next()) {
                Data1 = rs.getString(i);
                Data2 = rs.getString(j);
                System.out.println(Data1 + "  " + Data2);

                con.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public void AssertDBNull(String Query, int dburi) throws SQLException, ClassNotFoundException {
        try {
            // Register JDBC driver (JDBC driver name and Database URL)
            Class.forName("org.postgresql.Driver");

            if (dburi==1) {
                uri = dbUrl;
            }else {
                uri = dbUrl1;
            }

            //Database Username
            String username = "postgres";

            //Database Password
            String password = "4lt0@1234";

            //Create Connection to DB
            Connection con = DriverManager.getConnection(uri, username, password);

            //Create Statement Object
            Statement stmt = con.createStatement();

            // Execute the SQL Query. Store results in ResultSet
            ResultSet rs = stmt.executeQuery(Query);

            // While Loop to iterate through all data and print results
            while (rs.next()) {
                Data3 = rs.getString(1);
                System.out.println(Data3);
                con.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

}