package pers.bwr.translaterForPerson.GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pers.bwr.translaterForPerson.GUI.reout.ConsoleText;

public class Progress {
	JFrame prog;
	JLabel explainTxt;
	JTextArea information;
	String content;
	
	@SuppressWarnings("static-access")
	public Progress() {
		prog = new JFrame("正在翻译中。");
		prog.setDefaultLookAndFeelDecorated(true);
		prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prog.pack();
		prog.setBounds(600, 300, 500, 400);
		explainTxt = new JLabel("正在处理中，任务结束前强制关闭本程序会导致结果丢失。");
		JPanel panl = new JPanel();
		panl.add(explainTxt);
		prog.add(panl, BorderLayout.NORTH);
		information = new ConsoleText();
		content = "";
		information.setText(content);
		JScrollPane scrlp = new JScrollPane();
		scrlp.setViewportView(information);
		prog.add(scrlp,BorderLayout.CENTER);
		
		
		
		
		prog.setVisible(true);
	}
	
	
	
	
	
}
