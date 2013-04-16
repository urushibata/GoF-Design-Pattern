package factoryMethod.framework;

/**
 * Procuct抽象クラス<br />
 * そのことで"製品を使うこと"という関心事を定義する。
 * @author urushibata
 * @version 1.0
 */
public abstract class Product{
	/**
	 * 製品を使うメソッド<br />
	 * 何をどう使うのかは具象クラスに任せる。
	 * since 1.0
	 */
	public abstract void use();
}
