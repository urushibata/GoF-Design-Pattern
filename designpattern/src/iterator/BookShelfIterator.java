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
	 * @since 1.0
	 */
	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	/**
	 * @see iterator.Iterator#hasNext()
	 * @since 1.0
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
	 * @since 1.0
	 */
	@Override
	public Object next(){
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

	/**
	 * @see iterator.Iterator#hasPrevious()
	 * @since 1.0
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
	 * @since 1.0
	 */
	@Override
	public Object previous(){
		Book book = bookShelf.getBookAt(index);
		index--;
		return book;
	}

	/**
	 * @see iterator.Iterator#goHead()
	 * @since 1.0
	 */
	@Override
	public void goHead() {
		this.index = 0;
	}

	/**
	 * @see iterator.Iterator#goTail()
	 * @since 1.0
	 */
	@Override
	public void goTail() {
		this.index = bookShelf.getLength() - 1;
	}
}