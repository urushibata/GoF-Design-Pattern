package adapter.Q2_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 練習問題２－２<br />
 * 委譲パターン
 * @author urushibata
 * @version 1.0
 */
public class FileProperties implements FileIO{

	private Properties prop;

	public FileProperties(){
		this.prop = new Properties();
	}

	@Override
	public void readFromFile(String filename) throws IOException {
		this.prop.load(new FileInputStream(filename));
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		this.prop.store(new FileOutputStream(filename),"write output file by urushibata");
	}

	@Override
	public void setValue(String key, String value) {
		this.prop.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return this.prop.getProperty(key, "");
	}
}