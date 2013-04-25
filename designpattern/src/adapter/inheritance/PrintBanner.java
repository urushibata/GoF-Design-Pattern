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
	 * @param string
	 * @since 1.0
	 */
	@Override
	public void printWeak() {
		showWithParen();
	}

	/**
	 * @param string
	 * @since 1.0
	 */
	@Override
	public void printString() {
		showWithAster();
	}
}