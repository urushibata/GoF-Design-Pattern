package iterator;

/**
 * Iteratorパターンメインクラス<br />
 * 本棚
 * @author urushibata
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("*** Start iterator!! ***");

		// 本棚作成
		BookShelf bookShelf = new BookShelf();
		// 本を登録
		bookShelf.appendBook(new Book("Around the World in 80 days"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy-Long-Legs"));

		// 本棚のサイズ
		System.out.println("本棚にある本の数 : " + bookShelf.getLength());
		System.out.println("先頭から順番に表示する。");
		// Iteratorインターフェース参照型に代入することで、BookShelf具象クラスとの
		// 依存性から切り離す。
		Iterator it = bookShelf.iterator();
		while(it.hasNext()){
			Book book = (Book)it.next();
			System.out.println(book.getName());
		}
		System.out.println("後ろから順番に表示する。");
		it.goTail();
		while(it.hasPrevious()){
			Book book = (Book)it.previous();
			System.out.println(book.getName());
		}

		System.out.println("*** End iterator!! ***");
	}
}