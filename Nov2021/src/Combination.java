
public class Combination {

	public static void combination(String input, String ros, int length,int size,int x) {
		if (ros.length() == size) {
			System.out.println(ros);
			ros ="";
			x++;
			if(x==length) {
				size++;
				x=0;
				return;
			}
			
		}

		for (int i = 0; i < length; i++) {
			char ch = input.charAt(i);
			String newIp = input.substring(0,i) + input.substring(i+1);
			ros = ros +ch;
			combination(newIp,ros,length,size,x);
		}
		
		
	}

	public static void main(String[] args) {
		
		combination("ABC","",3,1,0);

	}

}
