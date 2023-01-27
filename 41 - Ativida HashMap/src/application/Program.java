package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
	try (BufferedReader bf = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {

	    Map<String, Integer> votes = new TreeMap<>();
	    String line = bf.readLine();

	    while (line != null) {

		String[] fields = line.split(",");
		if (votes.containsKey(fields[0])) {
		    votes.put(fields[0], votes.get(fields[0]) + Integer.parseInt(fields[1]));
		} else {
		    votes.put(fields[0], Integer.parseInt(fields[1]));
		}
		line = bf.readLine();
	    }

	    for (String key : votes.keySet()) {
		System.out.println(key + ": " + votes.get(key));
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	}
    }
}
