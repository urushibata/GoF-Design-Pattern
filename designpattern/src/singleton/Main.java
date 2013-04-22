package singleton;

/**
 * Singletonパターンメインクラス<br />
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
			// Singletonクラスはシステム内で必ず一つの為、同じクラスへの参照しか持てない。（注:インスタンスではない）
			System.out.println("obj1とobj2は同じインスタンスです。");
		}else{
			System.out.println("obj1とobj2は同じインスタンスではありません。");
		}
		System.out.println("End.");
	}
}