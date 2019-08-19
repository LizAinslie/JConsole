# RailConsole
_A visual I/O console for Java_

## Adding to Maven
Add the following to your `pom.xml`
```xml
<repositories>
    <repository>
        <id>dmrail-nexus</id>
        <name>DMRail Games Repo</name>
        <url>http://nexus.dmrail.games/repository/maven-releases/</url>
    </repository>
</repositories>
```

And then add the following dependency:
```xml
<dependency>
    <groupId>me.railrunner16</groupId>
    <artifactId>RailConsole</artifactId>
    <version>{version you want to use}</version>
</dependency>
```

## Usage

### Example:
```java
import me.railrunner16.console.Console;

public class Main {
	public static void main(String[] args) {
		Console console = new Console(20, "Welcome!");
		console.run();
		
		String s = console.promptString("Test String: ");
		
		System.out.println(s);
	}
}
```