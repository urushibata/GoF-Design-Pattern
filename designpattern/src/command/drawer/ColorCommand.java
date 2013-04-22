package command.drawer;

import java.awt.Color;

import command.command.Command;

/**
 * 線の色を変更するという命令クラス<br />
 * Interface Commandの実装クラス
 * @author urushbata
 * @version 1.0
 */
public class ColorCommand implements Command {

	/**
	 * 描画対象
	 */
	protected Drawable drawable;
	/**
	 * 指定色
	 */
	private Color color;

	/**
	 * コンストラクタ
	 * @param drawable DrawCanvasクラス
	 * @param color 色
	 * @since 1.0
	 */
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;

		System.out.println("追加メンバ変数:color:" + this.color);
		System.out.println("追加メンバ:" + this);
	}

	/**
	 * メンバ変数のdrawable<DrawCanvas>のdrawメソッド実行
	 * @see command.command.Command#execute()
	 * @since 1.0
	 */
	@Override
	public void execute() {
		drawable.setColor(color);
		System.out.println("実行されるColorCommand:" + Integer.toHexString(this.hashCode()));
	}
}