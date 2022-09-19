package payPal.Tree;

public class BST {
	
	
	private static boolean checkBSTUtil(TreeNode root,long min,long max) {
		
		if(root == null){
            return true;
        }
        
        if (root.data < max && root.data > min ){
            
           return checkBSTUtil(root.left, min, root.data) && 
        		   checkBSTUtil(root.right,root.data, max);
        }
        
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(0);
		//root.left = new TreeNode(Integer.MIN_VALUE);
		/*
		 * root.left = new TreeNode(Integer.MIN_VALUE); root.right = new TreeNode(5);
		 * root.left.left = new TreeNode(1); root.left.right = new TreeNode(3);
		 */
        
        System.out.println(checkBSTUtil(root,Long.MIN_VALUE,Long.MAX_VALUE));

	}

}
