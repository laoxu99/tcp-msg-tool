package com.csii.tmt.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalBorders;

import com.csii.tmt.event.EventProcessor;

public class RightPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea msgContentArea = new JTextArea();
	
	private JScrollPane scrollPane = new JScrollPane(msgContentArea);
	
	public RightPanel(EventProcessor eventProcessor) {

		this.setLayout(null);
		
		scrollPane.setBounds(20, 30, 600, 460);
		scrollPane.setBorder(MetalBorders.getTextFieldBorder());
		//msgContentArea.setLineWrap(true);
		this.add(scrollPane);
		
		eventProcessor.setMsgContentArea(msgContentArea);
	}
}
