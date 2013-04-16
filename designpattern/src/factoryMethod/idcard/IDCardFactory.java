package factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

/**
 * Factory抽象クラスを継承したIDカード工場具象クラス
 * @author urushibata
 * @version 1.0
 */
public class IDCardFactory extends Factory{
	private List<String> owners = new ArrayList<String>();

	/**
	 * {@inheritDoc} 
	 */
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	/**
	 * {@inheritDoc} 
	 * @since 1.0
	 */
	@Override
	protected void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}

	/**
	 * @return List<String>
	 * @since 1.0
	 */
	public List<String> getOwners(){
		return owners;
	}
}
