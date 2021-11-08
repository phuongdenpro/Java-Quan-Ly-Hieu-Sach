package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.NhaCungCap;
import entity.SanPham;

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
	public ArrayList<NhaCungCap> getListNhaCungCap() {
		ArrayList<NhaCungCap> dataList = new ArrayList<NhaCungCap>();
		Statement stmt = null;
		try {

			String sql = "select * from NhaCungCap";
			stmt = this.conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				printResultSet(rs);
				NhaCungCap ncc = new NhaCungCap(rs);
				dataList.add(ncc);
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
	public boolean createNCC(String tenNCC) {
		PreparedStatement statement = null;

		try {
			String sql = "insert into NhaCungCap (tenNCC) values(?);";
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenNCC);
			int n = statement.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	
	public NhaCungCap getNCCByTenNCC(String tenNCC) {
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.NhaCungCap where tenNCC = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, tenNCC);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next())
				return null;

			NhaCungCap sp = new NhaCungCap(rs);
			return sp;
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
