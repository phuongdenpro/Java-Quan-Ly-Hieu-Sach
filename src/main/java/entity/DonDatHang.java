package entity;

import java.sql.Date;
import java.util.Vector;

public class DonDatHang {
	private String _maDDH;
	private double _tongTien;
	private Date _ngayDat;
	public KhachHang _khachHang;
	public Vector<ChiTietDonDatHang> _chiTietDonDatHangs = new Vector<ChiTietDonDatHang>();
	public HoaDon _hoaDon;
}