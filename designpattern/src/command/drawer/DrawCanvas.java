/**
 *
 */
package command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.command.MacroCommand;

/**
 * @author urushibata
 * java.awt.Component��java.awt.Canvas���p��
 * InterFace Drawable�̎����N���X
 */
public class DrawCanvas extends Canvas implements Drawable {
	private static final long serialVersionUID = 8912999038848526103L;
	// �`��F
	private Color color;
	// �`�悷��_�̔��a
	private int radius;
	// Main�N���X����n����A���̃N���X�Ƌ��L����B
	// ����
	private MacroCommand history;

	// �R���X�g���N�^
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
		init();
	}

	// ������`��
	// Canvas��Component��paint�R�[���o�b�N���\�b�h
	@Override
	public void paint(Graphics g){
		System.out.println("paint���\�b�h");
		history.execute();
	}

	/*
	 * @see command.drawer.Drawable#draw(int, int)
	 */
	@Override
	public void draw(int x, int y){
		System.out.println("���āA�������B");
		System.out.println("���̐F�F" + this.color);

		// Component�N���X��getGraphics��Graphics�N���X�쐬
		Graphics g = getGraphics();
		g.setColor(this.color);
		// �h��ׂ��ꂽ�~�������B
		// ������	�����X���W
		// ������	�����Y���W
		// ��O����	width
		// ��l����	height
		g.fillOval(x - this.radius, y - this.radius, this.radius * 2, this.radius * 2);
		System.out.println("�͂���");
	}

	@Override
	public void init() {
		this.color = Color.red;
		this.radius = 3;
		history.append(new ColorCommand(this, color));
	}

	@Override
	public void setColor(Color color){
		System.out.println("�F�Z�b�g�I�I��" + color);
		this.color = color;
	}
}