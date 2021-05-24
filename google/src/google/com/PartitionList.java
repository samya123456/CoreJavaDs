package google.com;

public class PartitionList {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	
	public ListNode partition(ListNode head, int x) {
        ListNode secondPart =null;
        ListNode temp2 = null;
        ListNode firstPart=null;
        ListNode temp1=null;
        ListNode temp = head;
        
       while(temp!=null){
            if(temp.val<x){
                if(firstPart==null){
                    firstPart = new ListNode(temp.val);
                    temp1 = firstPart;
                }else{
                    firstPart.next = new ListNode(temp.val);
                    firstPart = firstPart.next;
                }
            }else if(temp.val>=x) {
            	if( secondPart==null){
            		secondPart = new ListNode(temp.val);
            		temp2 = secondPart;
            }else{
            	secondPart.next = new ListNode(temp.val);
            	secondPart = secondPart.next;
            }}
            
            temp = temp.next;
        }
        
        if(firstPart!=null){
            firstPart.next = temp2; 
        }
       
        return temp1;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		new PartitionList().partition(head, 3);

	}

}
