package entity;

import java.util.ArrayList;
import java.util.List;

public class KhachHang {
	private int maKh;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	public List<HoaDon> hoaDons = new ArrayList<HoaDon>();
	public TaiKhoan taiKhoan;
	public List<DonDatHang> donDatHangs = new ArrayList<DonDatHang>();
	
	public KhachHang(int maKh, String hoTen, String soDienThoai, String diaChi, List<HoaDon> hoaDons, TaiKhoan taiKhoan,
			List<DonDatHang> donDatHangs) {
		super();
		this.maKh = maKh;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.hoaDons = hoaDons;
		this.taiKhoan = taiKhoan;
		this.donDatHangs = donDatHangs;
	}

	public int getMaKh() {
		return maKh;
	}

	public void setMaKh(int maKh) {
		this.maKh = maKh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<DonDatHang> getDonDatHangs() {
		return donDatHangs;
	}

	public void setDonDatHangs(List<DonDatHang> donDatHangs) {
		this.donDatHangs = donDatHangs;
	}
	
	
}