package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NhanVienBanHang extends NhanVien {
	private int caLamViec;
	public List<HoaDon> hoaDons = new ArrayList<HoaDon>();
	
	public NhanVienBanHang(int maNv, String tenNv, String soDienThoai, String diaChi, TaiKhoan taiKhoan, int caLamViec,
			List<HoaDon> hoaDons) {
		super(maNv, tenNv, soDienThoai, diaChi, taiKhoan);
		this.caLamViec = caLamViec;
		this.hoaDons = hoaDons;
	}

	public int getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(int caLamViec) {
		this.caLamViec = caLamViec;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}
	
	
}