package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import connectdb.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

public class HoaDonDAO extends ConnectDB{
	private String error = "";
	
	public HoaDonDAO() throws SQLException {
		super();
	}

	public boolean themHoaDon(HoaDon hd) {
    	PreparedStatement stmt = null;
        try {
        	ArrayList<ChiTietHoaDon> dscthd = hd.getChiTietHoaDons();
        	
//        	kiểm tra số lượng sp
        	for(int i=0; i<dscthd.size(); i++) {
        		if(dscthd.get(i).getSanPham().getSoLuong() < dscthd.get(i).getSoLuong()) {
        			this.error = "Sản phẩm "+ dscthd.get(i).getSanPham().getTenSp() + " chỉ còn: " + dscthd.get(i).getSanPham().getSoLuong();
        			return false;
        		}
        	}
        	AtomicBoolean flag = new AtomicBoolean();
        	flag.set(true);
//        	cập nhật số lượng sản phẩm
        	dscthd.forEach(cthd -> {
        		SanPham sp = cthd.getSanPham();
        		sp.setSoLuong(sp.getSoLuong()-cthd.getSoLuong());
        		try {
					if(new SanPhamDAO().capNhat(sp) == false) {
						flag.set(false);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	});
        	
        	if(flag.get() == false) {
        		this.error = "Có lỗi xảy ra";
        		return false;
        	}
        	
//        	thêm hóa đơn
            String sql = "INSERT INTO dbo.HoaDon (maNV, maKH, tongTien, ngayMua) values(?, ?, ?, ?)";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, hd.getNhanVien().getMaNv());
            stmt.setInt(2, hd.getKhachHang().getMaKh());
            stmt.setDouble(3, hd.getTongTien());
            stmt.setDate(4, hd.getNgayMua());
            
            int n = stmt.executeUpdate();
            if(n == 0) {
            	this.error = "Có lỗi xảy ra";
        		return false;
        	}
            
//            thêm chi tiết hóa đơn
        	dscthd.forEach(cthd -> {
        		try {
        			boolean flag2 = new ChiTietHoaDonDAO().themChiTietHoaDon(cthd, getLastestMaHD());
        			if(flag2 == false) {
        				this.error =  "Có lỗi xảy ra";
        			}
					flag.set(flag2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	});
            
            return flag.get();
            
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
	
	public int getLastestMaHD() {
        int id = 0;
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM dbo.HoaDon";
            stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            id = rs.getInt("MaHD");
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
	}
	
	public String getError() {
		return this.error;
	}
}
