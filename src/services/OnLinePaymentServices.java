package services;

public interface OnLinePaymentServices {

  double paymentFee(double amount);

  double interest(double amount, int months);
  
}
