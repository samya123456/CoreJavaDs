package payPal;

public class FinonacciSeries {
	
	static void fib(int n) {
		int[] f = new int[n+2];
		f[0] =0;
		f[1] =1;
		for(int i=2;i<n;i++) {
			f[i] = f[i-1] +f[i-2];
			System.out.println(f[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib(10);

	}

}
