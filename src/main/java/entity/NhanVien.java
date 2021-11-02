package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVien {
	private int maNv;
	private String tenNv;
	private String soDienThoai;
	private String diaChi;
	public TaiKhoan taiKhoan;
	public int caLamViec;
	public int chucNang;
	
	public NhanVien(int maNv, String tenNv, String soDienThoai, String diaChi, TaiKhoan taiKhoan, int caLamViec, int chucNang) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.caLamViec = caLamViec;
		this.chucNang = chucNang;
	}
	
	public NhanVien(String tenNv, String soDienThoai, String diaChi, int caLamViec, int chucNang) {
		super();
		this.tenNv = tenNv;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.caLamViec = caLamViec;
		this.chucNang = chucNang;
	}
	
	public NhanVien(int maNv, String tenNv, String soDienThoai, String diaChi, TaiKhoan taiKhoan) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
	}
	
	public NhanVien(int maNv, String tenNv, String soDienThoai, String diaChi) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	
	public NhanVien(ResultSet rs) throws SQLException {
		this.maNv = rs.getInt("maNV");
		this.tenNv = rs.getString("tenNv");
		this.soDienThoai = rs.getString("soDienThoai");
		this.diaChi = rs.getString("diaChi");
	}

	public int getMaNv() {
		return maNv;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	

	public int getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(int caLamViec) {
		this.caLamViec = caLamViec;
	}

	public int getChucNang() {
		return chucNang;
	}

	public void setChucNang(int chucNang) {
		this.chucNang = chucNang;
	}

	@Override
	public String toString() {
		return "NhanVien [maNv=" + maNv + ", tenNv=" + tenNv + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
				+ ", taiKhoan=" + taiKhoan + ", caLamViec=" + caLamViec + ", chucNang=" + chucNang + "]";
	}

	
	
	
}