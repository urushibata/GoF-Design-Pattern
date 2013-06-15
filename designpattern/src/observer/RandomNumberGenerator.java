package observer;

import java.util.Random;

/**
 *
 * @author urushibata
 * @version 1.0
 */
public class RandomNumberGenerator extends NumberGenerator {

	private Random random = new Random();
	private int number;

	/* (非 Javadoc)
	 * @see observer.NumberGenerator#getNumber()
	 */
	@Override
	public int getNumber() {
		return this.number;
	}

	/* (非 Javadoc)
	 * @see observer.NumberGenerator#execute()
	 */
	@Override
	public void execute() {
		for(int i = 0; i < 20; i++){
			number = random.nextInt(50);
			this.notifyObservers();
		}
	}
}