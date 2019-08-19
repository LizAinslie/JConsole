package me.railrunner16.console.message.messages;

import me.railrunner16.console.message.ConsoleMessage;
import me.railrunner16.console.message.ConsoleMessageType;

public class StringConsoleMessage extends ConsoleMessage<String> {
	public StringConsoleMessage(ConsoleMessageType type, String value) {
		super(type, value);
	}

	@Override
	public String getAsString() {
		return this.value;
	}
}
