package code;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "a##c", T = "#a#c";
		System.out.println(backspaceCompare(S, T));
	}
	
    public static boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    
    public static String helper(String S) {
    	Stack<Character> s = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
            	if (!s.isEmpty()) s.pop();
                
            } else {
                s.push(c);
            }
        }
        return String.valueOf(s);
    }

}
