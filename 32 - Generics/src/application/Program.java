package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PrintService<Integer> pi = new PrintService<>();
		PrintService<String> ps = new PrintService<>();
		
		System.out.print("How many values? ");		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int value = sc.nextInt();
			pi.addValue(value);
		}
		
		pi.print();
		
		System.out.println("First: "+ pi.first());
		
		System.out.print("How many values? ");		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String value = sc.nextLine();
			ps.addValue(value);
		}
		
		ps.print();
		
		System.out.println("First: "+ ps.first());
		
		
		sc.close();
	}

}
