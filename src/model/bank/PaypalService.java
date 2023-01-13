package model.bank;

import services.OnLinePaymentServices;

public class PaypalService implements OnLinePaymentServices {

  @Override
  public double paymentFee(double amount) {
    //valor da parcela, taxa 2%
    return amount * 0.02;
  }

  @Override
  public double interest(double amount, int months) {
   
    //valor da parcela, juro simples, indice do mes para calculo do juros
    return amount * 0.01 * months;
  }
  

}
