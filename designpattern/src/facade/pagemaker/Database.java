package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author urushibata
 * @version 1.0
 */
public class Database{
	private Database(){}

	/**
	 * @param dbname
	 * @return Properties
	 * @since 1.0
	 */
	public static Properties getProperties(String dbname){
		String filename = dbname + ".txt";
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(filename));
		}catch(IOException e){
			System.out.println("Warning: " + filename + " is not found.");
		}
		return prop;
	}
}