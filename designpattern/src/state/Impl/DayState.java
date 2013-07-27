package state.Impl;

import state.Context;
import state.State;

/**
 * @author urushibata
 * @version 1.0
 */
public class DayState implements State {

	private static DayState singleton = new DayState();
	private DayState(){}

	/**
	 * @return DayState
	 */
	public static State getInstance(){
		return singleton;
	}

	/* (非 Javadoc)
	 * @see state.State#doClock(state.Context, int)
	 */
	@Override
	public void doClock(Context context, int hour){
		if(hour < 9 || 17 <= hour){
			context.changeState(NightState.getInstance());
		}
	}

	/* (非 Javadoc)
	 * @see state.State#doUse(state.Context)
	 */
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("金庫使用（昼間）");
	}

	/* (非 Javadoc)
	 * @see state.State#doAlarm(state.Context)
	 */
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル（昼間）");
	}

	/* (非 Javadoc)
	 * @see state.State#doPhone(state.Context)
	 */
	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話（昼間）");
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "[昼間]";
	}
}