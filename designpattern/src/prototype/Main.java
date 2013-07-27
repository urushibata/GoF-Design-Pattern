package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

/**
 * @author urushibata
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("string message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);

		//生成
		Product p1 = manager.create("string message");
		p1.use("Hello world.");
		Product p2 = manager.create("warning box");
		p2.use("Hello world.");
		Product p3 = manager.create("slash box");
		p3.use("Hello world.");
	}
}