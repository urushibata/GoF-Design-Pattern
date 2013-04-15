package factoryMethod;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;
import factoryMethod.idcard.IDCardFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("åãèÈç_");
		Product card2 = factory.create("éΩî®ê^ñÁ");
		Product card3 = factory.create("âHê∂ëPé°");
		card1.use();
		card2.use();
		card3.use();
	}

}
