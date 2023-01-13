
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.bank.PaypalService;
import model.entities.Contract;
import model.entities.Installment;
import services.ContractServices;

public class App {
  public static void main(String[] args) throws Exception {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre dados do contrato:");
    System.out.print("Numero: ");
    Integer numero = sc.nextInt();
    System.out.println("Data: ");
    LocalDate date = LocalDate.parse(sc.next(), fmt);
    System.out.println("Valor do Contrato: ");
    Double valor = sc.nextDouble();

    //CRIAÇÃO DO CONTRATO
    Contract obj = new Contract(numero, date, valor);

    System.out.println("Numero de parcelas: ");
    Integer parcelas = sc.nextInt();

    //INSTANCIANDO SERVICO DE CONTRATO, INFORMANDO QUAL BANCO FORNECE TAXAS E JUROS
    ContractServices contractServices = new ContractServices(new PaypalService());
    
    //ACIONANDO O SERVICO DE CONTRATO, QUE GERARA PARCELAS.
    contractServices.processContract(obj, parcelas);

    //IMPRIMINDO PARCELAS DE DENTRO DO CONTRATO
    System.out.println("Parcelas");
    for (Installment installment : obj.getInstalments()) {
      System.out.println(installment);
    }




      sc.close();
    }
}

