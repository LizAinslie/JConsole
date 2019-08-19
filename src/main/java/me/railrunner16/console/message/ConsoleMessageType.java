package me.railrunner16.console.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConsoleMessageType {
	IN("<"),
	OUT(">"),
	;

	private String preString;
}
