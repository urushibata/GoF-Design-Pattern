/**
 * 
 */
package command.cmmand;

import java.util.ArrayDeque;
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
		while(it.hasNext()){
			((Command)it.next()).execute();
		}
	}
	
	//追加
	public void append(Command cmd){
		if(cmd != this){
			commands.push(cmd);
		}
	}

	//最後の命令を削除
	public void undo(){
		if(!commands.isEmpty()){
			commands.pop();
		}
	}

	//全部削除
	public void clear(){
		if(!commands.isEmpty()){
			commands.clear();
		}
	}
}