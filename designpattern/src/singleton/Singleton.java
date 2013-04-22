package singleton;

/**
 * シングルトンクラス<br />
 * @author urushibata
 * @version 1.0
 */
public class Singleton {
	/**
	 * クラス変数singleton<br />
	 * メモリ割り当ては初めてアクセスされたときのみ。
	 * @since 1.0
	 */
	private static final Singleton singleton = new Singleton();
	/**
	 * コンストラクタ<br />
	 * privateで宣言されているため、このクラス以外からはインスタンスを作成することができない。
	 * @since 1.0
	 */
	private Singleton(){
		System.out.println("インスタンスを作成しました。");
	}

	/**
	 * Singletonインスタンスを返すstaticメソッド。
	 * @return singleton
	 * @since 1.0
	 */
	public static Singleton getInstance(){
		return singleton;
	}
}