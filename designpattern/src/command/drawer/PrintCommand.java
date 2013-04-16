package command.drawer;

import command.command.Command;

/**
 * 印刷するという命令クラス<br />
 * Interface Commandの実装クラス
 * @author urushibata
 * @version 1.0
 */
public class PrintCommand implements Command {

	// 描画対象
	protected Drawable drawable;

	/**
	 * コンストラクタ
	 * @param drawable DrawCanvasクラス
	 * @since 1.0
	 */
	public PrintCommand(Drawable drawable){
		this.drawable = drawable;

		System.out.println("印刷対象オブジェクト:" + this);
	}

	/**
	 * メンバ変数のdrawable<DrawCanvas>のdrawメソッド実行
	 * @see command.command.Command#execute()
	 * @since 1.0
	 */
	@Override
	public void execute(){
		drawable.printOut();
		System.out.println("実行されるprintOutCommand:" + Integer.toHexString(this.hashCode()));
	}
}