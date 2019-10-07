package code;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validParenthesis("(({([])}()){[()]})"));
	}
	
	public static boolean validParenthesis(String s) {
        
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stk.isEmpty()) {
                    return false;
                }
                char last = stk.pop();
                if (c == ')' && last != '(') {
                    return false;
                } else if (c == ']' && last != '[') {
                    return false;
                } else if (c == '}' && last != '{')
                    return false;
            } else {
                stk.push(c);
            }
        }
        if (stk.isEmpty()) {
            return true;
        }
        return false;
	}

}
