package application;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Program {

	public static void main(String[] args) {
		String[] lines = new String[] { "Good morning", "Good afernoon", "Good nigth" };

		String path = "c:\\temp\\out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
