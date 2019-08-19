package me.railrunner16.console.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class ConsoleInput<T> {
	protected T value;

	public abstract void readFromString(String s);
}
