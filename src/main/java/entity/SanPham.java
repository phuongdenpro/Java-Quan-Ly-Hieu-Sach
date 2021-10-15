package entity;

import java.util.ArrayList;
import java.util.List;

public class SanPham {
	private String maSp;
	private String tenSp;
	private double giaSp;
	public LoaiSanPham loaiSanPham;
	public NhaCungCap nhaCungCap;
	public List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	public List<ChiTietDonDatHang> chiTietDonDatHangs = new ArrayList<ChiTietDonDatHang>();
	
	public SanPham(String maSp, String tenSp, double giaSp, LoaiSanPham loaiSanPham, NhaCungCap nhaCungCap,
			List<ChiTietHoaDon> chiTietHoaDons, List<ChiTietDonDatHang> chiTietDonDatHangs) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.giaSp = giaSp;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
		this.chiTietHoaDons = chiTietHoaDons;
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public double getGiaSp() {
		return giaSp;
	}

	public void setGiaSp(double giaSp) {
		this.giaSp = giaSp;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public List<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(List<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}
	
	
}