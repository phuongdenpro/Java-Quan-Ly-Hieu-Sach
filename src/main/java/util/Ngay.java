package util;

import java.sql.Date;

public class Ngay {
	public static Date now = new Date((long)System.currentTimeMillis()/86400000*86400000);
	
	public static Date homNay() {
		return now;
	}
	
	
	public static Date homQua() {	
		if(now.getDate() == 1) {
			if(now.getMonth() == 0)
				return new Date(now.getYear()-1, 12, 31);
			else 
				return new Date(now.getYear(), now.getMonth()-1, Ngay.getSoNgayTrongThang(now.getMonth(), now.getYear()+1900));
		}else {
			return new Date(now.getYear(), now.getMonth(), now.getDate()-1);
		}
			
	}
	
	public static Date _7NgayQua() {	
		if(now.getDate() <= 7) {
			if(now.getMonth() == 0)
				return new Date(now.getYear()-1, 12, 32-(7-now.getDate()));
			else 
				return new Date(now.getYear(), now.getMonth()-1, Ngay.getSoNgayTrongThang(now.getMonth(), now.getYear()+1900)-(7-now.getDate()));
		}else {
			return new Date(now.getYear(), now.getMonth(), now.getDate()-7);
		}
			
	}
	
	public static Date _1ThangQua() {	
		if(now.getMonth() == 0)
			return new Date(now.getYear()-1, 12, now.getDate());
		else 
			return new Date(now.getYear(), now.getMonth()-1, now.getDate());
	}
	
	public static Date _1NamQua() {	
		return new Date(now.getYear()-1, now.getMonth(), now.getDate());
		
	}
	
	public static int getSoNgayTrongThang(int m, int y) {
		 if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			 return 31;
		 else if(m == 4 || m == 6 || m == 9 || m == 11)
			 return 30;
		 else if(y % 400 == 0 || (y % 100 == 0 && y % 4 != 0))
			 return 29;
		 else return 29;
	}
	
	public static long tinhKhoangNgay(Date d1, Date d2) {
		return (long) (d2.getTime() - d1.getTime()) / 86400000 + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(Ngay._1ThangQua());
	}
}
