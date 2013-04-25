package adapter.Q2_2;

import java.io.IOException;

/**
 * @author urushibata
 * @version 1.0
 */
public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileIO f = new FileProperties();
		try{
			f.readFromFile("resource/adapterQ2_2.input.txt");
			f.setValue("year", "2013");
			f.setValue("month", "4");
			f.setValue("day", "25");
			f.writeToFile("resource/adapterQ2_2.output.txt");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}