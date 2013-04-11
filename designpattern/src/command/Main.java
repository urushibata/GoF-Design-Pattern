/**
 *
 */
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
import javax.swing.JTabbedPane;

import command.command.Command;
import command.command.MacroCommand;
import command.drawer.ColorCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

/**
 * @author urushibata
 * command�p�^�[�����C���N���X
 * ���G�����\�t�g
 */
public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 6430184986003295769L;
	// �`�旚��
	private MacroCommand history = new MacroCommand();

	// �L�����o�X�^�u
	private JTabbedPane drawTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	// �p���b�g�^�u
	private JTabbedPane palletTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	// DrawCanvas�C���X�^���X�쐬
	// �`��̈�
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// JButton�C���X�^���X�쐬
	// �N���A�{�^��
	private JButton clearButton = new JButton("clear");
	// �A���h�D
	private JButton undoButton = new JButton("undo");
	// �ԕ���
	private JButton redFontButton = new JButton("red");
	// ����
	private JButton blueFontButton = new JButton("blue");
	// �Ε���
	private JButton greenFontButton = new JButton("green");
	// ���
	private JButton printButton = new JButton("print");

	/**
	 * @param title �E�B���h�E�̃^�C�g��
	 */
	public Main(String title) {
		// �X�[�p�N���X�̃R���X�g���N�^
		super(title);

		// JFrame��Frame��Window�X�[�p�N���X�̃��\�b�h
		// �E�B���h�E�Ƀ��X�i�[�@�\����������B
		// TODO �����Ă������B�B�B
		//this.addWindowListener(new WindowAdapter(){});
		// canvas��MouseMotionListener����������B
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			/*
			 * @see
			 * java.awt.event.ActionListener#mouseDragged(java.awt.event.ActionEvent
			 * addMouseMotionListener���ꂽ�R���|�[�l���g���Ď����h���b�O�C�x���g�����������珈��������C���i�[�N���X
			 * �C���^�[�t�F�[�X����������ꍇ�́A�K�v�Ȃ����\�b�h����Ŏ������Ȃ���΂����Ȃ����AMouseMotionAdapter�N���X
			 * ��MouseMotionListener�̃��\�b�h����Ŏ������ꂽ�N���X�ׁ̈A�K�v�ȃ��\�b�h�̂ݎ�������΂悭�Ȃ�B
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				// DrawCommand�C���X�^���X���쐬��history(MacroCommand)�Ɋi�[����B
				Command cmd = new DrawCommand(canvas, e.getPoint());
				history.append(cmd);
				// �R�}���h�����s
				cmd.execute();
			}
		});

		// �e�{�^����MouseActionListener����������B
		clearButton.addActionListener(this);
		undoButton.addActionListener(this);
		redFontButton.addActionListener(this);
		blueFontButton.addActionListener(this);
		greenFontButton.addActionListener(this);
		printButton.addActionListener(this);

		// Box�N���X�̓R���|�[�l���g���쐬����N���X
		// add���\�b�h�ŃR���|�[�l���g��ɃR���|�[�l���g���쐬����B
		// X_AXIS �R���|�[�l���g��������E�ɕ��ׂĕ\������B
		Box buttonBox1 = new Box(BoxLayout.X_AXIS);
		buttonBox1.add(undoButton);
		buttonBox1.add(printButton);
		buttonBox1.add(clearButton);
		System.out.println("�{�^���R���|�[�l���g1��ɃA���h�D�{�^���E�N���A�{�^���E�ԃ{�^���E�{�^���E�΃{�^���쐬");
		Box buttonBox2 = new Box(BoxLayout.X_AXIS);
		buttonBox2.add(redFontButton);
		buttonBox2.add(blueFontButton);
		buttonBox2.add(greenFontButton);
		System.out.println("�{�^���R���|�[�l���g1��ɃA���h�D�{�^���E�N���A�{�^���E�ԃ{�^���E�{�^���E�΃{�^���쐬");

		// Y_AXIS �R���|�[�l���g���ォ�牺�ɕ��ׂĕ\������B
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox2);
		mainBox.add(canvas);
		mainBox.add(buttonBox1);
		System.out.println("���C���R���|�[�l���g��Ƀ{�^���R���|�[�l���g�ƃL�����o�X�쐬");

		// �L�����o�X�^�u�쐬
		drawTab.setBounds(10, 10, 405, 405);
		drawTab.add(mainBox);
		drawTab.setTitleAt(drawTab.indexOfComponent(mainBox), "canvas");

		Box palletBox = new Box(BoxLayout.Y_AXIS);
		// �p���b�g�^�u�쐬
		palletTab.setBounds(10, 10, 405, 405);
		palletTab.add(palletBox);
		//palletTab.setTitleAt(drawTab.indexOfComponent(palletBox), "pallet");
		// getContentPane�Ń��[�g�R���|�[�l���g���쐬����B
		getContentPane().add(drawTab);
		System.out.println("���[�g�R���|�[�l���g��Ƀ��C���R���|�[�l���g���쐬");

		// JFrame��Frame��Window�N���X�̃��\�b�h
		// �e�R���|�[�l���g���E�B���h�E�̃T�C�Y��������������B���ꂪ�Ȃ��Ɖ�ʂ͍ŏ��T�C�Y�ɂȂ�B
		pack();
		// �E�B���h�E�\��
		setVisible(true);
		System.out.println("�E�B���h�E�\��");
	}

	/*
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * addActionListener���ꂽ�R���|�[�l���g���Ď����C�x���g�����������珈��������B
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		// �A�N�V�����C�x���g���������N���A�{�^���̏ꍇ
		if(e.getSource() == clearButton){
			// MacroCommand�ɗ��܂����C�x���g������S�ăN���A����B
			history.clear();
			// �ĕ`��
			// DrawCanvas��Canvas��Component�X�[�p�N���X�̃��\�b�h
			canvas.init();
			canvas.repaint();

			System.out.println("Clear Event execute success");

		// �A�N�V�����C�x���g���������A���h�D�{�^���̏ꍇ
		}else if(e.getSource() == undoButton){
			history.undo();
			// DrawCanvas��Canvas��Component�X�[�p�N���X�̃��\�b�h
			canvas.repaint();

			System.out.println("Undo Event execute success");

		// �A�N�V�����C�x���g���������ԃ{�^���̏ꍇ
		}else if(e.getSource() == redFontButton){
			Command cmd = new ColorCommand(canvas, Color.RED);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Red Event execute success");

		// �A�N�V�����C�x���g���������{�^���̏ꍇ
		}else if(e.getSource() == blueFontButton){
			Command cmd = new ColorCommand(canvas, Color.BLUE);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Blue Event execute success");

		// �A�N�V�����C�x���g���������΃{�^���̏ꍇ
		}else if(e.getSource() == greenFontButton){
			Command cmd = new ColorCommand(canvas, Color.GREEN);
			history.append(cmd);
			cmd.execute();

			System.out.println("ChangeColor Green Event execute success");

		// �A�N�V�����C�x���g������������{�^���̏ꍇ
		}else if(e.getSource() == printButton){
			// TODO �������
			//imageIO.write���g���B
			//Command cmd = new PrintCommand(canvas);
			//cmd.execute();

			System.out.println("Command print Event execute success");

		}
	}

	/*
	 * ���C���N���X
	 */
	public static void main(String[] args) {
		System.out.println("command pattern Strat");
		new Main("Command Pattern Sample");
	}
}