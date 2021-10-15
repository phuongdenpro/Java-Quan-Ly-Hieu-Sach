package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DonDatHang {
	private String maDDH;
	private double tongTien;
	private Date ngayDat;
	public KhachHang khachHang;
	public List<ChiTietDonDatHang> chiTietDonDatHangs = new ArrayList<ChiTietDonDatHang>();
	public HoaDon hoaDon;
	
	public DonDatHang(String maDDH, double tongTien, Date ngayDat, KhachHang khachHang,
			ArrayList<ChiTietDonDatHang> chiTietDonDatHangs, HoaDon hoaDon) {
		super();
		this.maDDH = maDDH;
		this.tongTien = tongTien;
		this.ngayDat = ngayDat;
		this.khachHang = khachHang;
		this.chiTietDonDatHangs = chiTietDonDatHangs;
		this.hoaDon = hoaDon;
	}

	public String getMaDDH() {
		return maDDH;
	}

	public void setMaDDH(String maDDH) {
		this.maDDH = maDDH;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(ArrayList<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	
}