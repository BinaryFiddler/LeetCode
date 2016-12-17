import java.util.*;
//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
//
//Examples: 
//[2,3,4] , the median is 3
//
//[2,3], the median is (2 + 3) / 2 = 2.5
//
//Design a data structure that supports the following two operations:
//
//void addNum(int num) - Add a integer number from the data stream to the data structure.
//double findMedian() - Return the median of all elements so far.
//For example:
//
//add(1)
//add(2)
//findMedian() -> 1.5
//add(3) 
//findMedian() -> 2
public class Q295 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MedianFinder {
	int minSize = 0;
	int maxSize = 0;
	
	Queue<Integer> minQ = new PriorityQueue<>();
	Queue<Integer> maxQ = new PriorityQueue<>(1, new Comparator<Integer>(){
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if(o1 > o2)
				return -1;
			if(o1 < o2)
				return 1;
			return 0;
		}  	
    });
	
    // Adds a number into the data structure.
    public void addNum(int num) {
       if(minSize == 0 && maxSize == 0){
    	   minQ.offer(num);
    	   minSize++;
       }
       else if(minSize > maxSize){
    	   if(num > minQ.peek()){
    		   maxQ.offer(minQ.poll());
    		   minQ.offer(num);
    	   }else
    		   maxQ.offer(num);
    	   maxSize++; 
       }
       else if(minSize < maxSize){
    	   if(num < maxQ.peek()){
    		   minQ.offer(maxQ.poll());
    		   maxQ.offer(num);
    	   }else
    		   minQ.offer(num);
    	   minSize++;
       }
       else{
    	   if(num > minQ.peek()){
    		   minQ.offer(num);
    		   minSize++;
    	   }
    	   else{
    		   maxQ.offer(num);
    		   maxSize++;
    	   }   
       }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minSize == 0 && maxSize == 0)
        	return 0;
        else if(minSize == maxSize)
        	return ((double)minQ.peek() + (double)maxQ.peek()) / 2;
        else if(minSize > maxSize)
        	return (double)minQ.peek();
        else
        	return (double)maxQ.peek();
    }
};