package templateMethod;

/**
 * 表示するという抽象クラス。
 * @author urushibata
 * @version 1.0
 */
public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	/**
	 * 表示メソッド（具象）<br />
	 * ロジックのみ記述し、具体的な処理はサブクラスに任せる。
	 * また、final識別子により継承を不可にしている。
	 * @since 1.0
	 */
	public final void display(){
		open();
		for(int i = 0; i < 5; i++){
			print();
		}
		close();
	}
}