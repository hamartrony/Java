package services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;


public class ContractServices {

  private OnLinePaymentServices onLinePaymentServices;
 

  public ContractServices(OnLinePaymentServices onLinePaymentServices) {
    this.onLinePaymentServices = onLinePaymentServices;
  }

  public void processContract(Contract contract, Integer months) {
    //total / meses = mensalidade
    double mensalidade = contract.getTotalValue() / months;

    for (int i = 1; i <= months; i++) {
      LocalDate duDate = contract.getDate().plusMonths(i);
      //mensalidade * juros = juros
      double interest = onLinePaymentServices.interest(mensalidade, i);
      //mensalidade + juros * taxa = taxas
      double fee = onLinePaymentServices.paymentFee(mensalidade + interest);
      // mensalidade + taxa + juro = total
      double total = interest + fee + mensalidade;

      //CRIANDO PARCELA i
      contract.getInstalments().add(new Installment(duDate, total));
    }



    
  }



  
  
  
}
