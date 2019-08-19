package me.railrunner16.console.input.inputs;

import me.railrunner16.console.input.ConsoleInput;

public abstract class EnumConsoleInput<T extends Enum<T>> extends ConsoleInput<T> {
	public EnumConsoleInput(T tEnum) {
		super(tEnum);
	}
}
