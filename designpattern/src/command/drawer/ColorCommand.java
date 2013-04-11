package command.drawer;

import java.awt.Color;

import command.command.Command;

/**
 * @author urush_000
 *
 */
public class ColorCommand implements Command {

	// 描画対象
	protected Drawable drawable;
	// 指定色
	private Color color;

	/**
	 * @param drawable DrawCanvasクラス
	 * @param position 座標
	 * コンストラクタ
	 */
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;

		System.out.println("追加メンバ変数:color:" + this.color);
		System.out.println("追加メンバ:" + this);
	}

	/**
	 * メンバ変数のdrawable<DrawCanvas>のdrawメソッド実行
	 */
	@Override
	public void execute() {
		drawable.setColor(color);
		System.out.println("実行されるColorCommand:" + Integer.toHexString(this.hashCode()));
	}
}