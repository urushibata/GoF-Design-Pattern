package state;

import state.Impl.SafeFrame;

/**
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("State Sample");
		while(true){
			for(int hour = 0; hour < 24; hour++){
				frame.setClock(hour);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
				}
			}
		}
	}
}