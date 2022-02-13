
public class RotateList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		   if(head==null|| k==0){
	            return head;
	        }
	        
	        int len = length(head);
	        ListNode temp = head;
	        
	        while(temp.next!=null){
	            temp = temp.next;
	        }
	        temp.next = head;
	        temp =temp.next;
	        k = k%len;
	        k = len -k;
	        ListNode prev = null;
	        
	        while(k>0){
	           prev = temp;
	           temp = temp.next; 
	            k--;
	        }
	        prev.next =null;
	        return temp;
	}
	
	private static int length(ListNode head){
        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);
		

		rotateRight(n1, 2);

	}

}
