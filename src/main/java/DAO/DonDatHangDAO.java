package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.DonDatHang;
import entity.KhachHang;
import entity.SanPham;

public class DonDatHangDAO extends ConnectDB{

    public DonDatHangDAO() throws SQLException {
		super();
	}
    
    public boolean themSanPhamVaoDonDatHang(SanPham sp, int soLuong, int maKH) {
        PreparedStatement stmt = null;

        try {
        	

            String sql = "SELECT maDDH FROM dbo.DonDatHang where maKH = ? and tinhTrang = 0";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maKH);
            ResultSet rsDDH = stmt.executeQuery();
            
//            System.out.println(rsDDH.next());
//          kiểm tra xem đã có đơn đặt hàng chưa đặt của khách hàng đó không
            if(!rsDDH.next()) {
//				Chưa có đơn -> Tạo mới
            	System.out.println(this.taoDDH(maKH));
            	
//            	thêm sản phẩm vào đơn hàng
            	
            	return this.themSanPhamVaoDonDatHang(sp, soLuong, maKH);
            }else {
//            	kiểm tra xem đã có sản phẩm đó trong đơn đặt hàng chưa
            	sql = "UPDATE dbo.ChiTietDonDatHang SET SoLuong = ? WHERE maDDH = ? and MaSP = ?";
            	PreparedStatement prpStmt = this.conn.prepareStatement(sql);
            	prpStmt.setInt(1, soLuong);
            	prpStmt.setInt(2, rsDDH.getInt("maDDH"));
            	prpStmt.setInt(3, sp.getMaSp());
                int n = prpStmt.executeUpdate();
                
                if(n == 0) { // chưa có sản phẩm đó trong đơn đặt hàng
                	ChiTietDonDatHangDAO chiTietDDHDao = new ChiTietDonDatHangDAO();
                	return chiTietDDHDao.themChiTietDonDatHang(sp, rsDDH.getInt("maDDH"), soLuong);
                }
                return n > 0;
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
    	
    	return false;
    }
    
    public boolean taoDDH(int maKH) {
    	PreparedStatement stmt = null;
        try {

            String sql = "INSERT INTO dbo.DonDatHang (maKH, tongTien, tinhTrang) values(?, 0, 0)";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maKH);
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
    
    public DonDatHang getDonDatHang(int maKH) {
    	PreparedStatement stmt = null;

        try {
        	

            String sql = "SELECT * FROM dbo.DonDatHang where maKH = ? and tinhTrang = 0";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maKH);
            ResultSet rsDDH = stmt.executeQuery();
            
//          kiểm tra xem đã có đơn đặt hàng chưa đặt của khách hàng đó không
            if(!rsDDH.next()) {
            	return null;
            }
            printResultSet(rsDDH);
            DonDatHang ddh = new DonDatHang(rsDDH);
            
            ddh.setChiTietDonDatHangs(new ChiTietDonDatHangDAO().getDSChiTietDDH(rsDDH.getInt("maDDH")));
            
            return ddh;
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
    
    public boolean xacNhanDatHang(int maKH) {
    	PreparedStatement stmt = null;

        try {
        	DonDatHang ddh = this.getDonDatHang(maKH);
        	ddh.tinhTongTien();
        	
        	Date now = new Date(new java.util.Date().getTime());
        	String sql = "UPDATE dbo.DonDatHang SET tinhTrang = 1, tongTien = ?, ngayDat = ? WHERE maKH = ? and tinhTrang = 0";
        	PreparedStatement prpStmt = this.conn.prepareStatement(sql);
        	prpStmt.setDouble(1, ddh.getTongTien());
        	prpStmt.setDate(2, now);
        	prpStmt.setInt(3, maKH);
            int n = prpStmt.executeUpdate();
               
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    	
    	return false;
    }
    
    public boolean thanhToan(int maDDH) {
    	PreparedStatement stmt = null;

        try {
        	
        	Date now = new Date(new java.util.Date().getTime());
        	String sql = "UPDATE dbo.DonDatHang SET tinhTrang = 2 WHERE maDHH = ?";
        	PreparedStatement prpStmt = this.conn.prepareStatement(sql);
        	prpStmt.setDouble(1, maDDH);
            int n = prpStmt.executeUpdate();
               
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    	
    	return false;
    }
    
    public boolean xoaDonDatHang(int maDDH) {
    	PreparedStatement stmt = null;

        try {
        	if(new ChiTietDonDatHangDAO().xoaHetChiTietDonDatHang(maDDH) == false) {
        		return false;
        	}
        	
        	String sql = "DELETE from dbo.DonDatHang WHERE maDDH = ?";
        	PreparedStatement prpStmt = this.conn.prepareStatement(sql);
        	
        	prpStmt.setDouble(1, maDDH);
            int n = prpStmt.executeUpdate();
               
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    	
    	return false;
    }
    
    public List<DonDatHang> getDSDonDatHang() {
    	Statement stmt = null;
    	List<DonDatHang> dsddh = new ArrayList<DonDatHang>();
        try {
        	

            String sql = "SELECT * FROM dbo.DonDatHang where tinhTrang != 0";
            stmt = this.conn.createStatement();
            ResultSet rsDDH = stmt.executeQuery(sql);
            
//          kiểm tra xem đã có đơn đặt hàng chưa đặt của khách hàng đó không
            while(rsDDH.next()) {
            	printResultSet(rsDDH);
            	DonDatHang ddh = new DonDatHang(rsDDH);
            	ddh.setChiTietDonDatHangs(new ChiTietDonDatHangDAO().getDSChiTietDDH(rsDDH.getInt("maDDH")));
            	dsddh.add(ddh);
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
    	
    	return dsddh;
    }
    
    public static void main(String[] args) throws SQLException {
//    	KhachHang kh = new KhachHangDAO().getKhachHang(1);
//    	SanPham sp = new SanPhamDAO().getSanPham(17);
    	DonDatHangDAO DDHDao = new DonDatHangDAO();
//    	
//    	System.out.println(DDHDao.themSanPhamVaoDonDatHang(sp, 1, 1));
    	System.out.println(DDHDao.getDonDatHang(1));
	}
}
