package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVienDAO extends ConnectDB{

	public NhanVienDAO() throws SQLException {
		super();
	}
	
//	lấy thông tin nhân viên bằng mã tài khoản
	public NhanVien getNhanVienByMaTK(int taiKhoanID) {
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.NhanVien where taiKhoanID = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, taiKhoanID);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next())
            	return null;
            
            NhanVien nv = new NhanVien(rs);
            nv.setTaiKhoan(new TaiKhoan(taiKhoanID));
            return nv;
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
	
	public List<NhanVien> getDSNV(){
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
	    PreparedStatement stmt = null;
		try {
		
		    String sql = "SELECT * FROM dbo.NhanVien";
		    stmt = this.conn.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery();

		    while(rs.next()) {
		    	printResultSet(rs);
		    	NhanVien nv = new NhanVien(rs);
		    	dsnv.add(nv);
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
		return dsnv;		
	}
	
	public NhanVien getNhanVienByMaNV(int maNV){
	    PreparedStatement stmt = null;
		try {
		
		    String sql = "SELECT * FROM dbo.NhanVien where maNV = ?";
		    stmt = this.conn.prepareStatement(sql);
		    stmt.setInt(1, maNV);
		    ResultSet rs = stmt.executeQuery();

		    if(!rs.next()) {
		    	return null;
		    }
		    
	    	printResultSet(rs);
	    	NhanVien nv = new NhanVien(rs);
	    	return nv;
		   
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
	
	public boolean suaNV(NhanVien nv) {
	    PreparedStatement stmt = null;
		try {
		
		    String sql = "UPDATE NhanVien set tenNV = ?, soDienThoai = ?, diaChi = ? where maNV = ?";
		    stmt = this.conn.prepareStatement(sql);
		    
		    stmt.setString(1, nv.getTenNv());
		    stmt.setString(2, nv.getSoDienThoai());
		    stmt.setString(3, nv.getDiaChi());
		    stmt.setInt(4, nv.getMaNv());
		    
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
	

	
	public boolean xoaNV(NhanVien nv) {
	    PreparedStatement stmt = null;
		try {
			
			
		    String sql = "DELETE FROM NhanVien where maNV = ?";
		    stmt = this.conn.prepareStatement(sql);
		    
		    stmt.setInt(1, nv.getMaNv());
		    
		    int n = stmt.executeUpdate();
		    
		    if(n == 0) {
		    	return false;
		    }
		    
		    // xoas tai khoan
		    new TaiKhoanDAO().xoaTaiKhoan(nv.getTaiKhoan().getId());
		    
		    return true;
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
	
	public static void main(String[] args) throws SQLException {
		System.out.println(new NhanVienDAO().getDSNV());
	}
	
}
