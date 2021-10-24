package ConnectDB;

import java.sql.*;

public class ConnectDB {
    public static Connection conn = null;

    public ConnectDB() throws SQLException {
        String severName = "localhost";
        String databaseName = "HieuSach";
        String username = "sa";
        String password = "sapassword";
        String url = "jdbc:sqlserver://" + severName + ":1433;databaseName=" + databaseName;
        this.conn = DriverManager.getConnection(url, username, password);
        System.out.println(conn);
    }

    public void disconnect() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
