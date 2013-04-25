package adapter;

/**
 * 既に提供されているBannerクラス
 * @author urushibata
 * @version 1.0
 */
public class Banner {
	private String string;

	/**
	 * コンストラクタ
	 * @param string
	 * @since 1.0
	 */
	public Banner(String string){
		this.string = string;
	}

	/**
	 * 括弧で文字列を囲む。
	 * @since 1.0
	 */
	public void showWithParen(){
		System.out.println("(" + string + ")");
	}

	/**
	 * "*"で文字列を囲む。
	 * @since 1.0
	 */
	public void showWithAster(){
		System.out.println("*" + string + "*");
	}
}