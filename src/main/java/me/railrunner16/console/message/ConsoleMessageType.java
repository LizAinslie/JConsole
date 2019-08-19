package me.railrunner16.console.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type of a console message.
 * @author RailRunner16
 */
@Getter @AllArgsConstructor
public enum ConsoleMessageType {
	IN("<"),
	OUT(">"),
	;

	private String preString;
}
