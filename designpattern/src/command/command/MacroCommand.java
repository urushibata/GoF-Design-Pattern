/**
 *
 */
package command.command;

//import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Iterator;


/**
 * @author urushibata
 * ���߂̏W���N���X
 */
public class MacroCommand implements Command {

	/*
	 * @see command.cmmand.Command#execute()
	 */
	// ���߂̏W��(�X�^�b�N:LIFO)
	//private ArrayDeque<Command> commands = new ArrayDeque<Command>();
	// ���߂̏W��(�L���[:FIFO)
	// LinkedList�͎��ہA���[�L���[(deque:�f�b�N)�ł��邪�AJava�ł̓L���[�\���̘A�����X�g���Ȃ��̂ŗ��[�L���[���g�p���ăL���[�\������������B
	private LinkedList<Command> commands = new LinkedList<Command>();

	// ���s
	@Override
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while (it.hasNext()) {
			((Command) it.next()).execute();
		}
	}

	/**
	 * @param cmd DrawComand�C���X�^���X��Command�^�œn�����B
	 * �R�}���h�𗚗��ɒǉ�����B
	 */
	public void append(Command cmd) {
		// �R�}���h���������g�ȊO�̏ꍇ
		if (cmd != this) {
			// MacroCommand�ɃR�}���h��ǉ�
			// push�̓��X�g�̐擪�ɑ}�������BStack�f�[�^�\�����쐬�B
			//commands.push(cmd);
			// offer�̓��X�g�̍Ō���ɑ}�������B
			commands.offer(cmd);

			System.out.println("�ǉ���commands:[");
			int i = 0;
			for(Command c: commands){
				System.out.println("MacroCommand.commands[" + i + "]:" + c);
				i++;
			}
			System.out.println("]");
		}
	}

	// �Ō�̖��߂��폜
	public void undo() {
		System.out.println("Undo�OMacroCommand�̒��g�F" + commands);
		// �R�}���h���������g�ȊO�̏ꍇ
		if (!commands.isEmpty()){
			// ���X�g�̐擪�疽�߂���폜����B
			//commands.pop();
			// ���X�g�̍Ō�����疽�߂���폜����B
			commands.pollLast();
			System.out.println("Undo��MacroCommand�̒��g�F" + commands);
		}
	}

	// �S���폜
	public void clear() {
		// �R�}���h����������ꍇ
		if (!commands.isEmpty()) {
			commands.clear();
		}
	}
}