package payPal.Tree;

public class BST {
	
	
	private static boolean checkBSTUtil(TreeNode root,double min,double max) {
		
		if(root==null)
			return true;
		
		if(root.data>max || root.data<min) {
			return false;
		}
		
		return checkBSTUtil(root.left, min,root.data -1)
				&& checkBSTUtil(root.right, root.data +1,max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(0);
		//root.left = new TreeNode(Integer.MIN_VALUE);
		/*
		 * root.left = new TreeNode(Integer.MIN_VALUE); root.right = new TreeNode(5);
		 * root.left.left = new TreeNode(1); root.left.right = new TreeNode(3);
		 */
        
        System.out.println(checkBSTUtil(root,-Double.MAX_VALUE,Double.MAX_VALUE));

	}

}
