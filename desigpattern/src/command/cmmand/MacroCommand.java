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
	 * (非 Javadoc)
	 *
	 * @see command.cmmand.Command#execute()
	 */
	// 命令の集合(スタック:LIFO)
	private ArrayDeque<Command> commands = new ArrayDeque<Command>();

	// 実行
	@Override
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while (it.hasNext()) {
			((Command) it.next()).execute();
		}
	}

	/**
	 * @param cmd DrawComandインスタンスがCommand型で渡される。
	 * コマンドを履歴に追加する。
	 */
	public void append(Command cmd) {
		// コマンドが自分自身以外の場合
		if (cmd != this) {
			commands.push(cmd);
			System.out.println("MacroCommandにコマンドを追加");
			System.out.println("MacroCommandの中身：" + Arrays.deepToString(commands.toArray()));
		}
	}

	// 最後の命令を削除
	public void undo() {
		System.out.println("Undo前MacroCommandの中身：" + commands);
		// コマンドが自分自身以外の場合
		if (!commands.isEmpty()) {
			commands.pop();
			System.out.println("Undo後MacroCommandの中身：" + commands);
		}
	}

	// 全部削除
	public void clear() {
		System.out.println("Clear前MacroCommandの中身：" + commands);
		if (!commands.isEmpty()) {
			commands.clear();
			System.out.println("Clear前MacroCommandの中身：" + commands);
		}
	}
}