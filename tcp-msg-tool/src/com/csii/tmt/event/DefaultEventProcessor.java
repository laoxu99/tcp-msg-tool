package com.csii.tmt.event;

import static com.csii.tmt.utils.I18nUtils.getMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csii.tmt.net.SockClient;
import com.csii.tmt.utils.AssertUtils;

public class DefaultEventProcessor extends EventProcessor {

	private Log log = LogFactory.getLog(this.getClass());

	public void procEvent() {
		log.info("=======开始事件处理!========");
		openBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				
				File file = new File("./msg");
				fileChooser.setCurrentDirectory(file);
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					log.info("filePath=>" + filePath);
					msgLocationArea.setText(filePath);
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
						StringBuffer buffer = new StringBuffer();
						String tmpStr;
						while ((tmpStr = reader.readLine()) != null) {
							String str = tmpStr.trim();
							// FIXME
							buffer.append(str);
							buffer.append("\r\n");
						}
						log.info(buffer);
						msgContentArea.setText(buffer.toString());
					} catch (IOException e) {
						log.error(e.getMessage());
					}
				}

			}
		});

		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String msgContent = msgContentArea.getText();
				if (AssertUtils.isEmpty(msgContent, getMessage("message.assert.sendmsg.mustnot.empty"))) {
					return;
				}
				String port = portField.getText();
				String ip = ipField.getText();
				if (AssertUtils.isEmpty(port, getMessage("message.assert.port.mustnot.empty"))) {
					return;
				}
				if (AssertUtils.isEmpty(ip, getMessage("message.assert.ip.mustnot.empty"))) {
					return;
				}
				try {
					new Thread(new SockClient(ip,Integer.parseInt(port),msgContent)).start();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent actionevent) {
				System.exit(0);
			}
		});
	}

}
