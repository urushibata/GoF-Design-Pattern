package observer;

/**
 * Observerインターフェース<br />
 * Observerとは観察(Observe)する人、即ち「観察者」という意味。<br />
 * @author urushibata
 * @version 1.0
 */
public interface Observer {
	public abstract void update(NumberGenerator generator);
}
