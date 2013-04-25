package iterator;

/**
 * @author urushibata
 * @version 1.0
 */
public class Book{
	private String name;

	/**
	 * コンストラクタ
	 * @param name
	 */
	public Book(String name){
		this.name = name;
	}

	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}
}