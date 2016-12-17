//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//Example:
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//Note:
//You may assume that the array does not change.
//There are many calls to sumRange function.

public class Q303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


class NumArray {
    int[] sum;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        if(nums.length == 0){
            sum = new int[1]; 
            sum[0] = 0;
        }
        else{
            sum = new int[nums.length];
            sum[0] = nums[0];
        }
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}