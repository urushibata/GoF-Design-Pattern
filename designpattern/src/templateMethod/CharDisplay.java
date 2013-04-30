package templateMethod;

/**
 * @author urushibata
 * @version 1.0
 */
public class CharDisplay extends AbstractDisplay {

	private char ch;
	public CharDisplay(char ch){
		this.ch = ch;
	}

	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#open()
	 */
	@Override
	public void open() {
		System.out.print("<<");
	}

	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#print()
	 */
	@Override
	public void print() {
		System.out.print(this.ch);
	}

	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#close()
	 */
	@Override
	public void close() {
		System.out.println(">>");
	}
}