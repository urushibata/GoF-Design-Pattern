package state.Impl;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import state.Context;
import state.State;

/**
 * @author urushibata
 *
 */
@SuppressWarnings("serial")
public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("金庫使用");
	private Button buttonAlarm = new Button("非常ベル");
	private Button buttonPhone = new Button("通常通話");
	private Button buttonExit = new Button("終了");

	private State state = DayState.getInstance();

	/**
	 * @throws HeadlessException
	 */
	public SafeFrame() throws HeadlessException {
	}

	/**
	 * @param gc
	 */
	public SafeFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public SafeFrame(String title) throws HeadlessException {
		super(title);
		this.setBackground(Color.lightGray);
		this.setLayout(new BorderLayout());

		this.add(this.textClock, BorderLayout.NORTH);
		textClock.setEditable(false);

		this.add(this.textScreen, BorderLayout.CENTER);
		this.textScreen.setEditable(false);

		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);

		this.add(panel, BorderLayout.SOUTH);

		pack();
		// ウィンドウ表示
		setVisible(true);

		this.buttonUse.addActionListener(this);
		this.buttonAlarm.addActionListener(this);
		this.buttonPhone.addActionListener(this);
		this.buttonExit.addActionListener(this);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){
		System.out.println(e.toString());
		if(this.buttonUse.equals(e.getSource())){
			this.state.doUse(this);
		}else if(this.buttonAlarm.equals(e.getSource())){
			this.state.doAlarm(this);
		}else if(this.buttonPhone.equals(e.getSource())){
			this.state.doPhone(this);
		}else if(this.buttonExit.equals(e.getSource())){
			System.exit(0);
		}else{
			System.out.println("?");
		}
	}

	/* (非 Javadoc)
	 * @see state.Context#setClock(int)
	 */
	@Override
	public void setClock(int hour) {
		String clockstring = "現在時刻は";
		if(hour < 10){
			clockstring += "0" + hour + ":00";
		}else{
			clockstring += hour + ":00";
		}
		System.out.println(clockstring);
		this.textClock.setText(clockstring);
		this.state.doClock(this, hour);
	}

	/* (非 Javadoc)
	 * @see state.Context#changeState(state.State)
	 */
	@Override
	public void changeState(State state) {
		this.state = state;
		System.out.println(this.state + "から" + state + "へ状態変化しました。");
	}

	/* (非 Javadoc)
	 * @see state.Context#callSecurityCenter(java.lang.String)
	 */
	@Override
	public void callSecurityCenter(String msg) {
		this.textScreen.append("call! " + msg + "\n");
	}

	/* (非 Javadoc)
	 * @see state.Context#recordLog(java.lang.String)
	 */
	@Override
	public void recordLog(String msg) {
		this.textScreen.append("record ... " + msg + "\n");
	}
}