package me.railrunner16.console;

import me.railrunner16.console.message.ConsoleMessage;
import me.railrunner16.console.message.ConsoleMessageType;
import me.railrunner16.console.message.messages.StringConsoleMessage;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * A visual I/O console.
 * @author RailRunner16
 */
public class Console extends JPanel implements KeyListener, Runnable {
	public static final long serialVersionUID = 1L;

	private JList<String> messages;
	private DefaultListModel<String> lModel = new DefaultListModel<>();

	private JTextField textInputField;
	private String text = null;

	/**
	 * Create a new console.
	 * @param columns The amount of columns.
	 * @param welcome The welcome message.
	 */
	public Console(int columns, String welcome) {
		super(new BorderLayout());

		this.textInputField = new JTextField(columns);
		this.textInputField.addKeyListener(this);
		this.textInputField.setEnabled(false);
		this.add(this.textInputField, BorderLayout.PAGE_END);

		this.messages = new JList<>(this.lModel);

		JScrollPane pane = new JScrollPane(this.messages);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		this.add(pane, BorderLayout.CENTER);

		this.setSize(this.textInputField.getColumns() * 10, 400);

		if (welcome != null) this.sendMessage(new StringConsoleMessage(ConsoleMessageType.OUT, welcome));
	}

	/**
	 * Create a new console with no welcome message and a specific amount of columns.
	 * @param columns The amount of columns.
	 */
	public Console(int columns) {
		this(columns, null);
	}

	/**
	 * Create a new console with default columns and a custom welcome message.
	 * @param welcome The welcome message.
	 */
	public Console(String welcome) {
		this(20, welcome);
	}

	/**
	 * Create a console with default columns and no welcome message.
	 */
	public Console() {
		this(20);
	}

	/**
	 * Send a message to the console.
	 * @param message The message to send.
	 */
	public void sendMessage(ConsoleMessage<?> message) {
		this.lModel.addElement(message.getType().getPreString() + " " + message.getAsString());

		this.messages.setSelectedIndex(this.messages.getModel().getSize() - 1);
		this.messages.ensureIndexIsVisible(this.messages.getSelectedIndex());
	}

	/**
	 * Send a string-based console message.
	 * @param s The string to send.
	 */
	public void sendMessage(String s) {
		this.sendMessage(new StringConsoleMessage(s));
	}

	/**
	 * Send an empty message.
	 */
	public void sendMessage() {
		this.lModel.addElement("");

		this.messages.setSelectedIndex(this.messages.getModel().getSize() - 1);
		this.messages.ensureIndexIsVisible(this.messages.getSelectedIndex());
	}

	/**
	 * Prompt the user for a string.
	 * @param prompt The prompt text.
	 * @return The result of the prompt.
	 */
	public String promptString(String prompt) {
		try {
			this.sendMessage(new StringConsoleMessage(ConsoleMessageType.OUT, prompt));

			this.textInputField.setEnabled(true);
			this.textInputField.setText(null);
			this.textInputField.grabFocus();

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

				this.textInputField.setEnabled(false);
				this.textInputField.setText(null);
				break;
			default:
				break;
		}
	}

	/**
	 * Run the console.
	 */
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
}
