/**
 *
 */
package command.cmmand;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author urushibata
 *
 */
public class MacroCommand implements Command {

	/*
	 * (�� Javadoc)
	 *
	 * @see command.cmmand.Command#execute()
	 */
	// ���߂̏W��(�X�^�b�N:LIFO)
	private ArrayDeque<Command> commands = new ArrayDeque<Command>();

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
			commands.push(cmd);
			System.out.println("MacroCommand�ɃR�}���h��ǉ�");
			System.out.println("MacroCommand�̒��g�F" + Arrays.deepToString(commands.toArray()));
		}
	}

	// �Ō�̖��߂��폜
	public void undo() {
		System.out.println("Undo�OMacroCommand�̒��g�F" + commands);
		// �R�}���h���������g�ȊO�̏ꍇ
		if (!commands.isEmpty()) {
			commands.pop();
			System.out.println("Undo��MacroCommand�̒��g�F" + commands);
		}
	}

	// �S���폜
	public void clear() {
		System.out.println("Clear�OMacroCommand�̒��g�F" + commands);
		if (!commands.isEmpty()) {
			commands.clear();
			System.out.println("Clear�OMacroCommand�̒��g�F" + commands);
		}
	}
}