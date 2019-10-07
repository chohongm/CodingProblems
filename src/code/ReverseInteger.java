package code;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseInt(120));
		System.out.println(reverseInt(-321));

	}
	
	public static int reverseInt(int x) {
		
		int r = 0;
		while(x != 0) {
			int last = x % 10;
			x /= 10;
			if (r > Integer.MAX_VALUE / 10 || r == Integer.MAX_VALUE / 10 && last > 7) return 0;
			if (r < Integer.MIN_VALUE / 10 || r == Integer.MIN_VALUE / 10 && last < -8) return 0;
			r = r * 10 + last;
		}
		
		return r;
	}
}
