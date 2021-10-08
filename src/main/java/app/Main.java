package app;

import java.sql.SQLException;

import ConnectDB.ConnectDB;
import DAO.KhachHangDAO;

public class Main {
	public static void main(String[] args) {
		try{
            ConnectDB.getInstance().connect();
        }catch(SQLException e){
            e.printStackTrace();
        }
		KhachHangDAO khachHangDao = new KhachHangDAO();
		System.out.println("hello world");
		khachHangDao.getListKhachHang();
	}
}
