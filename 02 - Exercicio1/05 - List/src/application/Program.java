package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Ol? mundo");
		list.add("Fernando");
		list.add("Jose");
		list.add("Joao");
		list.add("Maria");
		list.add("Antonio");
		list.add(2, "Marco");
		System.out.println("-----------------");

		list.removeIf(x -> x.toUpperCase().contains("C"));
		for (String item : list) {
			System.out.println(item);
		}

		System.out.println("-----------------");
		System.out.println("Index of Fernando: " + list.indexOf("Fernando"));
		System.out.println("Index of Marco: " + list.indexOf("Marco"));
		System.out.println("-----------------");
//		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').toList();
		List<String> result = list.stream().filter(x -> x.toUpperCase().charAt(0) == 'A').collect(Collectors.toList());
		for (String item : result) {
			System.out.println(item);
		}
		System.out.println("-----------------");
		String name = list.stream().filter(x -> x.toUpperCase().charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(name);
		System.out.println("-----------------");
		name = list.stream().filter(x -> x.toUpperCase().charAt(0) == 'L').findFirst().orElse(null);
		System.out.println(name);

	}

}
