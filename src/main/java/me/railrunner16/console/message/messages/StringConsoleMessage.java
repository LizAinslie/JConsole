package me.railrunner16.console.message.messages;

import me.railrunner16.console.message.ConsoleMessage;
import me.railrunner16.console.message.ConsoleMessageType;

/**
 * A console message containing a string.
 * @author RailRunner16
 */
public class StringConsoleMessage extends ConsoleMessage<String> {
	/**
	 * Create a new string-based console message.
	 * @param type The type of message.
	 * @param s The string.
	 */
	public StringConsoleMessage(ConsoleMessageType type, String s) {
		super(type, s);
	}
	
	/**
	 * Create a new string-based console message with a default type of <code>ConsoleMessageType.OUT</code>.
	 * @param s The string.
	 */
	public StringConsoleMessage(String s) {
		this(ConsoleMessageType.OUT, s);
	}

	/**
	 * Get the contained string.
	 * @return The contained string.
	 */
	@Override
	public String getAsString() {
		return this.value;
	}
}
