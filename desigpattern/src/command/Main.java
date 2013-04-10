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
	// �`�旚��
	private MacroCommand history = new MacroCommand();
	// �`��̈�
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// �N���A�{�^��
	private JButton clearButton = new JButton("clear");

	/**
	 * @param title
	 *            �E�B���h�E�̃^�C�g��
	 */
	public Main(String title) {
		// �X�[�p�N���X�̃R���X�g���N�^
		super(title);

		// JFrame��Frame��Window�X�[�p�N���X�̃��\�b�h
		// �E�B���h�E�Ƀ��X�i�[�@�\����������B�����Ă������I�I
		// this.addWindowListener(this);
		// canvas��MouseMotionListener����������B
		canvas.addMouseMotionListener(this);
		// clearButton��MouseActionListener����������B
		clearButton.addActionListener(this);

		// Box�N���X�̓R���|�[�l���g���쐬����N���X
		// add���\�b�h�ŃR���|�[�l���g��ɃR���|�[�l���g���쐬����B
		// X_AXIS �R���|�[�l���g��������E�ɕ��ׂĕ\������B
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		System.out.println("�{�^���R���|�[�l���g��ɃN���A�{�^���쐬");

		// Y_AXIS �R���|�[�l���g���ォ�牺�ɕ��ׂĕ\������B
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		System.out.println("���C���R���|�[�l���g��Ƀ{�^���R���|�[�l���g�ƃL�����o�X�쐬");

		// getContentPane�Ń��[�g�R���|�[�l���g���쐬����B
		getContentPane().add(mainBox);
		System.out.println("���[�g�R���|�[�l���g��Ƀ��C���R���|�[�l���g���쐬");

		// Window�N���X�̃��\�b�h(JFrame���p�����Ă��邽�ߎg�p�\)
		// �e�R���|�[�l���g���E�B���h�E�̃T�C�Y��������������B���ꂪ�Ȃ��Ɖ�ʂ͍ŏ��T�C�Y�ɂȂ�B
		pack();
		// �E�B���h�E�\��
		setVisible(true);
		System.out.println("�E�B���h�E�\��");
	}

	/*
	 * (�� Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * addActionListener���ꂽ�R���|�[�l���g���Ď����C�x���g�����������珈��������B
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// �A�N�V�����C�x���g���������N���A�{�^���̏ꍇ
		if (e.getSource() == clearButton) {
			// MacroCommand�ɗ��܂����C�x���g������S�ăN���A����B
			history.clear();
			// �ĕ`��
			// DrawCanvas��Canvas��Component�X�[�p�N���X�̃��\�b�h
			canvas.repaint();
			System.out.println("Clear Event execute success");
		}
	}

	/*
	 * (�� Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#mouseDragged(java.awt.event.ActionEvent)
	 * addMouseMotionListener���ꂽ�R���|�[�l���g���Ď����h���b�O�C�x���g�����������珈��������B
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// DrawCommand�C���X�^���X���쐬��history(MacroCommand)�Ɋi�[����B
		Command cmd = new DrawCommand(this.canvas, e.getPoint());
		history.append(cmd);
		// �R�}���h�����s
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
	 * (�� Javadoc)
	 *
	 * ���C���N���X
	 */
	public static void main(String[] args) {
		System.out.println("command pattern Strat");
		new Main("Command Pattern Sample");
	}
}