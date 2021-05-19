package cisco.com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeEx {
	
	private int max_level=0;
	
	private Map<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
	public void printLeftViewOfTree(NodeT head) {
		
		printLeftViewOfTreeUtil(head,1);
		
		
	}
	
	public void printLeftViewOfTreeUtil(NodeT head,int level) {
		if(head==null) {
			return;
		}
		
		if(max_level<level) {
			System.out.println(head.data);
			max_level=level;
		}
		printLeftViewOfTreeUtil(head.left,level+1);
		printLeftViewOfTreeUtil(head.right,level+1);
		
	}
	
	
	public boolean isBST(NodeT root) {
		return isBSTUtils(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean isBSTUtils(NodeT root,int min, int max) {
		if(root==null) {
			return true;
		}
		
		if(root.data<min || root.data>max) {
			return false;
		}
		
		return (isBSTUtils(root.left,min,root.data-1) && isBSTUtils(root.right,root.data+1,max)); 
		
	}
	
	public void verticleOrder(NodeT root) {
		
		verticleOrderUtil(root,0);
		
		Set<Map.Entry<Integer,List<Integer>>> st = map.entrySet();
		
		for(Map.Entry<Integer,List<Integer>> entry:st) {
			List<Integer> temp = entry.getValue();
			for(int i=0;i<temp.size();i++) {
				System.out.println(temp.get(i));
			}
		}
		
		
		
	}
	
	public void verticleOrderUtil(NodeT root,int hd) {
		if (root==null)
			return;
		if(map.get(hd)==null) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(root.data);
			map.put(hd, temp);
		}else {
			List<Integer> temp = map.get(hd);
			temp.add(root.data);
			map.put(hd, temp);
		}
		
		verticleOrderUtil(root.left,hd-1);
		verticleOrderUtil(root.right,hd+1);
	}
	
	
	int diameter(NodeT root) {
		
		if(root==null) {
			return 0;
		}
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		int rDia = diameter(root.right);
		int lDia = diameter(root.left);
		
		return Math.max(lHeight+rHeight+1, Math.max(rDia,lDia));
		
	}
	
	int height(NodeT root) {
		if(root==null) {
			return 0;
		}
		
		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	
	public void inOrder(NodeT root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public void postOrder(NodeT root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
		
	}

	public void preOrder(NodeT root) {
		if(root==null)
			return;
		
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}


	public static void main(String[] args) {
		/*NodeT root = new NodeT(1);
        root.left = new NodeT(2);
        root.right = new NodeT(3);
        root.left.left = new NodeT(4);
        root.left.right = new NodeT(5);
        root.right.right = new NodeT(6);
        
		NodeT root = new NodeT(1);
        root.left = new NodeT(2);
        root.right = new NodeT(3);
        root.left.left = new NodeT(4);
        root.left.right = new NodeT(5);
        root.right.left = new NodeT(6);
        root.right.right = new NodeT(7);
        root.right.left.right = new NodeT(8);
        root.right.right.right = new NodeT(9);*/
		
		NodeT root = new NodeT(1);
        root.left = new NodeT(2);
        root.right = new NodeT(3);
        root.left.left = new NodeT(4);
        root.left.right = new NodeT(5);
 
        System.out.println(
            "Preorder traversal of binary tree is ");
        new TreeEx().preOrder(root);
 
        System.out.println(
            "\nInorder traversal of binary tree is ");
        new TreeEx().inOrder(root);
 
        System.out.println(
            "\nPostorder traversal of binary tree is ");
        new TreeEx().postOrder(root);
       
        
      

	}

}
