package adapter;

/**
 * Adapterパターンメインクラス
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args){
		// 継承パターンも委譲パターンも結果は同じ
		// 継承パターン
		adapter.inheritance.Print p2 = new adapter.inheritance.PrintBanner("Hello");
		p2.printWeak();
		p2.printString();

		// 委譲パターン
		adapter.transfer.Print p1 = new adapter.transfer.PrintBanner("Hello");
		p1.printWeak();
		p1.printString();
	}
}