package facade;

import facade.pagemaker.PageMaker;

/**
 * @author urushibata
 * @version 1.0
 */
public class Main{

	/**
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args){
		PageMaker.makeWelcomePage("urushibata@cmds.co.jp", "welcome.html");
	}
}
