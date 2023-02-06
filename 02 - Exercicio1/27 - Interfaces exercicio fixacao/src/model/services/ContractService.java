package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		List<Installment> installment = new ArrayList<Installment>();
		for (int i = 1; i <= months; i++) {
			
			Double composto = this.onlinePaymentService.interest(contract.getTotalValue() / months, i);

			composto += this.onlinePaymentService.paymentFee(composto);
			
			installment.add(new Installment(contract.getDate().plusMonths(i), composto));
		}
		contract.setInstallment(installment);
	}
}