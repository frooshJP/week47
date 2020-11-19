import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");  // implementerer sql driver
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Mangojuice1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Creating the Statement object
        Statement stmt = con.createStatement();
        //Query to get the number of rows in a table
        String query = "select count(*) from city";
        //Executing the query
        ResultSet rs = stmt.executeQuery(query);
        //Retrieving the result
        rs.next();
        int count = rs.getInt(1);
        System.out.println("Number of records in the cities table: "+count);

        //Creating the Statement object
        Statement stmt2 = con.createStatement();
        //Query to get the number of rows in a table
        String query2 = "select count(*) from city WHERE population >= 5000000";
        //Executing the query
        ResultSet rs2 = stmt.executeQuery(query2);
        //Retrieving the result
        rs2.next();
        int count2 = rs2.getInt(1);
        System.out.println("Number of cities with more than 5 mil ppl: "+count2);

        //Creating the Statement object
        Statement stmt3 = con.createStatement();
        //Query to get the number of rows in a table
        String query3 = "select city.name, city.population from city WHERE population >= 5000000";
         //Executing the query
        ResultSet rs3 = stmt.executeQuery(query3);
        //Retrieving the result
        System.out.println("Cities with more than 5 mil ppl:");
        while(rs3.next()) {
            System.out.print("Name of the city: "+rs3.getString("Name")+", "+rs3.getInt("Population"));
            System.out.println("");
        }

        ArrayList<String> cities = new ArrayList<>();
        while(rs3.next()) {
            cities.add(rs3.getString("Name")+", "+rs3.getInt("Population"));
        }
        //It's important to close the statement when you are done with it
        stmt.close();

    }


    }
