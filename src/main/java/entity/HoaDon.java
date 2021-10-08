package entity;

import java.sql.Date;
import java.util.Vector;

public class HoaDon {
	private String _maHD;
	private double _tongTien;
	private Date _ngayMua;
	public NhanVienBanHang _nhanVienBanHang;
	public KhachHang _khachHang;
	public Vector<ChiTietHoaDon> _chiTietHoaDons = new Vector<ChiTietHoaDon>();
	public DonDatHang _donDatHang;
}