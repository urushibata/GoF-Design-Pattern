package command.drawer;

import command.command.Command;

/**
 * @author urush_000
 *
 */
public class PrintCommand implements Command {

	// �`��Ώ�
	protected Drawable drawable;

	/**
	 * @param drawable DrawCanvas�N���X
	 * �R���X�g���N�^
	 */
	public PrintCommand(Drawable drawable){
		this.drawable = drawable;

		System.out.println("����ΏۃI�u�W�F�N�g:" + this);
	}

	/**
	 * �����o�ϐ���drawable<DrawCanvas>��draw���\�b�h���s
	 */
	@Override
	public void execute(){
		drawable.printOut();
		System.out.println("���s�����printOutCommand:" + Integer.toHexString(this.hashCode()));
	}
}