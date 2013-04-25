package iterator;

/**
 * @author urushibata
 * @version 1.0
 */
public interface Iterator {
	/**
	 * 一つ先の配列が存在するかチェックする。<br />
	 * ある場合、インデックスを一つ進める。
	 * @since 1.0
	 * @return boolean
	 */
	public abstract boolean hasNext();
	/**
	 * 配列のインデックスを一つ進める。
	 * @since 1.0
	 * @return Object
	 */
	public abstract Object next();
	/**
	 * 一つ前の配列が存在するかチェックする。<br />
	 * ある場合、インデックスを一つ戻す。
	 * @since 1.0
	 * @return boolean
	 */
	public abstract boolean hasPrevious();
	/**
	 * 配列のインデックスを一つ戻す。
	 * @since 1.0
	 * @return Object
	 */
	public abstract Object previous();
	/**
	 * 配列の先頭へ移動する。
	 * @since 1.0
	 */
	public abstract void goHead();
	/**
	 * 配列の最後尾へ移動する。
	 * @since 1.0
	 */
	public abstract void goTail();
}