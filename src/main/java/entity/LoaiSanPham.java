package entity;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPham {
	private int maLoai;
	private String tenLoai;
	public List<SanPham> sanPhams = new ArrayList<SanPham>();
	
	public LoaiSanPham(int maLoai, String tenLoai, List<SanPham> sanPhams) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.sanPhams = sanPhams;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}