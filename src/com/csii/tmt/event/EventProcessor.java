package com.csii.tmt.event;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class EventProcessor {

	protected JButton sendBtn;

	protected JButton openBtn;

	protected JTextArea msgContentArea;

	protected JTextField ipField;

	protected JTextField portField;

	protected JTextArea msgLocationArea;

	protected JMenuItem exitItem;

	protected JFileChooser fileChooser = new JFileChooser();

	public void setSendBtn(JButton sendBtn) {
		this.sendBtn = sendBtn;
	}

	public void setOpenBtn(JButton openBtn) {
		this.openBtn = openBtn;
	}

	public void setMsgContentArea(JTextArea msgContentArea) {
		this.msgContentArea = msgContentArea;
	}

	public void setIpField(JTextField ipField) {
		this.ipField = ipField;
	}

	public void setPortField(JTextField portField) {
		this.portField = portField;
	}

	public void setMsgLocationArea(JTextArea msgLocationArea) {
		this.msgLocationArea = msgLocationArea;
	}

	public void setExitItem(JMenuItem exitItem) {
		this.exitItem = exitItem;
	}

	public abstract void procEvent();
}
