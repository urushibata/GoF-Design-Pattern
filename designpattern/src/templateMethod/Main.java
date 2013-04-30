package templateMethod;

/**
 * TemplateMethodパターンメインクラス<br />
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, World.");
		AbstractDisplay d3 = new StringDisplay("こんにちは。");
		
		d1.display();
		d2.display();
		d3.display();
	}
}
