package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

public class SanPhamDAO extends ConnectDB{
	
	public SanPhamDAO() throws SQLException {
		super();
		
	}

    public List<SanPham> getListSanPham() {
        List<SanPham> dataList = new ArrayList<SanPham>();
        Statement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham";
            stmt = this.conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.toString());
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
    
    public static void main(String[] args) throws SQLException {
    	SanPhamDAO sanPhamDao = new SanPhamDAO();
    	sanPhamDao.getListSanPham();
	}
}
