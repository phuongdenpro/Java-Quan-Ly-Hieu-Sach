package entity;

import java.sql.Date;
import java.util.ArrayList;

public class HoaDon {
	private int maHD;
	private double tongTien;
	private Date ngayMua;
	public NhanVien nhanVien;
	public KhachHang khachHang;
	public ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	
	public HoaDon(int maHD, double tongTien, Date ngayMua, NhanVien nhanVien, KhachHang khachHang,
			ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		super();
		this.maHD = maHD;
		this.tongTien = tongTien;
		this.ngayMua = ngayMua;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTietHoaDons = chiTietHoaDons;
	}
	
	public HoaDon(NhanVien nhanVien, KhachHang khachHang,
			ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		super();
		
		this.ngayMua = new Date(new java.util.Date().getTime());
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTietHoaDons = chiTietHoaDons;
		this.tongTien = tinhTongTien();
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", tongTien=" + tongTien + ", ngayMua=" + ngayMua + ", nhanVienBanHang="
				+ nhanVien + ", khachHang=" + khachHang + ", chiTietHoaDons=" + chiTietHoaDons + "]";
	}
	
	
	public double tinhTongTien() {
		double tongTien = 0;
		for(int i=0; i<chiTietHoaDons.size(); i++) {
			tongTien += chiTietHoaDons.get(i).tinhThanhTien();
		}
		return tongTien;
		
	}
}