package observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * NumberGenerator抽象クラス
 * @author urushibata
 * @version 1.0
 */
public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void addObserver(Observer observer){
		this.observers.add(observer);
	}

	public void deleteObserver(Observer observer){
		this.observers.remove(observer);
	}

	public void notifyObservers(){
		Iterator<Observer> it = this.observers.iterator();
		while(it.hasNext()){
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}

	public abstract int getNumber();
	public abstract void execute();
}