package model;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/board_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ID = "ssafy";
    private static final String PASSWORD = "ssafy";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(URL, ID, PASSWORD);
    }

    public static void close(AutoCloseable... closeable) {
        try {
            for (AutoCloseable ac : closeable) {
                if (ac != null) {
                    ac.close();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
