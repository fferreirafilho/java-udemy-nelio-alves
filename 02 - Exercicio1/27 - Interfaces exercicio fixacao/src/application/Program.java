package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypolService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.println("Entre os dados do contrato: ");
			System.out.print("Numero: ");
			int numero = sc.nextInt();
			sc.nextLine();			
			System.out.print("Data (dd/MM/yyyy):");
			LocalDate date = LocalDate.parse(sc.nextLine(), fmt1);

			System.out.print("Valor do contrato: ");
			Double valor = sc.nextDouble();

			System.out.print("Entre o numero de parcelas: ");
			int parcelas = sc.nextInt();
//			
			Contract contrato = new Contract(numero, date, valor);

			if (parcelas > 0) {
				ContractService contractService = new ContractService(new PaypolService());
				contractService.processContract(contrato, parcelas);
			}
			System.out.println("Parcelas: ");
			for(Installment inst : contrato.getInstallment()){
				System.out.println(inst.getDueDate() + " " + inst.getAmount());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}
}