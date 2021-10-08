package entity;

import java.util.Vector;

public class KhachHang {
	private int _maKh;
	private String _hoTen;
	private String _soDienThoai;
	private String _diaChi;
	public Vector<HoaDon> _hoaDons = new Vector<HoaDon>();
	public TaiKhoan _taiKhoan;
	public Vector<DonDatHang> _donDatHangs = new Vector<DonDatHang>();
}