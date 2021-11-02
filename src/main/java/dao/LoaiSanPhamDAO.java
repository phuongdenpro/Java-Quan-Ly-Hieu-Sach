package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.LoaiSanPham;
import entity.SanPham;

public class LoaiSanPhamDAO extends ConnectDB{
	
	public LoaiSanPhamDAO() throws SQLException {
		super();
		
	}
	public ArrayList<LoaiSanPham> getDanhSachLoaiSach() throws SQLException {
		ArrayList<LoaiSanPham> dataList = new ArrayList<LoaiSanPham>();
        Statement stmt = this.conn.createStatement();
        SanPhamDAO sanPhamDao = new SanPhamDAO();
        
        try {

            String sql = "SELECT * FROM dbo.LoaiSanPham where TenLoai like 'Sách%'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                System.out.println(rs);
//            	printResultSet(rs);
            	LoaiSanPham loaiSp = new LoaiSanPham(rs);
            	loaiSp.setSanPhams(sanPhamDao.getListSanPhamByMaLoai(rs.getInt("maLoai")));
                dataList.add(loaiSp);
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
	
	public ArrayList<LoaiSanPham> getDanhSachLoaiSanPham() throws SQLException {
		ArrayList<LoaiSanPham> dataList = new ArrayList<LoaiSanPham>();
        Statement stmt = this.conn.createStatement();
        SanPhamDAO sanPhamDao = new SanPhamDAO();
        
        try {

            String sql = "SELECT * FROM dbo.LoaiSanPham";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                System.out.println(rs);
//            	printResultSet(rs);
            	LoaiSanPham loaiSp = new LoaiSanPham(rs);
            	loaiSp.setSanPhams(sanPhamDao.getListSanPhamByMaLoai(rs.getInt("maLoai")));
                dataList.add(loaiSp);
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
	public boolean createLoaiSp(String tenLoai) {
		PreparedStatement statement = null;

		try {
			String sql = "insert into LoaiSanPham (TenLoai) values(N'Sách');";
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenLoai);
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
	
	public static void main(String[] args) throws SQLException {
		LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
		System.out.println(loaiSanPhamDAO.getDanhSachLoaiSanPham());
	}

}
