package command.drawer;

import java.awt.Color;

import command.command.Command;

/**
 * @author urush_000
 *
 */
public class ColorCommand implements Command {

	// �`��Ώ�
	protected Drawable drawable;
	// �w��F
	private Color color;

	/**
	 * @param drawable DrawCanvas�N���X
	 * @param position ���W
	 * �R���X�g���N�^
	 */
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;

		System.out.println("�ǉ������o�ϐ�:color:" + this.color);
		System.out.println("�ǉ������o:" + this);
	}

	/**
	 * �����o�ϐ���drawable<DrawCanvas>��draw���\�b�h���s
	 */
	@Override
	public void execute() {
		drawable.setColor(color);
		System.out.println("���s�����ColorCommand:" + Integer.toHexString(this.hashCode()));
	}
}