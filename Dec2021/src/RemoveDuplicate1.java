import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicate1 {

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

	public static ListNode deleteDuplicates(ListNode head) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.val);
		
		ListNode temp = head;
		ListNode next = head.next;
		while (next != null) {
			if (set.contains(next.val)) {
				temp.next = next.next;
			}else {
				set.add(next.val);
				temp =temp.next;
			}
			next =next.next;
		}
		return head;

	}
	
	public static ListNode deleteDuplicates2(ListNode head) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		ListNode temp = head;
		
		while(temp!=null) {
			map.put(temp.val, map.getOrDefault(temp.val, 0)+1);
			temp=temp.next;
			
		}
		ListNode temp1 =null;
		ListNode root =null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1) {
				if (root == null) {
					root = new ListNode(entry.getKey());
					temp1 = root;
				}else {
					root.next = new ListNode(entry.getKey());
					root = root.next;
				}
			}
		}
		return temp1;
	}

	

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(4);
		//deleteDuplicates(head);
		deleteDuplicates2(head);

	}

}
