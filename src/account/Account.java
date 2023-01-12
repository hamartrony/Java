package account;


public class Account {
  private Integer accountNumber;
  private String clientName;
  private Double balance;
  private Double limitWithdraw;

  public Account(Integer accountNumber, String clientName, Double balance, Double limitWithdraw) {
    this.accountNumber = accountNumber;
    this.clientName = clientName;
    this.balance = balance;
    this.limitWithdraw = limitWithdraw;
  }


  public Double withdraw(Double withdraw) {
    if (withdraw > limitWithdraw) {
      throw new AccExceptions("O valor limite de saque foi utrapassado!");
    }
    if (withdraw > balance) {
      throw new AccExceptions("Voce nao tem saldo suficiente!");
    }
    Double saldo = balance - withdraw;
    return saldo;
  }
  
  
  public Integer getAccountNumber() {
    return accountNumber;
  }


  
  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }
  
  
  
  public String getClientName() {
    return clientName;
  }
  
  
  
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }
  
  
  
  public Double getBalance() {
    return balance;
  }
  
  
  
  public void setBalance(Double balance) {
    this.balance = balance;
  }
  
  
  
  public Double getLimitWithdraw() {
    return limitWithdraw;
  }



  public void setLimitWithdraw(Double limitWithdraw) {
    this.limitWithdraw = limitWithdraw;
  }






  
  
}
