package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDb.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

public class SachDAO extends ConnectDB{
	
	public SachDAO() throws SQLException {
		super();
		
	}

    public ArrayList<SanPham> getListSanPham() {
    	ArrayList<SanPham> dataList = new ArrayList<SanPham>();
        Statement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham inner join loaiSanPham on SanPham.MaLoai = loaiSanPham.MaLoai inner join NhaCungCap on SanPham.MaNCC = NhaCungCap.MaNCC";
            stmt = this.conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                System.out.println(rs);
            	printResultSet(rs);
                SanPham sanPham = new SanPham(rs);
                dataList.add(sanPham);
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
    
    public ArrayList<SanPham> getListSanPhamByMaLoai(int maLoai) {
    	ArrayList<SanPham> dataList = new ArrayList<SanPham>();
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham where maLoai = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maLoai);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	printResultSet(rs);
                SanPham sanPham = new SanPham(rs);
                dataList.add(sanPham);
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
    
    public SanPham getSanPham(int maSP) {
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham where maSP = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maSP);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next())
            	return null;
            
            SanPham sp = new SanPham(rs);
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
    
    public boolean capNhat(SanPham sp) {
    	PreparedStatement stmt = null;
        try {

            String sql = "UPDATE dbo.SanPham set tenSP = ?, giaSP = ?, giaNhap = ?, soLuong = ? where maSP = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, sp.getTenSp());
            stmt.setDouble(2, sp.getGiaSp());
            stmt.setDouble(3, sp.getGiaNhap());
            stmt.setInt(4, sp.getSoLuong());
            stmt.setInt(5, sp.getMaSp());
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
    
    public List<SanPham> getSanPhamDaHet() {
    	ArrayList<SanPham> dataList = new ArrayList<SanPham>();
    	
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham inner join dbo.NhaCungCap on sanPham.MaNCC = nhaCungCap.MaNCC inner join dbo.LoaiSanPham on sanPham.maLoai = loaiSanPham.maLoai where soLuong = 0";
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//            	printResultSet(rs);
                SanPham sanPham = new SanPham(rs);
                dataList.add(sanPham);
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
    	SachDAO sanPhamDao = new SachDAO();
//    	System.out.println(sanPhamDao.getListSanPham());
    	sanPhamDao.getListSanPhamByMaLoai(1);
	}
}
