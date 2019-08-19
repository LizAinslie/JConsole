package me.railrunner16.console.example;

import me.railrunner16.console.Console;

public class ConsoleExample {
	public static void main(String[] args) {
		Console console = new Console(20, "Welcome!");
		console.run();

		String s = console.promptString("Test String: ");
		System.out.println(s);

		String s2 = console.promptString("Test String: ");
		System.out.println(s2);
	}
}
