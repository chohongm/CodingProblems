package code;
import java.util.HashSet;
import java.util.Set;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));

	}
	
	public static Set<String> generateParenthesis(int n) {
		
    	Set<String> set = new HashSet<>();

        if (n == 1) {
        	set.add("()");
            return set;
        }
        
        for (int i = 0; i < n; i++) {
            for (String s : generateParenthesis(n - 1)) {
                String ns = s.substring(0, i) + "()" + s.substring(i);
                set.add(ns);
            }
        }
        
        return set;
    }

}
