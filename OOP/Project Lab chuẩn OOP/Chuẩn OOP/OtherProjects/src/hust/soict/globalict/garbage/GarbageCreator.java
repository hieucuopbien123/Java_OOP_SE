package hust.soict.globalict.garbage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//read file by String with operator + which is low-performance
		String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./src/hust/soict/globalict/garbage/text.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       data += line;
		       data += "\n";
		    }
		}
		System.out.println(data);
	}
}
