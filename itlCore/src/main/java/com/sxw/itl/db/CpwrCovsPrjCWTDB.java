/**
 * 
 */
package com.sxw.itl.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.validator.GenericValidator;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class CpwrCovsPrjCWTDB {

    private static final CpwrCovsPrjCWTDB instance = new CpwrCovsPrjCWTDB();

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            instance.updateCodeForV411();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCodeForV411() throws Exception {
        // DELETE data

        // INSERT data
        this.insertDataFromCSVfile();

        // QUERY data
    }

    private String cvsSplitBy = "\t";

    private void insertDataFromCSVfile() throws Exception {
        String csvFile = "D:\\ws\\CWT\\doc\\v411\\KDSLocationCodes20140320.csv";
        BufferedReader br = null;
        String line = "";

        try {
            // READ data
            br = new BufferedReader(new FileReader(csvFile));
            int i = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(i + ":" + line);
                String[] sqlArr = this.generateInsertSQL(line);
                this.updateDBforCWTPortal(sqlArr);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final void updateDBforCWTPortal(final String[] sqlArr) {
        Connection con = null;
        Statement stmt = null;

        try {
            con = BasicJDBCNoFramework.getInstance().getCWTPortalDBConnection();
            stmt = con.createStatement();

            if (!GenericValidator.isBlankOrNull(sqlArr[0])) {
                System.out.println("AIR_CODES:" + sqlArr[0]);
                stmt.executeUpdate(sqlArr[0]);
            }

            if (!GenericValidator.isBlankOrNull(sqlArr[1])) {
                System.out.println("HOTEL_CODES:" + sqlArr[1]);
                stmt.executeUpdate(sqlArr[1]);
            }

            if (!GenericValidator.isBlankOrNull(sqlArr[2])) {
                System.out.println("CAR_CODES:" + sqlArr[2]);
                stmt.executeUpdate(sqlArr[2]);
            }

            if (!GenericValidator.isBlankOrNull(sqlArr[3])) {
                System.out.println("RAIL_CODES:" + sqlArr[3]);
                stmt.executeUpdate(sqlArr[3]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }

    private final String[] generateInsertSQL(final String line) throws Exception {
        String[] sqlArr = new String[4];
        String[] code = line.split(cvsSplitBy);
        if (code != null) {
            if ("Y".equalsIgnoreCase(code[5])) {
                // Air
                StringBuffer sql = new StringBuffer("INSERT INTO AIR_CODES VALUES(");
                sql.append("'").append(code[0]).append("',");
                sql.append("'").append(code[1]).append("',");
                sql.append("'").append(code[2]).append("',");
                sql.append("'").append(code[3]).append("',");
                sql.append("'").append(code[4].toUpperCase()).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(value.toString());
                sql.append("')");
                sqlArr[0] = sql.toString();
            } else {
                sqlArr[0] = "";
            }

            if ("Y".equalsIgnoreCase(code[6])) {
                // HOTEL
                StringBuffer sql = new StringBuffer("INSERT INTO HOTEL_CODES VALUES(");
                sql.append("'").append(code[0]).append("',");
                sql.append("'").append(code[1]).append("',");
                sql.append("'").append(code[2]).append("',");
                sql.append("'").append(code[3]).append("',");
                sql.append("'").append(code[4].toUpperCase()).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(value.toString());
                sql.append("')");
                sqlArr[1] = sql.toString();
            } else {
                sqlArr[1] = "";
            }

            if ("Y".equalsIgnoreCase(code[7])) {
                // HOTEL
                StringBuffer sql = new StringBuffer("INSERT INTO CAR_CODES VALUES(");
                sql.append("'").append(code[0]).append("',");
                sql.append("'").append(code[1]).append("',");
                sql.append("'").append(code[2]).append("',");
                sql.append("'").append(code[3]).append("',");
                sql.append("'").append(code[4].toUpperCase()).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(value.toString());
                sql.append("')");
                sqlArr[2] = sql.toString();
            } else {
                sqlArr[2] = "";
            }

            if ("Y".equalsIgnoreCase(code[8])) {
                // HOTEL
                StringBuffer sql = new StringBuffer("INSERT INTO RAIL_CODES VALUES(");
                sql.append("'").append(code[0]).append("',");
                sql.append("'").append(code[1]).append("',");
                sql.append("'").append(code[2]).append("',");
                sql.append("'").append(code[3]).append("',");
                sql.append("'").append(code[4].toUpperCase()).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(value.toString());
                sql.append("')");
                sqlArr[3] = sql.toString();
            } else {
                sqlArr[3] = "";
            }
        }
        return sqlArr;
    }

    private Map<String, String> countryMap = new HashMap<String, String>();

    private String getCountryName(final String A2) throws Exception {
        if (countryMap.size() < 1) {
            initCountryMap();
            System.out.println("size of countryMap is " + countryMap.size());
        }
        return countryMap.get(A2);
    }

    private final void initCountryMap() throws Exception {
        Connection con = BasicJDBCNoFramework.getInstance().getCWTPortalDBConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT A2,NAME FROM COUNTRY");

        while (rs.next()) {
            String code = rs.getString("A2");
            String value = rs.getString("NAME");
            countryMap.put(code, value);
        }
        if (con != null)
            con.close();
        if (stmt != null)
            stmt.close();
        if (rs != null)
            rs.close();
    }
}
