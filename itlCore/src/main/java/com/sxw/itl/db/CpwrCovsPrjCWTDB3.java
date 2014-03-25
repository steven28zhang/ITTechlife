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
import org.apache.log4j.Logger;

import com.sxw.itl.utils.string.EscapeChars;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class CpwrCovsPrjCWTDB3 {

    private static final String CLASSNAME = CpwrCovsPrjCWTDB3.class.getName();
    private static final Logger logger = Logger.getLogger(CpwrCovsPrjCWTDB3.class);
    private static final CpwrCovsPrjCWTDB3 instance = new CpwrCovsPrjCWTDB3();

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            instance.updateCodeForV411();
        } catch (Exception e) {
            logger.error(e);
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
        String methodName = CLASSNAME + ":insertDataFromCSVfile:";
        String csvFile = "D:\\ws\\CWT\\doc\\v411\\KDSLocationCodes20140320.csv";
        BufferedReader br = null;
        String line = "";
        Connection con = null;
        try {
            // READ data
            br = new BufferedReader(new FileReader(csvFile));
            int i = 1;
            con = BasicJDBCNoFramework.getInstance().getCWTPortalDBConnection();
            while ((line = br.readLine()) != null) {
                if (i >= 20000) {
                    long start = System.currentTimeMillis();
                    logger.debug(methodName + i + ":" + line);
                    String[] sqlArr = this.generateInsertSQL(line);
                    long p1 = System.currentTimeMillis() - start;
                    logger.debug(methodName + "p1:" + p1);
                    this.updateDBforCWTPortal(con, sqlArr);
                    long p2 = System.currentTimeMillis() - start - p1;
                    logger.debug(methodName + "p2:" + p2);
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            logger.error(methodName, e);
        } catch (IOException e) {
            logger.error(methodName, e);
        } catch (Exception e) {
            logger.error(methodName, e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(methodName, e);
                }
            }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    logger.error(methodName, e);
                }
        }
    }

    private final void updateDBforCWTPortal(Connection con, final String[] sqlArr) {
        String methodName = CLASSNAME + ":updateDBforCWTPortal:";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            // if (!GenericValidator.isBlankOrNull(sqlArr[0])) {
            // logger.debug(methodName + "AIR_CODES:" + sqlArr[0]);
            // stmt.executeUpdate(sqlArr[0]);
            // }

            // if (!GenericValidator.isBlankOrNull(sqlArr[1])) {
            // logger.debug(methodName + "HOTEL_CODES:" + sqlArr[1]);
            // stmt.executeUpdate(sqlArr[1]);
            // }
            if (!GenericValidator.isBlankOrNull(sqlArr[2])) {
                logger.debug(methodName + "CAR_CODES:" + sqlArr[2]);
                stmt.executeUpdate(sqlArr[2]);
            }
            //
            // if (!GenericValidator.isBlankOrNull(sqlArr[3])) {
            // logger.debug(methodName + "RAIL_CODES:" + sqlArr[3]);
            // stmt.executeUpdate(sqlArr[3]);
            // }

        } catch (Exception e) {
            logger.error(methodName, e);
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error(methodName, e);
                }

        }

    }

    private final String[] generateInsertSQL(final String line) throws Exception {
        String[] sqlArr = new String[4];
        String[] code = line.split(cvsSplitBy);
        if (code != null && code.length == 9) {
            if ("Y".equalsIgnoreCase(code[5])) {
                // Air
                StringBuffer sql = new StringBuffer(
                        "INSERT INTO AIR_CODES (code,country,state,city,cityname,value) VALUES(");
                sql.append("'").append(EscapeChars.forOracleSQL(code[0])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[1])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[2])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[3])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[4].toUpperCase())).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(EscapeChars.forOracleSQL(value.toString()));
                sql.append("')");
                sqlArr[0] = sql.toString();
            } else {
                sqlArr[0] = "";
            }
            sqlArr[1] = "";
            sqlArr[2] = "";
            sqlArr[3] = "";

            if ("Y".equalsIgnoreCase(code[6])) {
                // HOTEL
                StringBuffer sql = new StringBuffer(
                        "INSERT INTO HOTEL_CODES (code,country,state,city,cityname,value)  VALUES(");
                sql.append("'").append(EscapeChars.forOracleSQL(code[0])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[1])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[2])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[3])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[4].toUpperCase())).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(EscapeChars.forOracleSQL(value.toString()));
                sql.append("')");
                sqlArr[1] = sql.toString();
            } else {
                sqlArr[1] = "";
            }

            if ("Y".equalsIgnoreCase(code[7])) {
                // HOTEL
                StringBuffer sql = new StringBuffer(
                        "INSERT INTO CAR_CODES  (code,country,state,city,cityname,value) VALUES(");
                sql.append("'").append(EscapeChars.forOracleSQL(code[0])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[1])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[2])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[3])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[4].toUpperCase())).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(EscapeChars.forOracleSQL(value.toString()));
                sql.append("')");
                sqlArr[2] = sql.toString();
            } else {
                sqlArr[2] = "";
            }

            if ("Y".equalsIgnoreCase(code[8])) {
                // HOTEL
                StringBuffer sql = new StringBuffer(
                        "INSERT INTO RAIL_CODES  (code,country,state,city,cityname,value) VALUES(");
                sql.append("'").append(EscapeChars.forOracleSQL(code[0])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[1])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[2])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[3])).append("',");
                sql.append("'").append(EscapeChars.forOracleSQL(code[4].toUpperCase())).append("','");
                StringBuffer value = new StringBuffer(code[4]);
                if (!GenericValidator.isBlankOrNull(code[2])) {
                    value.append(", ").append(code[2]);
                }
                if (!GenericValidator.isBlankOrNull(code[1])) {
                    value.append(", ").append(this.getCountryName(code[1]));
                }
                value.append(" (").append(code[0]).append(")");
                sql.append(EscapeChars.forOracleSQL(value.toString()));
                sql.append("')");
                sqlArr[3] = sql.toString();
            } else {
                sqlArr[3] = "";
            }
        } else {
            logger.error("Exception when insert this row into DB: " + line);
        }
        return sqlArr;
    }

    private static Map<String, String> countryMap = new HashMap<String, String>();

    private String getCountryName(final String A2) throws Exception {
        String methodName = CLASSNAME + ":getCountryName:";
        // long start = System.currentTimeMillis();
        if (countryMap.size() < 1) {
            initCountryMap();
            logger.debug(methodName + "size of countryMap is " + countryMap.size());
        }
        // long p3 = System.currentTimeMillis() - start;
        // logger.debug(methodName + "p3:" + p3);
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
