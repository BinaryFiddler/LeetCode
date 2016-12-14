import java.util.*;

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
			maxLength = Math.max(maxLength, i - j);
			map.put(key, i);
		}
		
		return maxLength;
    }
}
