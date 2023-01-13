package model.entities;

import java.time.LocalDate;

//prestação, parcela
public class Installment {
  private LocalDate dueDate;
  private Double amount;

  public Installment(LocalDate dueDate, Double amount) {
    this.dueDate = dueDate;
    this.amount = amount;
  }



  public java.time.LocalDate getDueDate() {
    return dueDate;
  }



  public void setDueDate(java.time.LocalDate dueDate) {
    this.dueDate = dueDate;
  }



  public Double getAmount() {
    return amount;
  }



  public void setAmount(Double amount) {
    this.amount = amount;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
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
    Installment other = (Installment) obj;
    if (dueDate == null) {
      if (other.dueDate != null)
        return false;
    } else if (!dueDate.equals(other.dueDate))
      return false;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Installment [dueDate=" + dueDate + ", amount=" + amount + "]";
  }



  

  

  
   
}
