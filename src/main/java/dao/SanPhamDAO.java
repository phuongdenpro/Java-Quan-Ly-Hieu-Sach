package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.SanPham;

public class SanPhamDAO extends ConnectDB {

	public SanPhamDAO() throws SQLException {
		super();

	}

	public ArrayList<SanPham> getListSanPham() {
		ArrayList<SanPham> dataList = new ArrayList<SanPham>();
		Statement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham inner join loaiSanPham on SanPham.MaLoai = loaiSanPham.MaLoai inner join NhaCungCap on SanPham.MaNCC = NhaCungCap.MaNCC";
			stmt = this.conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//                System.out.println(rs);
				printResultSet(rs);
				SanPham sanPham = new SanPham(rs);
				dataList.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}

	public ArrayList<SanPham> getListSach() {
		ArrayList<SanPham> dataList = new ArrayList<SanPham>();
		Statement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham inner join loaiSanPham on SanPham.MaLoai = loaiSanPham.MaLoai inner join NhaCungCap on SanPham.MaNCC = NhaCungCap.MaNCC\r\n"
					+ "where TenLoai like 'Sách%'";
			stmt = this.conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//                System.out.println(rs);
				printResultSet(rs);
				SanPham sanPham = new SanPham(rs);
				dataList.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}

	public ArrayList<SanPham> getListSanPhamByMaLoai(int maLoai) {
		ArrayList<SanPham> dataList = new ArrayList<SanPham>();
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham where maLoai = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, maLoai);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				printResultSet(rs);
				SanPham sanPham = new SanPham(rs);
				dataList.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}

	public SanPham getSanPham(int maSP) {
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham where maSP = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, maSP);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next())
				return null;

			SanPham sp = new SanPham(rs);
			return sp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public SanPham getSanPhamCuoiCung() {
		Statement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham WHERE MaSP=(SELECT max(MaSP) FROM dbo.SanPham);";
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next())
				return null;
			SanPham sp = new SanPham(rs);
			return sp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean create(SanPham sp) {
		PreparedStatement statement = null;

		try {
			String sql = "insert into SanPham (MaNCC, MaLoai, TenSp, GiaSp, GiaNhap, SoLuong) values(?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, sp.getNhaCungCap().getMaNCC());
			statement.setInt(2, sp.getLoaiSanPham().getMaLoai());
			statement.setString(3, sp.getTenSp());
			statement.setDouble(4, sp.getGiaSp());
			statement.setDouble(5, sp.getGiaNhap());
			statement.setInt(6, sp.getSoLuong());
			int n = statement.executeUpdate();

			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	public ArrayList<NhaCungCap> getListNhaCungCap() {
		ArrayList<NhaCungCap> dataList = new ArrayList<NhaCungCap>();
		Statement stmt = null;
		try {

			String sql = "select * from NhaCungCap";
			stmt = this.conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				printResultSet(rs);
				NhaCungCap ncc = new NhaCungCap(rs);
				dataList.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}
	public boolean createNCC(String tenNCC) {
		PreparedStatement statement = null;

		try {
			String sql = "insert into NhaCungCap (tenNCC) values(?);";
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenNCC);
			int n = statement.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	
	public NhaCungCap getNCCByTenNCC(String tenNCC) {
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.NhaCungCap where tenNCC = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, tenNCC);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next())
				return null;

			NhaCungCap sp = new NhaCungCap(rs);
			return sp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean capNhat(SanPham sp) {
		PreparedStatement stmt = null;
		try {

			String sql = "UPDATE dbo.SanPham set tenSP = ?, giaSP = ?, giaNhap = ?, soLuong = ? where maSP = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, sp.getTenSp());
			stmt.setDouble(2, sp.getGiaSp());
			stmt.setDouble(3, sp.getGiaNhap());
			stmt.setInt(4, sp.getSoLuong());
			stmt.setInt(5, sp.getMaSp());
			int n = stmt.executeUpdate();

			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<SanPham> getSanPhamDaHet() {
		ArrayList<SanPham> dataList = new ArrayList<SanPham>();

		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM dbo.SanPham inner join dbo.NhaCungCap on sanPham.MaNCC = nhaCungCap.MaNCC inner join dbo.LoaiSanPham on sanPham.maLoai = loaiSanPham.maLoai where soLuong = 0";
			stmt = this.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
//            	printResultSet(rs);
				SanPham sanPham = new SanPham(rs);
				dataList.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}

	public int getSoLuongSP(int maSP) {
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT soLuong FROM dbo.SanPham where maSP = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, maSP);
			ResultSet rs = stmt.executeQuery(sql);
			return rs.getInt("soLuong");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static void main(String[] args) throws SQLException {
		SanPhamDAO sanPhamDao = new SanPhamDAO();
//    	System.out.println(sanPhamDao.getListSanPham());
		sanPhamDao.getListSanPhamByMaLoai(1);
	}
}
