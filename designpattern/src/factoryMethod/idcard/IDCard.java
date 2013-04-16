package factoryMethod.idcard;

import factoryMethod.framework.Product;

/**
 * Product抽象クラスを継承したIDカード具象クラス
 * @author urushibata
 * @version 1.0
 */
public class IDCard extends Product{
	private String owner;

	/**
	 * @param owner
	 * @since 1.0
	 */
	public IDCard(String owner){
		System.out.println(owner + "のカードを作ります。");
		this.owner = owner;
	}

	/**
	 * {@inheritDoc} 
	 * @since 1.0
	 */
	@Override
	public void use() {
		System.out.println(owner + "のカードを使います。");
	}

	/**
	 * @return String
	 * @since 1.0
	 */
	public String getOwner(){
		return this.owner;
	}
}