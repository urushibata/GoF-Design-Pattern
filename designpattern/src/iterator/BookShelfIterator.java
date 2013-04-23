package iterator;

/**
 * Aggregateインターフェースを実装した集合クラスを操作するクラス
 * @author urushibata
 * @version 1.0
 */
public class BookShelfIterator implements Iterator{

	private BookShelf bookShelf;
	private int index;

	/**
	 * @param bookShelf
	 */
	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	/**
	 * @see iterator.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext(){
		if(index < bookShelf.getLength()){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @see iterator.Iterator#next()
	 */
	@Override
	public Object next(){
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

	/**
	 * @see iterator.Iterator#hasPrevious()
	 */
	@Override
	public boolean hasPrevious(){
		if(index >= 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @see iterator.Iterator#previous()
	 */
	@Override
	public Object previous(){
		Book book = bookShelf.getBookAt(index);
		index--;
		return book;
	}

	/**
	 * @see iterator.Iterator#goHead()
	 */
	@Override
	public void goHead() {
		this.index = 0;
	}

	/**
	 * @see iterator.Iterator#goTail()
	 */
	@Override
	public void goTail() {
		this.index = bookShelf.getLength() - 1;
	}
}