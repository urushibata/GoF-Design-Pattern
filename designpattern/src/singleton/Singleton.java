package singleton;

/**
 * @author urushibata
 * @version 1.0
 */
public class Singleton {
	/**
	 * クラス変数singleton
	 */
	private static Singleton singleton = new Singleton();
	/**
	 * コンストラクタ<br />
	 * privateで宣言されているため、このクラス以外からはインスタンスを作成することができない。
	 */
	private Singleton(){
		System.out.println("インスタンスを作成しました。");
	}

	/**
	 * Singletonインスタンスを作成する。
	 * @return singleton
	 * @since 1.0
	 */
	public static Singleton getInstance(){
		return singleton;
	}
}