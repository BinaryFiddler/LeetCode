import java.util.*;
//Two sum
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution.

public class Q1 {
	public static void main(String[] args) {
		int[] a = {2, 7, 11, 15};
		int k = 9;
		
		System.out.print(Arrays.toString(twoSum(a, k)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
        	if(map.containsKey(target-nums[i]))
        		return new int[] {map.get(target-nums[i]), i};
        	map.put(nums[i], i);
        }
        
        return new int[] {-1, -1};
        
    }
}
