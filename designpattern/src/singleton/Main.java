package singleton;

/**
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args) {
		System.out.println("Start.");
		// Singletonクラス生成
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		if(obj1.equals(obj2)){
			System.out.println("obj1とobj2は同じインスタンスです。");
		}else{
			System.out.println("obj1とobj2は同じインスタンスではありません。");
		}
		System.out.println("End.");
	}
}