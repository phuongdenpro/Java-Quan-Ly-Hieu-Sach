package dao;

import java.util.*;

import javax.swing.JOptionPane;

import connectdb.ConnectDB;

import java.sql.*;
import java.sql.Date;

import entity.KhachHang;
import entity.NhanVien;
import entity.NhaCungCap;
import entity.SanPham;


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
//            	printResultSet(rs);
            	KhachHang kh = new KhachHang(rs);
            	dataList.add(kh);
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

    public boolean themKhachHang(KhachHang kh, int taiKhoanId) {
    	PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO dbo.KhachHang (hoTen, soDienThoai, diaChi, taiKhoanId) values(?, ?, ?, ?)";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, kh.getHoTen());
            stmt.setString(2, kh.getSoDienThoai());
            stmt.setString(3, kh.getDiaChi());
            stmt.setInt(4, taiKhoanId);
            int n = stmt.executeUpdate();
//            
            if(n == 0)
                return false;
            
            return true;
//                
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
    
    public KhachHang getKhachHang(int maKH) {
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.KhachHang where maKH = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, maKH);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next())
            	return null;
            
            KhachHang kh = new KhachHang(rs);
            return kh;
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
    
    public KhachHang getKhachHangByMaTK(int taiKhoanID) {
        PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.KhachHang where taiKhoanID = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, taiKhoanID);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next())
            	return null;
            
            KhachHang kh = new KhachHang(rs);
            return kh;
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

	public boolean suaKH(KhachHang kh,int ma) {
	    PreparedStatement stmt = null;
		try {
		
		    String sql = "UPDATE KhachHang set HoTen = ?, soDienThoai = ?, diaChi = ? where maKh = ?";
		    stmt = this.conn.prepareStatement(sql);
		    
		    stmt.setString(1, kh.getHoTen());
		    stmt.setString(2, kh.getSoDienThoai());
		    stmt.setString(3, kh.getDiaChi());
		    stmt.setInt(4, ma);
		    
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
	
	public boolean xoaKhachHang(KhachHang kh) {
		PreparedStatement stmt = null;
		try {
		String sql = "delete from dbo.KhachHang where maKH = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, kh.getMaKh());
			
			int n = stmt.executeUpdate();
			
			if(n== 0) 
				return false;
			new TaiKhoanDAO().xoaTaiKhoan(kh.getTaiKhoan().getId());
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}
    
    public Map<KhachHang, Map<String, Integer>> thongKeKHTN(int count) {
    	Map<KhachHang, Map<String, Integer>> kq = new LinkedHashMap<KhachHang, Map<String, Integer>>();
    	PreparedStatement stmt = null;
        try {
        	String top = "";
        	if(count != 0)
        		top = " top "+count+" ";
        	
            String sql = "select "+top+" KhachHang.maKH, HoTen, SoDienThoai, DiaChi, count(KhachHang.maKH) as soLanMuaHang, sum(tongTien) as tongTien\r\n"
            		+ "  from [HieuSach].[dbo].[HoaDon]\r\n"
            		+ "  inner join [HieuSach].[dbo].[KhachHang]\r\n"
            		+ "  on HoaDon.maKH = KhachHang.maKH\r\n"
            		+ "  group by KhachHang.maKH, HoTen, SoDienThoai, DiaChi\r\n"
            		+ "  order by tongTien desc";
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//            	printResultSet(rs);
            	KhachHang kh = new KhachHang(rs);
            	Map<String, Integer> mp = new HashMap<String, Integer>();
            	mp.put("soLanMuaHang", rs.getInt("soLanMuaHang"));
            	mp.put("tongTien", rs.getInt("tongTien"));
            	kq.put(kh, mp);
            }
            
            return kq;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return kq;
    }
    
    public Map<KhachHang, Map<String, Integer>> thongKeKHTN(Date d1, Date d2, int count) {
    	Map<KhachHang, Map<String, Integer>> kq = new LinkedHashMap<KhachHang, Map<String, Integer>>();
    	PreparedStatement stmt = null;
        try {
        	String top = "";
        	if(count != 0)
        		top = " top "+count+" ";
        	
            String sql = "select "+ top +" KhachHang.maKH, HoTen, SoDienThoai, DiaChi, count(KhachHang.maKH) as soLanMuaHang, sum(tongTien) as tongTien\r\n"
            		+ "from [HieuSach].[dbo].[HoaDon]\r\n"
            		+ "inner join [HieuSach].[dbo].[KhachHang]\r\n"
            		+ "on HoaDon.maKH = KhachHang.maKH\r\n"
            		+ "where ngayMua >= ? and ngayMua <= ?\r\n"
            		+ "group by KhachHang.maKH, HoTen, SoDienThoai, DiaChi\r\n"
            		+ "order by tongTien desc";
            stmt = this.conn.prepareStatement(sql);
            stmt.setDate(1, d1);
            stmt.setDate(2, d2);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//            	printResultSet(rs);
            	KhachHang kh = new KhachHang(rs);
            	Map<String, Integer> mp = new HashMap<String, Integer>();
            	mp.put("soLanMuaHang", rs.getInt("soLanMuaHang"));
            	mp.put("tongTien", rs.getInt("tongTien"));
            	kq.put(kh, mp);
            }
            
            return kq;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return kq;
    }
    
    public Map<KhachHang, Map<String, Integer>> thongKeKHMuaIt(int count) {
    	Map<KhachHang, Map<String, Integer>> kq = new LinkedHashMap<KhachHang, Map<String, Integer>>();
    	PreparedStatement stmt = null;
        try {
        	String top = "";
        	if(count != 0)
        		top = " top "+count+" ";
        	
            String sql = "select "+top+" KhachHang.maKH, HoTen, SoDienThoai, DiaChi, count(KhachHang.maKH) as soLanMuaHang, sum(tongTien) as tongTien\r\n"
            		+ "  from [HieuSach].[dbo].[HoaDon]\r\n"
            		+ "  inner join [HieuSach].[dbo].[KhachHang]\r\n"
            		+ "  on HoaDon.maKH = KhachHang.maKH\r\n"
            		+ "  group by KhachHang.maKH, HoTen, SoDienThoai, DiaChi\r\n"
            		+ "  order by tongTien";
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//            	printResultSet(rs);
            	KhachHang kh = new KhachHang(rs);
            	Map<String, Integer> mp = new HashMap<String, Integer>();
            	mp.put("soLanMuaHang", rs.getInt("soLanMuaHang"));
            	mp.put("tongTien", rs.getInt("tongTien"));
            	kq.put(kh, mp);
            }
            
            return kq;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return kq;
    }
    
    public Map<KhachHang, Map<String, Integer>> thongKeKHMuaIt(Date d1, Date d2, int count) {
    	Map<KhachHang, Map<String, Integer>> kq = new LinkedHashMap<KhachHang, Map<String, Integer>>();
    	PreparedStatement stmt = null;
        try {
        	String top = "";
        	if(count != 0)
        		top = " top "+count+" ";
        	
            String sql = "select "+ top +" KhachHang.maKH, HoTen, SoDienThoai, DiaChi, count(KhachHang.maKH) as soLanMuaHang, sum(tongTien) as tongTien\r\n"
            		+ "from [HieuSach].[dbo].[HoaDon]\r\n"
            		+ "inner join [HieuSach].[dbo].[KhachHang]\r\n"
            		+ "on HoaDon.maKH = KhachHang.maKH\r\n"
            		+ "where ngayMua >= ? and ngayMua <= ?\r\n"
            		+ "group by KhachHang.maKH, HoTen, SoDienThoai, DiaChi\r\n"
            		+ "order by tongTien";
            stmt = this.conn.prepareStatement(sql);
            stmt.setDate(1, d1);
            stmt.setDate(2, d2);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//            	printResultSet(rs);
            	KhachHang kh = new KhachHang(rs);
            	Map<String, Integer> mp = new HashMap<String, Integer>();
            	mp.put("soLanMuaHang", rs.getInt("soLanMuaHang"));
            	mp.put("tongTien", rs.getInt("tongTien"));
            	kq.put(kh, mp);
            }
            
            return kq;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return kq;
    }
    
    public int soLuongKhachHang() {
    	PreparedStatement stmt = null;
        try {

            String sql = "SELECT count(maKH) as soLuong FROM dbo.KhachHang";
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next()) {
            	return 0;
            }
            
            return rs.getInt("soLuong");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }
}
