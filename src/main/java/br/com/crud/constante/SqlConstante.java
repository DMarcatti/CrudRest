package br.com.crud.constante;

public class SqlConstante {

	  public static String SQL_USER_INSERT      = "INSERT INTO USUARIO (ID, NOME, LOGIN, SENHA, DTANASCIMENTO, TELEFONE) VALUES (?, ?, ?, ?, ?, ?)";
	  public static String SQL_USER_UPDATE      = "UPDATE USUARIO SET NOME = ? , LOGIN = ?, SENHA= ? WHERE ID = ?";
	  public static String SQL_USER_DELETE_ID   = "DELETE FROM USUARIO WHERE ID = ?";
	  public static String SQL_USER_DELETE_ALL  = "DELETE FROM USUARIO";
	  public static String SQL_USER_FIND_ID     = "SELECT * FROM USUARIO WHERE ID = ?";
	  public static String SQL_USER_FIND_ALL    = "SELECT * FROM USUARIO";
	  public static String SQL_USER_FIND_NAME   = "SELECT * FROM USUARIO WHERE NOME LIKE :NAME";	

	  public static String SQL_EMPRESA_INSERT      = "INSERT INTO EMPRESA (ID, CNPJ, NOME) VALUES ( nextval('id'), ?, ?)";

}
