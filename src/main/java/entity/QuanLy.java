package entity;

public class QuanLy extends NhanVien {
	
	public QuanLy(int maNv, String tenNv, String soDienThoai, String diaChi, TaiKhoan taiKhoan) {
		super(maNv, tenNv, soDienThoai, diaChi, taiKhoan);
	}

	@Override
	public String toString() {
		return "QuanLy []";
	}
	
	
}