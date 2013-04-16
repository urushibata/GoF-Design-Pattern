package command.drawer;

import java.awt.Color;

/**
 * イベントロジックインターフェース
 * @author urushbata
 * @version 1.0
 */
public interface Drawable {
	public abstract void init();
	public abstract void draw(int x, int y);
	public abstract void setColor(Color color);
	public abstract void printOut();
}
