package adapter.inheritance;

import adapter.Banner;

/**
 * @author urushibata
 * @version 1.0
 */
public class PrintBanner extends Banner implements Print{
	/**
	 * @param string
	 * @since 1.0
	 */
	public PrintBanner(String string){
		super(string);
	}

	/**
	 * @since 1.0
	 */
	@Override
	public void printWeak() {
		showWithParen();
	}

	/**
	 * @since 1.0
	 */
	@Override
	public void printString() {
		showWithAster();
	}
}