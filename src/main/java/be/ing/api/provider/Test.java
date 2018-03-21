package be.ing.api.provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    



        public static void main(String[] args) {
            Connection conn = null;

            try {
                String userName = "vivek";
                String password = "Trojans";

                String url = "jdbc:mysql://10.1.30.101:3306/shophopper?useSSL=false";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, userName, password);
                System.out.println("Database connection established");
            } catch (Exception e) {
                System.err.println("Cannot connect to database server");
                System.err.println(e.getMessage());
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                        System.out.println("Database Connection Terminated");
                    } catch (Exception e) {}
                }
            }
        }

}
