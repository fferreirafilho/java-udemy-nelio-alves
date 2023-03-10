package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the quantity of rows: ");
		int l = sc.nextInt();
		System.out.print("Enter the quantity of columns: ");
		int c = sc.nextInt();
		int[][] mat = new int[l][c];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		System.out.println("\n");
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print("Enter the number you are lookin for: ");
		int number = sc.nextInt();

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				if (mat[i][j] == number) {
					System.out.println("Position " + i + "," + j + ":");
					if (j - 1 >= 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					if (j + 1 <= l) {
						System.out.println("Rigth: " + mat[i][j + 1]);
					}
					if (i - 1 >= 0) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					if (i + 1 <= l) {
						System.out.println("Down: " + mat[i + 1][j]);
					}
				}
			}
		}

		sc.close();
	}

}
