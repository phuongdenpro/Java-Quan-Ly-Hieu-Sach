package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HoaDon {
	private String maHD;
	private double tongTien;
	private Date ngayMua;
	public NhanVienBanHang nhanVienBanHang;
	public KhachHang khachHang;
	public List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	public DonDatHang donDatHang;
	
	public HoaDon(String maHD, double tongTien, Date ngayMua, NhanVienBanHang nhanVienBanHang, KhachHang khachHang,
			ArrayList<ChiTietHoaDon> chiTietHoaDons, DonDatHang donDatHang) {
		super();
		this.maHD = maHD;
		this.tongTien = tongTien;
		this.ngayMua = ngayMua;
		this.nhanVienBanHang = nhanVienBanHang;
		this.khachHang = khachHang;
		this.chiTietHoaDons = chiTietHoaDons;
		this.donDatHang = donDatHang;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
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

	public NhanVienBanHang getNhanVienBanHang() {
		return nhanVienBanHang;
	}

	public void setNhanVienBanHang(NhanVienBanHang nhanVienBanHang) {
		this.nhanVienBanHang = nhanVienBanHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public DonDatHang getDonDatHang() {
		return donDatHang;
	}

	public void setDonDatHang(DonDatHang donDatHang) {
		this.donDatHang = donDatHang;
	}
	
	
}