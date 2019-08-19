package me.railrunner16.console.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A console message.
 * @author RailRunner16
 */
@Getter @AllArgsConstructor
public abstract class ConsoleMessage<T> {
	private final ConsoleMessageType type;
	protected final T value;

	/**
	 * Get the console message as a string.
	 * @return The value as a string.
	 */
	public abstract String getAsString();
}
