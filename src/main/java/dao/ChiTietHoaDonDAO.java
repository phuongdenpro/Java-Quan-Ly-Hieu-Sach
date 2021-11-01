package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectdb.ConnectDB;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonDAO extends ConnectDB{

	public ChiTietHoaDonDAO() throws SQLException {
		super();
	}
	
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd, int maHD) {
		PreparedStatement stmt = null;
		try {
			
		    String sql = "INSERT INTO dbo.ChiTietHoaDon (maSP, maHD, soLuong, donGia) values(?, ?, ?, ?)";
		    stmt = this.conn.prepareStatement(sql);
		    
		    stmt.setInt(1, cthd.getSanPham().getMaSp());
		    stmt.setInt(2, maHD);
		    stmt.setInt(3, cthd.getSoLuong());
		    stmt.setDouble(4, cthd.getDonGia());
		    
		    int n = stmt.executeUpdate();
		    
		    return n > 0;
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        stmt.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		return false;	
	}

}
