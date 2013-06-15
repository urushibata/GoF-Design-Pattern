package observer;

/**
 *
 * @author urushibata
 * @version 1.0
 */
public class DigitObserver implements Observer {

	/* (非 Javadoc)
	 * @see observer.Observer#update(observer.NumberGenerator)
	 */
	@Override
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver :" + generator.getNumber());
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){
		}
	}
}