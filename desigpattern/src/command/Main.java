/**
 *
 */
package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import command.cmmand.Command;
import command.cmmand.MacroCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

/**
 * @author urushibata
 *
 */
public class Main extends JFrame implements ActionListener,
		MouseMotionListener, WindowListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 6430184986003295769L;
	// 描画履歴
	private MacroCommand history = new MacroCommand();
	// 描画領域
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// クリアボタン
	private JButton clearButton = new JButton("clear");

	/**
	 * @param title
	 *            ウィンドウのタイトル
	 */
	public Main(String title) {
		// スーパクラスのコンストラクタ
		super(title);

		// JFrame→Frame→Windowスーパクラスのメソッド
		// ウィンドウにリスナー機能を実装する。無くても動く！！
		// this.addWindowListener(this);
		// canvasにMouseMotionListenerを持たせる。
		canvas.addMouseMotionListener(this);
		// clearButtonにMouseActionListenerを持たせる。
		clearButton.addActionListener(this);

		// Boxクラスはコンポーネントを作成するクラス
		// addメソッドでコンポーネント上にコンポーネントを作成する。
		// X_AXIS コンポーネントを左から右に並べて表示する。
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		System.out.println("ボタンコンポーネント上にクリアボタン作成");

		// Y_AXIS コンポーネントを上から下に並べて表示する。
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		System.out.println("メインコンポーネント上にボタンコンポーネントとキャンバス作成");

		// getContentPaneでルートコンポーネントを作成する。
		getContentPane().add(mainBox);
		System.out.println("ルートコンポーネント上にメインコンポーネントを作成");

		// Windowクラスのメソッド(JFrameを継承しているため使用可能)
		// 各コンポーネントよりウィンドウのサイズを自動調整する。これがないと画面は最少サイズになる。
		pack();
		// ウィンドウ表示
		setVisible(true);
		System.out.println("ウィンドウ表示");
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * addActionListenerされたコンポーネントを監視しイベントが発生したら処理をする。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// アクションイベント発生元がクリアボタンの場合
		if (e.getSource() == clearButton) {
			// MacroCommandに溜まったイベント履歴を全てクリアする。
			history.clear();
			// 再描画
			// DrawCanvas→Canvas→Componentスーパクラスのメソッド
			canvas.repaint();
			System.out.println("Clear Event execute success");
		}
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#mouseDragged(java.awt.event.ActionEvent)
	 * addMouseMotionListenerされたコンポーネントを監視しドラッグイベントが発生したら処理をする。
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// DrawCommandインスタンスを作成しhistory(MacroCommand)に格納する。
		Command cmd = new DrawCommand(this.canvas, e.getPoint());
		history.append(cmd);
		// コマンドを実行
		cmd.execute();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	/*
	 * (非 Javadoc)
	 *
	 * メインクラス
	 */
	public static void main(String[] args) {
		System.out.println("command pattern Strat");
		new Main("Command Pattern Sample");
	}
}