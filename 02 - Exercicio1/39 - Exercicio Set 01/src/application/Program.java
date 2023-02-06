package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter file full path: ");
	String path = sc.nextLine();

	try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
	    Set<LogEntry> set = new HashSet<>();

	    String line = bf.readLine();
	    while (line != null) {
		String[] fields = line.split(" ");
		set.add(new LogEntry(fields[0], LocalDateTime.parse(fields[1])));
		line = bf.readLine();
	    }
	    System.out.println("Users: " + set.size());
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}