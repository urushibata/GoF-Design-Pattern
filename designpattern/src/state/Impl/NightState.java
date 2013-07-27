package state.Impl;

import state.Context;
import state.State;

/**
 * @author urushibata
 * @version 1.0
 */
public class NightState implements State {

	private static NightState singleton = new NightState();
	private NightState(){};
	public static State getInstance(){
		return singleton;
	}

	/* (非 Javadoc)
	 * @see state.State#doClock(state.Context, int)
	 */
	@Override
	public void doClock(Context context, int hour) {
		if(9 <= hour && hour < 17){
			context.changeState(DayState.getInstance());
		}
	}

	/* (非 Javadoc)
	 * @see state.State#doUse(state.Context)
	 */
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("非常：夜間の金庫使用");
	}

	/* (非 Javadoc)
	 * @see state.State#doAlarm(state.Context)
	 */
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル（夜間）");
	}

	/* (非 Javadoc)
	 * @see state.State#doPhone(state.Context)
	 */
	@Override
	public void doPhone(Context context) {
		context.recordLog("夜間の通話録音");
	}

	@Override
	public String toString(){
		return "[夜間]";
	}
}