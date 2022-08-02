package hust.soict.globalict.garbage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NoGarbage {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//We use StringBuilder to improve the code
		Path path = Paths.get("./src/hust/soict/globalict/garbage/text.txt");
		StringBuilder sb = new StringBuilder();

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(s -> sb.append(s).append("\n"));
		} catch (IOException ex) {
			// Handle exception
		}

		String contents = sb.toString();
		System.out.println(contents);
	}
}
