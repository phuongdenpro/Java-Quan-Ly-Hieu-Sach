package entity;

import java.util.Vector;

public class SanPham {
	private String _maSp;
	private String _tenSp;
	private double _giaSp;
	public LoaiSanPham _loaiSanPham;
	public NhaCungCap _nhaCungCap;
	public Vector<ChiTietHoaDon> _chiTietHoaDons = new Vector<ChiTietHoaDon>();
	public Vector<ChiTietDonDatHang> _chiTietDonDatHangs = new Vector<ChiTietDonDatHang>();
}