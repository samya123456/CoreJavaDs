package com.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class Dp2 {
	
	static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data =data;
		}
	}
	
	public static int minSwapToSortArray(int arr[]) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		
		
		Arrays.sort(arr);
		
		
		boolean[] visited = new boolean[arr.length];
		int ans =0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(map.get(arr[i])==i || visited[i]) {
				continue;
			}
			
			int j=i;
			int swaps =0;
			while(!visited[j]) {
				visited[j] =true;
				j =map.get(arr[j]);
				
				swaps++;
			}
			
			if(swaps>0) {
				ans+=(swaps-1);
			}
			
		}
		
		return ans;
	}
	
	
	public static int inversionArray(int[] arr) {
		int left =0;
		int right = arr.length -1;
		
		return mergeSortNCount(left,right,arr);
	}

	private static int mergeSortNCount(int left, int right, int[] arr) {
		int count =0;
		int mid =left +(right-left)/2;
		if(left<right) {
		count+=mergeSortNCount(left,mid,arr);
		count+=mergeSortNCount(mid+1,right,arr);
		count+=mergeNCount(left,mid,right,arr);
		}
		return count;
		
		
	}


	private static int mergeNCount(int left, int mid, int right, int[] arr) {
		
		int [] leftArray = Arrays.copyOfRange(arr, left,mid+1);
		int [] rightArray = Arrays.copyOfRange(arr, mid+1, right+1);
		int swaps =0;
		int i =0;
		int j =0;
		int k =left;
		 
		while(i<leftArray.length && j<rightArray.length) {
			if(leftArray[i]<rightArray[j]) {
				arr[k++] = leftArray[i++];
			}else {
				arr[k++] = rightArray[j++];
				swaps += (mid+1) - (i+left);
			}
		}
		
		while(i<leftArray.length) {
			arr[k++] = leftArray[i++];
		}
		while(j<rightArray.length) {
			arr[k++] = rightArray[j++];
		}
		
		return swaps;
		
	}
	
	
	public static void permutationsNumber(int[] arr) {
		
		for(int m=1;m< 1<<arr.length;m++) {
			for(int i=0;i<arr.length;i++) {
				if((m & 1<<i )!=0) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
	}

	public static void deleteNodeWOHead(Node nodeTobeDeleted) {
		Node next = nodeTobeDeleted.next;
		nodeTobeDeleted.data = next.data;
		nodeTobeDeleted.next = next.next;
	}
	
	public static  Node getMiddle(Node head) {
		
		if(head==null) {
			return head;
		}
		
		Node fast = head;
		Node slow = head;
	
		
		while(fast.next!=null && fast.next.next!=null) {
			fast =fast.next.next;
			slow = slow.next;
		}
		
		return slow;
		
	}
	private static Node mergeTwoSortedLinkedList(Node node1, Node node2) {
		
		if(node1==null) {
			return node2;
		}
		
		if(node2==null) {
			return node1;
		}
		
		if(node1.data<node2.data) {
			node1.next = mergeTwoSortedLinkedList(node1.next,node2);
			return node1;
		}else {
			node2.next = mergeTwoSortedLinkedList(node1,node2.next);
			return node2;
		}
		
	}

	public static Node mergeSort(Node head) {
		
		
		if(head ==null || head.next ==null) {
			return head;
		}
		
		Node middle  = getMiddle(head);
		Node middleToNext = middle.next;
		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(middleToNext);
		Node sortedList = mergeTwoSortedLinkedList(left,right);
		return sortedList;
		
				
	}

	public static void main(String[] args) {
		 Node head = new Node(1);
		 head.next = new Node(2);
		 head.next.next = new Node(8);
		 head.next.next.next = new Node(4);
		 head =mergeSort(head);
		
		while(head!=null) {
			System.out.println(head.data);
			head =head.next;
		}

	}

}
