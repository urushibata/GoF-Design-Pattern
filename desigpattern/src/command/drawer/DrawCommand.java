package command.drawer;

import java.awt.Point;
import command.cmmand.Command;

/**
 * @author urush_000
 *
 */
public class DrawCommand implements Command {

	// 描画対象
	protected Drawable drawable;
	// 描画位置
	private Point position;

	/**
	 * @param drawable DrawCanvasクラス
	 * @param position 座標
	 * コンストラクタ
	 */
	public DrawCommand(Drawable drawable, Point position) {
		System.out.println("メンバ変数に追加開始");
		this.drawable = drawable;
		this.position = position;

		System.out.println("メンバ変数に追加終了");
		System.out.println("drawable:" + drawable);
		System.out.println("position:" + position);
	}

	/**
	 * @author urush_000
	 *
	 */
	@Override
	public void execute() {
		System.out.println("描画処理開始");
		drawable.draw(position.x, position.y);
		System.out.println("描画処理完了");
	}

}