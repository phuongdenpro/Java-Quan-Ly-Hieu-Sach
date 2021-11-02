package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import connectdb.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.SanPham;

public class SanPhamDAO extends ConnectDB{
	
	public SanPhamDAO() throws SQLException {
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
    public ArrayList<SanPham> getListSach() {
    	ArrayList<SanPham> dataList = new ArrayList<SanPham>();
        Statement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.SanPham inner join loaiSanPham on SanPham.MaLoai = loaiSanPham.MaLoai inner join NhaCungCap on SanPham.MaNCC = NhaCungCap.MaNCC\r\n" + 
            		"where TenLoai like 'Sách%'";
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
    
    public int getSoLuongSP(int maSP) {
    	PreparedStatement stmt = null;
        try {

            String sql = "SELECT soLuong FROM dbo.SanPham where maSP = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maSP);
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("soLuong");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    
    public Map<SanPham, Integer> thongKeSPBanChay() {
    	Map<SanPham, Integer> kq = new LinkedHashMap<SanPham, Integer>();
    	PreparedStatement stmt = null;
        try {

            String sql = "select SanPham.maSP, tenSP, maNCC, dongia, sum([ChiTietHoaDon].soLuong) as soLuongDaBan\r\n"
            		+ "from [HieuSach].[dbo].[ChiTietHoaDon]\r\n"
            		+ "inner join [HieuSach].[dbo].[SanPham]\r\n"
            		+ "on ChiTietHoaDon.maSP = SanPham.maSP\r\n"
            		+ "group by SanPham.maSP, SanPham.maSP, tenSP, maNCC, dongia\r\n"
            		+ "order by soLuongDaBan desc";
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
            	printResultSet(rs);
            	NhaCungCap ncc = new NhaCungCapDAO().getNhaCungCap(rs.getInt("maNCC"));
            	SanPham sp = new SanPham(rs.getInt("maSP"), rs.getString("tenSP"), rs.getDouble("donGia"), ncc);
            	kq.put(sp, rs.getInt("soLuongDaBan"));
            }
            
            return kq;
            
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
    
    public Map<SanPham, Integer> thongKeSPBanChay(Date tuNgay, Date toiNgay) {
    	Map<SanPham, Integer> kq = new LinkedHashMap<SanPham, Integer>();
    	PreparedStatement stmt = null;
        try {

            String sql = "select maSP, tenSP, maNCC, dongia, sum(soLuongDaBan) as soLuongDaBan from (select SanPham.maSP, tenSP, maNCC, dongia, ngayMua, sum([ChiTietHoaDon].soLuong) as soLuongDaBan\r\n"
            		+ "from [HieuSach].[dbo].[ChiTietHoaDon]\r\n"
            		+ "inner join [HieuSach].[dbo].[SanPham]\r\n"
            		+ "on ChiTietHoaDon.maSP = SanPham.maSP\r\n"
            		+ "inner join [HieuSach].[dbo].[HoaDon]\r\n"
            		+ "on ChiTietHoaDon.maHD = HoaDon.maHD\r\n"
            		+ "group by SanPham.maSP, SanPham.maSP, tenSP, maNCC, dongia, ngayMua\r\n"
            		+ "having ngayMua >= ? and ngayMua <= ?) as cthd\r\n"
            		+ "group by cthd.maSP, cthd.maSP, tenSP, maNCC, dongia\r\n"
            		+ "order by soLuongDaBan desc";
            stmt = this.conn.prepareStatement(sql);
            stmt.setDate(1, tuNgay);
            stmt.setDate(2, toiNgay);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
            	printResultSet(rs);
            	NhaCungCap ncc = new NhaCungCapDAO().getNhaCungCap(rs.getInt("maNCC"));
            	SanPham sp = new SanPham(rs.getInt("maSP"), rs.getString("tenSP"), rs.getDouble("donGia"), ncc);
            	kq.put(sp, rs.getInt("soLuongDaBan"));
            }
            
            return kq;
            
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
    
    public static void main(String[] args) throws SQLException {
    	SanPhamDAO sanPhamDao = new SanPhamDAO();
//    	System.out.println(sanPhamDao.getListSanPham());
    	sanPhamDao.getListSanPhamByMaLoai(1);
	}
}
