
public class Singleton {

	private static Singleton instance;

	private Singleton() {

	}
	
	public static synchronized Singleton getInstance() {
		{
			if(instance==null) {
				instance = new Singleton();
			}
		}
	
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
