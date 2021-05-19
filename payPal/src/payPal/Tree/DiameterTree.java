package payPal.Tree;

public class DiameterTree {
	
	
	public static int diameterTree(TreeNode root) {
		if (root==null) return 0;
		
		int lHeight = height(root.left);
		int rheight = height(root.right);
		
		int ldia = diameterTree(root.left);
		int rdia = diameterTree(root.right);
		
		return Math.max(lHeight + rheight+1, Math.max(ldia, rdia));
	}

	private static int height(TreeNode root) {
		// TODO Auto-generated method stub
		if (root==null)
			return 0;
		return 1+ Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println(diameterTree(root));

	}

}
