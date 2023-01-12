
import java.text.ParseException;
import java.util.Scanner;

import account.AccExceptions;
import account.Account;

public class App {
  public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);

    System.out.println("Account Number ");
    Integer accountNumber  = sc.nextInt();
    sc.nextLine();
    System.out.print("Name : ");
    String clientName = sc.next();
    sc.nextLine();
    System.out.print("balance : ");
    Double balance = sc.nextDouble();
    sc.nextLine();
    System.out.print("limitWithdraw : ");
    Double limitWithdraw = sc.nextDouble();
      sc.nextLine();
    Account acc1 = new Account(accountNumber, clientName, balance, limitWithdraw);

    System.out.print("Valor do saque : ");
    Double withdraw = sc.nextDouble();
    try{
      Double saldo = acc1.withdraw(withdraw);
      System.out.println("O saldo e " + saldo);
    }catch(AccExceptions e){
      System.out.println(e.getMessage());
    }
    
    sc.close();

  }
    
}
