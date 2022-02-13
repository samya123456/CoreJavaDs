
public class GenerateParenthesis {
	
	 public static void genPar(int n ) {
		 genParUtil("",0,0,n);
	 }

	private static void genParUtil(String current_string, int open, int close, int max) {
		if(current_string.length()==max*2) {
			System.out.println(current_string);
			return;
		}
		if(open<max)genParUtil(current_string+"(",open+1,close,max);
		if(close<open)genParUtil(current_string+")",open,close+1,max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		genPar(3);

	}

}
