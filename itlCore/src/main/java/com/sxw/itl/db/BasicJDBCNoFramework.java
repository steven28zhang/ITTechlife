/**
 * 
 */
package com.sxw.itl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class BasicJDBCNoFramework {

    private final static BasicJDBCNoFramework instance = new BasicJDBCNoFramework();

    public static BasicJDBCNoFramework getInstance() {
        return instance;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        instance.cwtPortalDBJDBC();

    }

    /**
     * jdbc.default.driverClassName=oracle.jdbc.driver.OracleDriver <br>
     * jdbc.default.url=jdbc:oracle:thin:@127.0.0.1:1623:prtstg <br>
     * jdbc.default.username=cwtprtqa <br>
     * jdbc.default.password=cwtprtqa$123 <br>
     */

    private String driverClassName = "oracle.jdbc.driver.OracleDriver";
    private String jdbcURL = "jdbc:oracle:thin:@localhost:21623:pttrvqa";
    private String username = "cwtprtqa";
    private String password = "cwtprtqa$123";

    private void cwtPortalDBJDBC() {
        try {
            Connection con = this.getCWTPortalDBConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CODE,VALUE FROM AIR_CODES WHERE  CITYNAME LIKE '%DET%'");

            while (rs.next()) {
                String code = rs.getString("CODE");
                String value = rs.getString("VALUE");
                System.out.println("CODE:" + code + ":VALUE:" + value);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Connection getCWTPortalDBConnection() throws Exception {
        Class.forName(driverClassName);
        return DriverManager.getConnection(jdbcURL, username, password);
    }
}
