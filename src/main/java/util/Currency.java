package util;

import java.text.DecimalFormat;

public class Currency {
	private String currency;
	
	public Currency(long a) {
		currency = new DecimalFormat("###,###,###").format(a)+" VNĐ";
	}
	
	public Currency(double a) {
		currency = new DecimalFormat("###,###,###").format(a)+" VNĐ";
	}
	
	public Currency(float a) {
		currency = new DecimalFormat("###,###,###").format(a)+" VNĐ";
	}
	
	public Currency(String a) {
		currency = new DecimalFormat("###,###,###").format(a)+" VNĐ";
	}
	
	@Override
	public String toString() {
		return currency;
	}
}
