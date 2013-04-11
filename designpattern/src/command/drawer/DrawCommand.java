package command.drawer;

import java.awt.Point;
import command.command.Command;

/**
 * @author urush_000
 *
 */
public class DrawCommand implements Command {

	// �`��Ώ�
	protected Drawable drawable;
	// �`��ʒu
	private Point position;

	/**
	 * @param drawable DrawCanvas�N���X
	 * @param position ���W
	 * �R���X�g���N�^
	 */
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;

		System.out.println("�ǉ������o�ϐ�:drawable:" + drawable + " position:" + position);
		System.out.println("�ǉ������o:" + this);
	}

	/**
	 * �����o�ϐ���drawable<DrawCanvas>��draw���\�b�h���s
	 */
	@Override
	public void execute() {
		System.out.println("���s�����DrawCommand:" + Integer.toHexString(this.hashCode()));
		drawable.draw(position.x, position.y);
	}
}