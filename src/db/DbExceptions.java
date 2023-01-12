package db;

//Tratamento de erros
public class DbExceptions extends RuntimeException {
  private static final long serialVersionUID = 1L;

  //construtor 
  public DbExceptions(String msg) {
    super(msg);
  }
  
}
