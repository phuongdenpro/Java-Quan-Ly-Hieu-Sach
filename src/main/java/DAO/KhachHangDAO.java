package DAO;

import java.util.*;

import ConnectDB.ConnectDB;

import java.sql.*;

import entity.KhachHang;

public class KhachHangDAO extends ConnectDB{

    public KhachHangDAO() throws SQLException {
		super();
		
	}

    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> dataList = new ArrayList<KhachHang>();
        Statement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.KhachHang";
            stmt = this.conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("soDienThoai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    
}
