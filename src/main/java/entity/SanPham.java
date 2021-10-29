package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPham {
	private int maSp;
	private String tenSp;
	private int soLuong;
	private String donViTinh;
	private double giaNhap;
	private double giaSp;
	public LoaiSanPham loaiSanPham;
	public NhaCungCap nhaCungCap;
	public ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	public ArrayList<ChiTietDonDatHang> chiTietDonDatHangs = new ArrayList<ChiTietDonDatHang>();
	
	public SanPham(int maSp, String tenSp,int soLuong,String donViTinh,double giaNhap, double giaSp, LoaiSanPham loaiSanPham, NhaCungCap nhaCungCap,
			ArrayList<ChiTietHoaDon> chiTietHoaDons, ArrayList<ChiTietDonDatHang> chiTietDonDatHangs) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.giaNhap = giaNhap;
		this.giaSp = giaSp;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
		this.chiTietHoaDons = chiTietHoaDons;
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}
	
	public SanPham(ResultSet rs) throws SQLException {
		this.maSp = rs.getInt("maSP");
		this.tenSp = rs.getString("tenSP");
		this.soLuong = rs.getInt("soLuong");
		this.donViTinh = rs.getString("donViTinh");
		this.giaNhap = rs.getDouble("giaNhap");
		this.giaSp = rs.getDouble("giaSp");
		try {
			this.loaiSanPham = new LoaiSanPham(rs);
		}catch (Exception e) {
			
		}
			
		try {
			this.nhaCungCap = new NhaCungCap(rs);
		}catch (Exception e) {
			
		}	
	}

	public int getMaSp() {
		return maSp;
	}

	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
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

	public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public ArrayList<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(ArrayList<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	@Override
	public String toString() {
		return "SanPham [maSp=" + maSp + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", donViTinh=" + donViTinh
				+ ", giaNhap=" + giaNhap + ", giaSp=" + giaSp + ", loaiSanPham=" + loaiSanPham + ", nhaCungCap="
				+ nhaCungCap + ", chiTietHoaDons=" + chiTietHoaDons + ", chiTietDonDatHangs=" + chiTietDonDatHangs
				+ "]";
	}

	
	
	
}