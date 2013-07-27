package adapter.transfer;

import adapter.Banner;

/**
 * @author urushibata
 * @version 1.0
 */
public class PrintBanner extends Print{
	private Banner banner;
	/**
	 * @param string
	 * @since 1.0
	 */
	public PrintBanner(String string){
		this.banner = new Banner(string);
	}

	/**
	 * @since 1.0
	 */
	@Override
	public void printWeak(){
		banner.showWithParen();
	}

	/**
	 * @since 1.0
	 */
	@Override
	public void printString(){
		banner.showWithAster();
	}
}