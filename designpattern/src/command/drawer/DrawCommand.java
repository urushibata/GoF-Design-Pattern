package command.drawer;

import java.awt.Point;
import command.command.Command;

/**
 * 書くという命令クラス<br />
 * Interface Commandの実装クラス
 * @author urushibata
 */
public class DrawCommand implements Command {

	// 描画対象
	protected Drawable drawable;
	// 描画位置
	private Point position;

	/**
	 * コンストラクタ
	 * @param drawable DrawCanvasクラス
	 * @param position 座標
	 */
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;

		System.out.println("追加メンバ変数:drawable:" + drawable + " position:" + position);
		System.out.println("追加メンバ:" + this);
	}

	/**
	 * メンバ変数のdrawable<DrawCanvas>のdrawメソッド実行
	 * @see command.command.Command#execute()
	 */
	@Override
	public void execute() {
		System.out.println("実行されるDrawCommand:" + Integer.toHexString(this.hashCode()));
		drawable.draw(position.x, position.y);
	}
}