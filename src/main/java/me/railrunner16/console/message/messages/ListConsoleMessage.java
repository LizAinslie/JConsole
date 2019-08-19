package me.railrunner16.console.message.messages;

import java.util.List;

import me.railrunner16.console.message.ConsoleMessage;
import me.railrunner16.console.message.ConsoleMessageType;

/**
 * A list-based console message.
 * @author RailRunner16
 */
public class ListConsoleMessage<T> extends ConsoleMessage<List<T>> {
    /**
     * Create a new list-based console message.
     * @param type The type of message.
     * @param l The list.
     */
    public ListConsoleMessage(ConsoleMessageType type, List<T> l) {
        super(type, l);
    }

    /**
     * Create a new list-based console message with a default type of <code>ConsoleMessageType.OUT</code>.
     * @param l
     */
    public ListConsoleMessage(List<T> l) {
        this(ConsoleMessageType.OUT, l);
    }

    /**
     * Serialize the value list to a string.
     */
    @Override
    public String getAsString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this.value) sb.append("- " + item.toString() + "\n");
        return sb.toString();
    }
}