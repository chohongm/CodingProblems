package code;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public static String zigZagConversion(String s, int n) {
		
		if (n == 1) return s;
		
		List<StringBuilder> rs = new ArrayList<>();
		for (int i = 0; i < Math.min(n, s.length()); i++) 
			rs.add(new StringBuilder());
		
		int d = -1;
		int row = 0;
		for (char c : s.toCharArray()) {
			rs.get(row).append(c);
			if (row == 0 || row == n - 1) {
				d *= -1;
			}
			row += d;
		}

		StringBuilder ans = new StringBuilder();
		for (StringBuilder sb : rs) {
			ans.append(sb);
		}
		
		return ans.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(zigZagConversion("PAYPALISHIRING", 3));
	}

}
