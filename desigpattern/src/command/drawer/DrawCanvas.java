/**
 * 
 */
package command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.cmmand.MacroCommand;

/**
 * @author urushibata
 * 
 */
public class DrawCanvas extends Canvas implements Drawable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8912999038848526103L;
	// �`��F
	private Color color = Color.red;
	// �`�悷��_�̔��a
	private int radius = 6;
	// ����
	private MacroCommand history;

	// �R���X�g���N�^
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	// ����S�̂��ĕ`��
	public void paint(Graphics g) {
		history.execute();
	}

	/*
	 * (�� Javadoc)
	 * 
	 * @see command.drawer.Drawable#draw(int, int)
	 */
	@Override
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(this.color);
		g.fillOval(x - this.radius, y - this.radius, this.radius * 2,
				this.radius * 2);
	}
}