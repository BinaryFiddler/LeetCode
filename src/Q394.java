import java.util.*;

//Given an encoded string, return it's decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//Examples:
//
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".


public class Q394 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	
	
	public static String decodeString(String s) {
		Deque<String> de = new ArrayDeque<>();
		StringBuilder res = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == ']')
				decodeSubstring(de);
			else
				de.offer(Character.toString(s.charAt(i)));
		}
		
		while(!de.isEmpty()){
			res.append(de.pollLast());
		}
		
		return res.reverse().toString();
		
	}
	
	static void decodeSubstring(Deque<String> de) {
		StringBuilder substring = new StringBuilder();
		int repetition = 0;
		int base = 1;
		
		while(!de.isEmpty() && de.peekLast().charAt(0) != '['){
			substring.append(de.pollLast());
		}
		de.pollLast();
		while(!de.isEmpty() && Character.isDigit(de.peekLast().charAt(0))){
			repetition += Character.getNumericValue(de.pollLast().charAt(0)) * base;
			base *= 10;
		}
		
		String baseStr = substring.toString();
		
		for(int i=1; i<repetition; i++){
			substring.append(baseStr);
		}
		
		de.offer(substring.toString());
		
	}
	
	

}
