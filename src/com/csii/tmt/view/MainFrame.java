package com.csii.tmt.view;

import static com.csii.tmt.utils.I18nUtils.getMessage;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.csii.tmt.event.DefaultEventProcessor;
import com.csii.tmt.event.EventProcessor;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar();

	private EventProcessor eventProcessor = new DefaultEventProcessor();
	
	private LeftPanel leftPanel = new LeftPanel(eventProcessor);
	
	private RightPanel rightPanel = new RightPanel(eventProcessor);
	
	public MainFrame() {
		JMenu fileMenu = new JMenu(getMessage("message.menu.file"));
		JMenuItem exitItem = new JMenuItem(getMessage("message.menuitem.exit"));
		menuBar.add(fileMenu);
		fileMenu.add(exitItem);

		this.setLayout(null);
		
		leftPanel.setBounds(0, 0, 300, 600);
		rightPanel.setBounds(300, 0, 660, 600);
		this.add(leftPanel);
		this.add(rightPanel);
		
		
		this.setJMenuBar(menuBar);
		// 设置窗口属性
		this.setResizable(false);
		this.setTitle(getMessage("message.window.title"));
		this.setBounds(new Rectangle(960, 600));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eventProcessor.setExitItem(exitItem);
		eventProcessor.procEvent();
	}

	public void showWindow() {
		this.setVisible(true);
	}
}
