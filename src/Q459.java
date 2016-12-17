//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//Example 1:
//Input: "abab"
//
//Output: True
//
//Explanation: It's the substring "ab" twice.
//Example 2:
//Input: "aba"
//
//Output: False
//Example 3:
//Input: "abcabcabcabc"
//
//Output: True
//
//Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

public class Q459 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("abcabcabc"));
	}
	
	public static boolean repeatedSubstringPattern(String str) {
        int n = str.length();
		
		for(int divisor = n / 2; divisor >= 1; divisor--){
        	if(n % divisor == 0 && check(str, divisor))
        		return true;
        }
		
		return false;
    }
	
	static boolean check(String s, int divisor){
		String sub = s.substring(0, divisor);
		for(int i = divisor; i < s.length(); i = i + divisor){
			if(!sub.equals(s.substring(i, i+divisor)))
				return false;
		}
		return true;
	}
	
}
