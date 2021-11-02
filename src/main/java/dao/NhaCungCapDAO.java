package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectdb.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCapDAO extends ConnectDB{

	public NhaCungCapDAO() throws SQLException {
		super();
	}

	
	public NhaCungCap getNhaCungCap(int maNCC) {
    	PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.NhaCungCap where maNCC = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maNCC);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
            	return null;
            }
            
            NhaCungCap ncc = new NhaCungCap(rs);
            return ncc;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
