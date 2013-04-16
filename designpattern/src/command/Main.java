package command;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.awt.event.WindowAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import command.command.Command;
import command.command.MacroCommand;
import command.drawer.DrawCommand;
import command.drawer.ColorCommand;
import command.drawer.PrintCommand;
import command.drawer.DrawCanvas;

/**
 * commandパターンメインクラス<br />
 * お絵かきソフト
 * @author urushibata
 * @version 1.0
 */
public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 6430184986003295769L;
	// 描画履歴
	private MacroCommand history = new MacroCommand();
	// 描画領域
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// JButtonインスタンス作成
	// クリアボタン
	private JButton clearButton = new JButton("clear");
	// アンドゥ
	private JButton undoButton = new JButton("undo");
	// 赤文字
	private JButton redFontButton = new JButton("red");
	// 青文字
	private JButton blueFontButton = new JButton("blue");
	// 緑文字
	private JButton greenFontButton = new JButton("green");
	// 印刷
	private JButton printButton = new JButton("print");

	/**
	 * @param title ウィンドウのタイトル
	 * @since 1.0
	 */
	public Main(String title) {
		// スーパクラスのコンストラクタ
		super(title);

		// JFrame→Frame→Windowスーパクラスのメソッド
		// ウィンドウにリスナー機能を実装する。
		// TODO 無くても動く。。。
		//this.addWindowListener(new WindowAdapter(){});
		// canvasにMouseMotionListenerを持たせる。
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			/**
			 * addMouseMotionListenerされたコンポーネントを監視しドラッグイベントが発生したら処理をするインナークラス<br />
			 * インターフェースを実装する場合は、必要ないメソッドも空で実装しなければいけないが、MouseMotionAdapterクラス
			 * はMouseMotionListenerのメソッドが空で実装されたクラスの為、必要なメソッドのみ実装すればよくなる。
			 * @since 1.0
			 * @see java.awt.event.ActionListener#mouseDragged(java.awt.event.ActionEvent
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				// DrawCommandインスタンスを作成しhistory(MacroCommand)に格納する。
				Command cmd = new DrawCommand(canvas, e.getPoint());
				history.append(cmd);
				// コマンドを実行
				cmd.execute();
			}
		});

		// 各ボタンにMouseActionListenerを持たせる。
		clearButton.addActionListener(this);
		undoButton.addActionListener(this);
		redFontButton.addActionListener(this);
		blueFontButton.addActionListener(this);
		greenFontButton.addActionListener(this);
		printButton.addActionListener(this);

		// Boxクラスはコンポーネントを作成するクラス
		// addメソッドでコンポーネント上にコンポーネントを作成する。
		// X_AXIS コンポーネントを左から右に並べて表示する。
		Box buttonBox1 = new Box(BoxLayout.X_AXIS);
		buttonBox1.add(undoButton);
		buttonBox1.add(printButton);
		buttonBox1.add(clearButton);
		System.out.println("ボタンコンポーネント1上にアンドゥボタン・印刷ボタン・クリアボタン作成");

		// Y_AXIS コンポーネントを上から下に並べて表示する。
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(canvas);
		mainBox.add(buttonBox1);
		System.out.println("メインコンポーネント上にボタン１とキャンバス作成");

		// キャンバスタブ作成
		JPanel canvasTab = new JPanel();
		canvasTab.add(mainBox);

		Box buttonBox2 = new Box(BoxLayout.X_AXIS);
		buttonBox2.add(redFontButton);
		buttonBox2.add(blueFontButton);
		buttonBox2.add(greenFontButton);
		System.out.println("ボタン1上に赤ボタン・青ボタン・緑ボタン作成");
		Box palletBox = new Box(BoxLayout.Y_AXIS);
		palletBox.add(buttonBox2);
		System.out.println("パレットコンポーネント上にボタン２作成");

		// パレットタブ作成
		JPanel palletTab = new JPanel();
		palletTab.add(palletBox);

		// ルートタブ作成
		JTabbedPane rootTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		rootTab.setBounds(10, 10, 405, 405);
		rootTab.addTab("canvas", canvasTab);
		rootTab.addTab("pallet", palletTab);

		// getContentPaneでルートコンポーネントを作成する。
		getContentPane().add(rootTab);
		// 閉じたときの処理
		// 以下はデフォルト値なので書かなくても動く。
		// パラメータ
		//	DISPOSE_ON_CLOSE	ウィンドウを消去し、リソースを破棄する。
		//	DO_NOTHING_ON_CLOSE	何もしない。WindowListenerのwindowClosingでリソースを破棄する必要がある。
		//	EXIT_ON_CLOSE		JVMを終了する。
		//	HIDE_ON_CLOSE		ウィンドウの表示は消えるが、リソースは存続し、再表示も可能
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("ルートコンポーネント上にメインコンポーネントを作成");

		// JFrame→Frame→Windowクラスのメソッド
		// 各コンポーネントよりウィンドウのサイズを自動調整する。これがないと画面は最少サイズになる。
		pack();
		// ウィンドウ表示
		setVisible(true);
		System.out.println("ウィンドウ表示");
	}

	/**
	 * addActionListenerされたコンポーネントを監視しイベントが発生したら処理をする。
	 * @since 1.0
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		// アクションイベント発生元がクリアボタンの場合
		if(clearButton.equals(e.getSource())){
			// MacroCommandに溜まったイベント履歴を全てクリアする。
			history.clear();
			// 再描画
			// DrawCanvas→Canvas→Componentスーパクラスのメソッド
			canvas.init();
			canvas.repaint();

			System.out.println("Clear Event execute success");

		// アクションイベント発生元がアンドゥボタンの場合
		}else if(undoButton.equals(e.getSource())){
			history.undo();
			// DrawCanvas→Canvas→Componentスーパクラスのメソッド
			canvas.repaint();

			System.out.println("Undo Event execute success");

		// アクションイベント発生元が赤ボタンの場合
		}else if(redFontButton.equals(e.getSource())){
			Command cmd = new ColorCommand(canvas, Color.RED);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Red Event execute success");

		// アクションイベント発生元が青ボタンの場合
		}else if(blueFontButton.equals(e.getSource())){
			Command cmd = new ColorCommand(canvas, Color.BLUE);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Blue Event execute success");

		// アクションイベント発生元が緑ボタンの場合
		}else if(greenFontButton.equals(e.getSource())){
			Command cmd = new ColorCommand(canvas, Color.GREEN);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Green Event execute success");

		// アクションイベント発生元が印刷ボタンの場合
		}else if(printButton.equals(e.getSource())){
			System.out.println("画像保存中・・・");
			// コマンド履歴には追加しない。
			Command cmd = new PrintCommand(canvas);
			cmd.execute();

			System.out.println("Command print Event execute success");
		}
	}

	/**
	 * メインクラス
	 * @since 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("command pattern Strat");
		new Main("Command Pattern Sample");
	}
}