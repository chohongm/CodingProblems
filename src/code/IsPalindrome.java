package code;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-121));

	}
	
	public static boolean isPalindrome(int x) {
		
		if (x < 0) return false;
		
		int rev = 0;
		int cpy = x;
        while (cpy != 0) {
            int last = cpy % 10;
            cpy /= 10;
            rev = rev * 10 + last;
        }
        
        return rev == x;
	}

}
