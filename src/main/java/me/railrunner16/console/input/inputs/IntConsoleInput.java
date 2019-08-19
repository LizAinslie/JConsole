package me.railrunner16.console.input.inputs;

import me.railrunner16.console.input.ConsoleInput;

/**
 * An integer-based console input.
 * @author RailRunner16
 */
public class IntConsoleInput extends ConsoleInput<Integer> {
	/**
	 * Create a new integer-based console input.
	 * @param i The integer.
	 */
	public IntConsoleInput(int i) {
		super(i);
	}

	/**
	 * Create a new integer-based console input with a 0 value.
	 */
	public IntConsoleInput() {
		this(0);
	}

	/**
	 * Read a string into the value.
	 * @param s The string.
	 */
	@Override
	public void readFromString(String s) {
		this.value = Integer.parseInt(s);
	}
}
