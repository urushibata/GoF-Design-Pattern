package factoryMethod;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;
import factoryMethod.idcard.IDCardFactory;

/**
 * factoryMethodパターンメインクラス<br />
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * メイン処理
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args) {
		// IDCardFactoryクラス生成
		Factory factory = new IDCardFactory();

		// 各引数の人物のIDカードを作成する。
		Product card1 = factory.create("結城浩");
		Product card2 = factory.create("漆畑真也");
		Product card3 = factory.create("羽生善治");

		// カードを使用する。
		card1.use();
		card2.use();
		card3.use();
	}
}