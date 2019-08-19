package me.railrunner16.console.message;

import lombok.Getter;

@Getter
public abstract class ConsoleMessage<T> {
	private final ConsoleMessageType type;
	protected final T value;

	public ConsoleMessage(ConsoleMessageType type, T value) {
		this.type = type;
		this.value = value;
	}

	public String getPreString() {
		return this.type.getPreString();
	}

	public abstract String getAsString();
}
