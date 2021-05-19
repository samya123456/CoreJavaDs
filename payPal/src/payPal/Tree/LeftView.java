package payPal.Tree;

public class LeftView {
	
	
	static int max_level =0;
	public static void printLeftView(TreeNode root,int level) {
		
		if(root==null)
			return;
		if(max_level<level) {
			System.out.println(root.data);
			max_level = level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
		
			
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
	       root.left = new TreeNode(10);
	       root.right = new TreeNode(30);
	       root.right.left = new TreeNode(25);
	       root.right.right = new TreeNode(40);
	       printLeftView(root,1);
	       

	}

}
