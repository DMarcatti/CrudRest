package br.com.crud.constante;

public class SqlConstante {

	public static String SQL_USER_INSERT      = "insert into USUARIO (id, nome, login, senha) VALUES (?, ?, ?, ?)";
	public static String SQL_USER_UPDATE      = "update usuario set nome = ? , login = ?, senha= ? where id = ?";
	public static String SQL_USER_DELETE_ID   = "delete from usuario where id = ?";
	public static String SQL_USER_DELETE_ALL  = "delete from usuario";
	public static String SQL_USER_FIND_ID     = "SELECT * FROM USUARIO WHERE ID = ?";
	public static String SQL_USER_FIND_ALL    = "SELECT * FROM USUARIO";
	public static String SQL_USER_FIND_NAME   = "SELECT * FROM USUARIO WHERE NOME like :name";
	
}
