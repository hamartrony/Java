package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

  private Integer number;
  private LocalDate date;
  private Double totalValue;

  //ligação Contrato varias parcelas
  private List<Installment> instalments = new ArrayList<>();

  public Contract(Integer number, LocalDate date, Double totalValue) {
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
  }
  
  //lista usa apenas get, pos set trocaria a lista completa.
  public List<Installment> getInstalments() {
    return instalments;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Contract other = (Contract) obj;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    return true;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }




  


  

  
  
}
