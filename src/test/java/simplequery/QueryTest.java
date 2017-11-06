package simplequery;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.*;
import java.sql.*;

/**
 * Unit test for simple App.
 */
 public class QueryTest extends TestCase
 {
	protected static Logger log = Logger.getLogger(QueryTest.class);
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
   public void testConnection()
   {
     Connection conn = null;
     String connectionUrl = "jdbc:mysql://localhost:3306/sakila-db";
     String connectionUser = "root";
     String connectionPassword = "root";

     System.out.println("Connecting to the database sakila-db...");

     try {
       conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
       System.out.println("Database connected!");
     }
     catch (SQLException e){
       throw new IllegalStateException("Cannot connect to the database!", e);
     }
   }
   
   public void testDriver()
   {
     try {
       Class.forName("com.mysql.jdbc.Driver");
       System.out.println("Driver loaded!");
     } catch (ClassNotFoundException e) {
       throw new IllegalStateException("Cannot find the driver in the classpath", e);
     }

   }
 }
