//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode prev = current;
        ListNode nextNode = new ListNode(0);
        int carry = 0;
        
        while(l1 != null || l2 != null){
        	
        	
        	int v1 = (l1 != null) ? l1.val : 0;
        	int v2 = (l2 != null) ? l2.val : 0;
        	if(v1 + v2 + carry < 10){
        		current.val = v1 + v2 + carry;
        		carry = 0;
        	}
        	else{
        		current.val = v1 + v2 + carry - 10;
        		carry = 1;
        	}
        	
        	l1 = l1 != null ? l1.next : null;
        	l2 = l2 != null ? l2.next : null;
        	
        	current.next = nextNode;
        	prev = current;
        	current = nextNode;
        	nextNode = new ListNode(0);
        }
        
        if(carry == 0)
        	prev.next = null;
        else
        	current.val = 1;
        return result;
        
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}