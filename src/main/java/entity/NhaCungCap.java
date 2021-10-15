package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NhaCungCap {
	private int maNCC;
	private String tenNCC;
	private String diaChi;
	private String soDienThoai;
	public List<SanPham> sanPhams = new ArrayList<SanPham>();
	
	public NhaCungCap(int maNCC, String tenNCC, String diaChi, String soDienThoai, List<SanPham> sanPhams) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.sanPhams = sanPhams;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}