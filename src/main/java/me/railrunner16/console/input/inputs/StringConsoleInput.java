package me.railrunner16.console.input.inputs;

import me.railrunner16.console.input.ConsoleInput;

/**
 * A string-based console input.
 * @author RailRunner16
 */
public class StringConsoleInput extends ConsoleInput<String> {
	/**
	 * Create a new string-based console input.
	 * @param s The string.
	 */
	public StringConsoleInput(String s) {
		super(s);
	}

	/**
	 * Create a new string-based console input with a null value.
	 */
	public StringConsoleInput() {
		this(null);
	}

	@Override
	public void readFromString(String s) {
		this.value = s;
	}
}
