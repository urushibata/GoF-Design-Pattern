package prototype.framework;

import java.util.HashMap;


/**
 * @author urushibata
 * @version 1.0
 */
public class Manager {
	private HashMap<String, Product> showcase = new HashMap<String, Product>();
	public void register(String name, Product proto){
		this.showcase.put(name, proto);
	}

	public Product create(String protoname){
		Product p = (Product)showcase.get(protoname);
		return p.createClone();
	}
}