package application;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

    public static void main(String[] args) {
	// Não mantem ordem mas é mais rapido
	Set<String> set = new HashSet<>();

	set.add("TV");
	set.add("Notebook");
	set.add("Tablet");

	System.out.println(set.contains("Notebook"));

	for (String p : set) {
	    System.out.println(p);
	}
	System.out.println("\n-----------------------------------------------------------\n");

	// Ordem ASCII
	set = new TreeSet<>();

	set.add("TV");
	set.add("Notebook");
	set.add("Tablet");

	for (String p : set) {
	    System.out.println(p);
	}

	System.out.println("\n-----------------------------------------------------------\n");

	// Mantem a ordem de inserção
	set = new LinkedHashSet<>();

	set.add("TV");
	set.add("Notebook");
	set.add("Tablet");

	set.remove("Notebook");
	set.removeIf(x -> x.length() >= 3);

	for (String p : set) {
	    System.out.println(p);
	}
    }
}