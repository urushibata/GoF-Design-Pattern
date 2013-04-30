package templateMethod;

/**
 * @author urushibata
 * @version 1.0
 */
public class StringDisplay extends AbstractDisplay {

	private String string;
	private int width;
	/**
	 * @param string
	 */
	public StringDisplay(String string){
		this.string = string;
		this.width = string.getBytes().length;
	}
	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#open()
	 */
	@Override
	public void open() {
		printLine();
	}

	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#print()
	 */
	@Override
	public void print() {
		System.out.println("|" + this.string + "|");
	}

	/* (非 Javadoc)
	 * @see templateMethod.AbstractDisplay#close()
	 */
	@Override
	public void close() {
		printLine();
	}

	/**
	 * 
	 */
	private void printLine(){
		StringBuffer line = new StringBuffer("+");
		for(int i = 0; i < this.width; i++){
			line.append("-");
		}
		System.out.println(line.append("+"));
	}
}