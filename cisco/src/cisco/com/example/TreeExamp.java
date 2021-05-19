package cisco.com.example;

public class TreeExamp {
	
	private static class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}
	public static int isPresent(Node root, int val){
	if(root == null){
		 return 0;
	 }
		return isPresentUtil(root,val);
}
	public static int isPresentUtil(Node root , int value){
		int val =0;
		if(root.data == value){
		    val= 1;
		}
		 val = val + isPresentUtil(root,0);
		 
		 return val;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
