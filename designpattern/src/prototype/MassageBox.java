package prototype;

import prototype.framework.Product;

/**
 * @author urushibata
 * @version 1.0
 */
public class MassageBox implements Product{

	private char decochar;
	/**
	 * @param decochar
	 */
	public MassageBox(char decochar){
		this.decochar = decochar;
	}

	@Override
	public void use(String s) {
		
	}
	@Override
	public Product createClone() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}