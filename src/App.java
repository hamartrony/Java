import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import db.DB;
import db.DbExceptions;

public class App {
    public static void main(String[] args) throws Exception {
      System.out.println("Hello, World!");
       
     
      Connection conn = null; //instanciando Conection
      Statement st = null; //instanciando metodo de escrita SQL
      ResultSet rs = null; //instanciando metodo de recepçao de dados

      //RECUPERANDO DADOS DO BANCO
      try{

        conn = DB.getConnection();  //ativa conexao
        st = conn.createStatement();//Statement deixa de ser nulo
        rs = st.executeQuery("select * from department"); //armazena em rs o resultado da busca
        
        while(rs.next()){
          System.out.println(rs.getInt("Id") + ", " + rs.getString("name"));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      
    

      //INSERIR DADOS
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      PreparedStatement pst = null; //preparar SQL para injeção de dados
      try{
        pst = conn.prepareStatement(
          "INSERT INTO seller "
          +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
          + "VALUES (?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS
        );
        pst.setString(1, "Hamart Rony");
        pst.setString(2, "hamart@gmail.com");
        //convertedo data em sqlDate, de simpleDateFormate.
        pst.setDate(3,new java.sql.Date(sdf.parse("28/04/1988").getTime()));
        pst.setDouble(4, 4000);
        pst.setInt(5,4);
        int rows = pst.executeUpdate(); //executa insercao e retorna qtd linhas afetadas

        if (rows > 0) {
          ResultSet rst = pst.getGeneratedKeys();
          while (rst.next()) {
            int id = rs.getInt(1);
            System.out.println("id: " + id);
          }
        }else{System.out.println("No Rows affected!");}



        System.out.println("Verifique seu banco");
      }catch(SQLException e ){
        System.out.println(e.getMessage());
      }

      //ATUALIZAR DADOS
      PreparedStatement psup = null;
      try{
        psup = conn.prepareStatement(
          "UPDATE seller "
          +"SET BaseSalary = BaseSalary + ? "
          + "WHERE (DepartmentId = ?)"
        );
        psup.setDouble(1, 200.0);
        psup.setInt(2, 2);
        psup.executeUpdate();
      } catch (SQLException e) {
        System.out.println(e.getMessage());

      }
      
      //DELETAR DADOS
      try{
        PreparedStatement psdel = conn.prepareStatement(
          "DELETE FROM department "
          + "WHERE Id = ?"
        );
        psdel.setInt(1, 5);
        psdel.executeUpdate();
      } catch (SQLException e) {
        throw new DbExceptions(e.getMessage());
      }



      
      DB.closeResultSet(rs);
      DB.closeStatment(st);
      DB.closeConnection();
  }
}
