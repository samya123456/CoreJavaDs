package com.ds;



public class StepByStepDirectionsFromBinaryTreeNodeAnother {
	
	StringBuilder startVal = new StringBuilder();
    StringBuilder destVal = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
         dfs(root,startValue,true);
         dfs(root,destValue,false);
        
        startVal.reverse();
        destVal.reverse();
        
        int i=0;
        int j=0;
        while(i<startVal.length() && j<destVal.length()){
            if(startVal.charAt(i)== destVal.charAt(j)){
                 i++;
                 j++;
            }else{
                break;
            }
           
        }
        StringBuffer br = new StringBuffer();
        while(i<startVal.length()){
            br.append("U");
            i++;
        }
        
        br.append(destVal.substring(j));
        return br.toString();
    }
    
    private boolean dfs(TreeNode root ,int value ,boolean start){
        
        if(root==null){
            return false;
        }
        if(root.val ==value){
            return true;
        }
        
        boolean left = dfs(root.left,value,start);
            if(left){
                if(start){
                    startVal.append("L");
                }else{
                    destVal.append("L");
                }
                
                return true;
            }
        boolean right = dfs(root.right,value,start); 
        if(right){
                if(start){
                    startVal.append("R");
                }else{
                    destVal.append("R");
                }
             return true;
            }
       return false;
    }
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
