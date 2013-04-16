package factoryMethod.framework;

/**
 * Factory抽象クラス<br />
 * 抽象クラスでは処理ロジックだけを書く。そのことで"製品を作ること"という関心事を定義する。
 * @author urushibata
 * @version 1.0
 */
public abstract class Factory{
	/**
	 * @param owner
	 * @return Product
	 * @since 1.0
	 */
	public final Product create(String owner){
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}

	/**
	 * Productインスタンス生成メソッド<br />
	 * ただし、インスタンス化する具体的なクラスは具象クラスに任せる。
	 * @param owner
	 * @return Product
	 */
	protected abstract Product createProduct(String owner);
	/**
	 * インスタンスのメンバ変数にデータを登録する。<br />
	 * ただし、登録する具体的な型、値は具象クラスに任せる。
	 * @param Product
	 * @since 1.0
	 */
	protected abstract void registerProduct(Product product);
}
