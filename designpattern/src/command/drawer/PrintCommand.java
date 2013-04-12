package command.drawer;

import command.command.Command;

/**
 * @author urushibata
 * 印刷するという命令クラス
 * Interface Commandの実装クラス
 */
public class PrintCommand implements Command {

	// 描画対象
	protected Drawable drawable;

	/**
	 * @param drawable DrawCanvasクラス
	 * コンストラクタ
	 */
	public PrintCommand(Drawable drawable){
		this.drawable = drawable;

		System.out.println("印刷対象オブジェクト:" + this);
	}

	/**
	 * メンバ変数のdrawable<DrawCanvas>のdrawメソッド実行
	 */
	@Override
	public void execute(){
		drawable.printOut();
		System.out.println("実行されるprintOutCommand:" + Integer.toHexString(this.hashCode()));
	}
}