package code;

public class MyAtoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("      -42"));
	}
	
    public static int myAtoi(String str) {
        int len = str.length();
        
        if (len == 0) {
            return 0;
        }
        
        str = str.trim();
        len = str.length();
        if (len == 0) {
            return 0;
        }
        
        int i = 0;
        int negSign = 1;
        if (str.charAt(i) == '-') {
            negSign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        if (i >= len) {
            return 0;
        }
        
        long res = 0;
        long maxCut = ((long) Integer.MAX_VALUE);
        long minCut = ((long) Integer.MIN_VALUE) * -1;
        for (int j = i; j < str.length(); j++) {
            if (!isDigit(str.charAt(j))) {
                break;
            }
            int cand = parseInt(str.charAt(j));
            res = res * 10 + parseInt(str.charAt(j));
            if (negSign == -1 && res >= minCut) {
                
                res = minCut;
            } else if (res >= maxCut) {
                res = maxCut;
            }
        }

        return negSign * ((int) res);
    }
    
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
    public static int parseInt(char c) {
        return c - '0';
    }

}
