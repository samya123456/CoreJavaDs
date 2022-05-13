package com.ds;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeExample {
	
	static class Node {
		Node left;
		Node right;
		Node next;
		int data;
		int hd;
		Node(int data){
			this.data =data;
			left =right=next=null;
			 hd =Integer.MAX_VALUE;
		
		}
	}
	
	static int MAX_LEVEL =0;
	public static void printLeftView(Node root,int level) {
		if (root==null) {
			return;
		}
		if(MAX_LEVEL<level) {
			System.out.println(root.data);
			MAX_LEVEL =level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
	}
	
	public static void printLeftViewUsingQueue(Node root) {
		if (root==null) {
			return ;
			
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			for(int i=0;i<n;i++) {
				Node temp = q.poll();
				if(i==0) {
					System.out.println(temp.data);
				}
				if(root.left!=null) {
					q.add(root.left);
				}
				if(root.right!=null) {
					q.add(root.right);
				}
				
			}
			
		}
	}
	
	public static boolean checkForBSTUtil(Node root,int max,int min) {
		if(root==null) {
			return true;
		}
		
		if(root.data<min || root.data>max) {
			return false;
		}
		
		return checkForBSTUtil(root.left ,min,root.data-1) && 
				checkForBSTUtil(root.left ,root.data+1,max);
	}
	
	public static  void buttomView(Node root) {
		if(root==null) {
			return ;
		}
		
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Queue<Node> q = new LinkedList<Node>();
		int hd =0;
		root.hd =hd;
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp  =q.poll();
			hd = temp.hd;
			map.put(hd, temp.data);
			
			if(temp.left!=null) {
				temp.left.hd =hd-1;
				q.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.hd =hd+1;
				q.add(temp.right);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	
	public static Node connectNextPointerToRight(Node root) {
		if(root==null) {
			return root;
		}
		Node current = root;
		while(current.left!=null) {
			Node temp = current;
			while(current.next!=null) {
				current.left.next = current.right;
				current.right.next = current.next ==null?null: current.next.left;
				current =current.next;
			}
			
			current =temp.left;
		}
		
		return root;
	}
	
	public static void verticalOrder(Node root) {
		
		if(root==null) {
			return;
		}
		Map<Integer ,List<Integer>> map = new TreeMap<>();
		Queue<Node> q =new LinkedList<Node>();
		int hd =0;
		
		root.hd = hd;
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			hd = temp.hd;
			
			if(map.containsKey(hd)) {
				List<Integer> tempList = map.get(hd);
				tempList.add(temp.data);
				map.put(hd, new ArrayList<Integer>(tempList));
			}else {
				List<Integer> tempList = new ArrayList<Integer>();
				tempList.add(temp.data);
				map.put(hd, new ArrayList<Integer>(tempList));
			}
			
			if(temp.left!=null) {
				temp.left.hd =hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd =hd+1;
				q.add(temp.right);
			}
		}
		
		for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			int n =entry.getValue().size();
			List<Integer> temp = entry.getValue();
			for(int i=0;i<n;i++) {
				System.out.print(temp.get(i)+" ");
			}
			System.out.println();
		}
	}
	
	public static void levelOrderInSpyralForm(Node root) {
		if (root==null) {
			return ;
		}
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.add(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node temp =s1.pop();
				System.out.println(temp.data);
				if(temp.right!=null) {
					s2.add(temp.right);
				}
				
				if(temp.left!=null) {
					s2.add(temp.left);
				}
			}
			
			while(!s2.isEmpty()) {
				Node temp =s2.pop();
				System.out.println(temp.data);
				if(temp.left!=null) {
					s1.add(temp.left);
				}
				if(temp.right!=null) {
					s1.add(temp.right);
				}
				
				
			}
		}
	}
	
	
	public static int findDistanceBetwnNodes(Node root,int n1,int n2) {
		
		Node lca = findLCA(root,n1,n2);
		int d1 = findLevel(lca,n1,0);
		int d2 = findLevel(lca,n2,0);
		
		return d1 + d2;
	}

	private static int findLevel(Node lca, int n1,int level) {
		if(lca==null) {
			return -1;
		}
		if(lca.data ==n1) {
			return level;
		}
		
		int left  =findLevel( lca.left,  n1, level+1);
		if(left ==-1) {
			return findLevel( lca.right,  n1, level+1);
		}
		return left;
	}

	private static Node findLCA(Node root, int n1, int n2) {
		
		if(root ==null) {
			return null;
		}
		
		if(root.data ==n1 || root.data ==n2) {
			return root;
		}
		Node left = findLCA(root.left,n1,n2);
		Node right = findLCA(root.right,n1,n2);
		
		if(left!=null && right!=null) {
			return root;
		}
		
		if(left==null || right==null) {
			return null;
		}
		
		if(left!=null) {
			return findLCA(root.left,n1,n2);
		}else {
			return findLCA(root.right,n1,n2);
		}
		
		
		
	}
	static class Res{
		int val;
		
		
	}
	
	public static int maxPathSum(Node root,Res res) {
		if(root==null) {
			return -1;
		}
		
		int left  = maxPathSum(root.left,res);
		int right = maxPathSum(root.right,res);
		
		int max_single = Math.max(Math.max(left, right)+root.data, root.data);
		int max_top   = Math.max(max_single, left+right+root.data);
		
		res.val = Math.max(max_top, res.val);
		return max_single;
 	}
	
	
	public static int diameter(Node root) {
		if (root==null) {
			return -1;
		}
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		int ldia = diameter(root.left);
		int rdia = diameter(root.right);
		
		return Math.max(lHeight+rHeight+1, Math.max(ldia, rdia));
	}

	private static int height(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+ Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		 Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	       
	      
	       System.out.println( diameter(root));
	       
	}

}
