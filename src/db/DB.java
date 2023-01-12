package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
  //metodo de conexao do java sql Conection, instanciado em conn.
  private static Connection conn = null;

  //metodo getConnection que faz a conexao, ou retorna erro
  public static Connection getConnection() {
    if (conn == null) {
      try {
        //criar obj props apartir da classe Properties, para armazenar as definiçoes do banco
        //o arquivo com config esta na raiz do projeto db.properties
        Properties props = loadProperties();
        String url = props.getProperty("dburl"); //definindo a url (de dentro de configs)
        conn = DriverManager.getConnection(url, props); //definindo conn passando as configurações do arquivo.
      } catch (SQLException e) {
        throw new DbExceptions(e.getMessage());
      }
    }
    return conn;
  }
  
  //metodo que fecha conexao
  public static void closeConnection() {
    if (conn != null) {
      try{
        conn.close();
      } catch (SQLException e) {
        throw new DbExceptions(e.getMessage());
      }
    } 
  }

  //metodo retorna um objeto do tipo PROPERTIES do JAVA
  private static Properties loadProperties() {

    //Tentar ler o arquivo properties e armazenar o conteudo em fs
    try (FileInputStream fs = new FileInputStream("db.properties")) {
      Properties props = new Properties(); // cria um obj de propriedade JAVA
      props.load(fs); //carrega fs para o obj de propriedades
      return props;
    } catch (IOException e) { // esta excecao estava em return, causada na possivel falha de localizar o arquivo
      throw new DbExceptions(e.getMessage()); //encaminha o erro para exeção personalizada
    }

  }
  
  //FECHANDO AS CONEXOES DE STATMENT E RESULTSET:
  public static void closeStatment(Statement st) {
    if (st != null) {
      try{
        st.close();
      } catch (SQLException e) {
        throw new DbExceptions(e.getMessage());

      }
    }
  }

    public static void closeResultSet(ResultSet rs) {
    if (rs != null) {
      try{
        rs.close();
      } catch (SQLException e) {
        throw new DbExceptions(e.getMessage());

      }
    }
  }

  
}
