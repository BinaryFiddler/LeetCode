import java.util.*;

//lengthOfLongestSubstring
//Given a string, find the length of the longest substring without repeating characters.
//
//Examples:
//
//Given "abcabcbb", the answer is "abc", which the length is 3.
//
//Given "bbbbb", the answer is "b", with the length of 1.
//
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("au");
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		
		for(int i=0, j=0; i<s.length(); i++){
			char key = s.charAt(i);
			if(map.containsKey(key)){
				j = Math.max(j, map.get(key));
			}
			maxLength = Math.max(maxLength, i - j + 1);
			map.put(key, i + 1);
		}
		
		return maxLength;
    }
}
