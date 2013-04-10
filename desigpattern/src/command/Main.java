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
	// 消去ボタン
	private JButton clearButton = new JButton("clear");

	/**
	 * @param args
	 */
	public Main(String title) {
		super(title);

		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);

		// Boxクラスはコンポーネントを作成するクラス
		// X_AXIS コンポーネントを左から右に並べて表示する。
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		// Y_AXIS コンポーネントを上から下に並べて表示する。
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		pack();
		setVisible(true);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
			System.out.println("Clear Event");
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(this.canvas, e.getPoint());
		history.append(cmd);
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

	public static void main(String[] args) {
		System.out.println("command pattern Strat");
		new Main("Command Pattern Sample");
	}
}