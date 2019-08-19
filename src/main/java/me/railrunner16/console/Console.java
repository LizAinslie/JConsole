package me.railrunner16.console;

import me.railrunner16.console.message.ConsoleMessage;
import me.railrunner16.console.message.ConsoleMessageType;
import me.railrunner16.console.message.messages.StringConsoleMessage;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Console extends JPanel implements KeyListener, Runnable {
	public static final long serialVersionUID = 1L;

	private JList<String> messages;
	private DefaultListModel<String> lModel = new DefaultListModel<>();

	private JTextField textInputField;
	private String text = null;

	public Console(int columns, String welcome) {
		super(new BorderLayout());

		this.textInputField = new JTextField(columns);
		this.textInputField.addKeyListener(this);
		this.textInputField.setVisible(false);
		this.add(this.textInputField, BorderLayout.PAGE_END);

		this.messages = new JList<>(this.lModel);
		this.messages.setAutoscrolls(true);
		this.add(this.messages, BorderLayout.CENTER);

		this.setSize(this.textInputField.getColumns() * 10, 400);

		if (welcome != null) this.sendMessage(new StringConsoleMessage(ConsoleMessageType.OUT, welcome));
	}

	public Console(int columns) {
		this(columns, null);
	}

	public Console(String welcome) {
		this(20, welcome);
	}

	public Console() {
		this(20);
	}

	public void sendMessage(ConsoleMessage<?> message) {
		this.lModel.addElement(message.getPreString() + " " + message.getAsString());
	}

	public String promptString(String prompt) {
		try {
			this.sendMessage(new StringConsoleMessage(ConsoleMessageType.OUT, prompt));

			this.textInputField.setVisible(true);

			while (this.text == null) Thread.sleep(500);

			String cacheText = this.text;
			this.text = null;

			return cacheText;
		} catch (InterruptedException exception) {
			return "";
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {}
	@Override
	public void keyTyped(KeyEvent keyEvent) {}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				String text = this.textInputField.getText();
				this.text = text;
				this.sendMessage(new StringConsoleMessage(ConsoleMessageType.IN, text));
				this.textInputField.setVisible(false);
				break;
			default:
				break;
		}
	}

	@Override
	public void run() {
		JFrame f = new JFrame("Console");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(this, BorderLayout.CENTER);
		f.pack();
		f.setSize(this.textInputField.getColumns() * 10, 400);
		f.setVisible(true);
	}

//	public static void main(String[] args) {
//		Console c = new Console("Welcome!");
//		c.run();
//
//		String s = c.promptString("Enter a test string: ");
//		System.out.println(s);
//	}
}
