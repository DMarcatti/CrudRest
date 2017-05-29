package br.com.crud.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.crud.constante.SqlConstante;
import br.com.crud.model.Usuario;


@Repository
public class UsuarioImp  implements UsuarioDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
	     //String SQL = "insert into USUARIO (id, nome, login, senha) VALUES (?, ?, ?, ?)";
	     jdbcTemplate.update(SqlConstante.SQL_USER_INSERT,usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		//String SQL = "update usuario set nome = ? , login = ?, senha= ? where id = ?";
        jdbcTemplate.update(SqlConstante.SQL_USER_UPDATE,usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getId());
	}

	@Override
	public void deleteUsuarioById(long id) {
		// TODO Auto-generated method stub
		//String SQL = "delete fusuario where id = ?";
        jdbcTemplate.update(SqlConstante.SQL_USER_DELETE_ID,id);
		
	}

	@Override
	public void deleteAllUsuarios() {
		// TODO Auto-generated method stub
		//String SQL = "delete from usuario";
        jdbcTemplate.update(SqlConstante.SQL_USER_DELETE_ALL);
		
	}

	@Override
	public Usuario findById(long id) {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM USUARIO WHERE ID = ?";
		return (Usuario) jdbcTemplate.queryForObject(
				SqlConstante.SQL_USER_FIND_ID, new Object[] { id }, new UsuarioMapper());
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM USUARIO";
//		List<Usuario> usuarios = jdbcTemplate.query(
//				SqlConstante.SQL_USER_FIND_ALL, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		return jdbcTemplate.query(
				SqlConstante.SQL_USER_FIND_ALL, new BeanPropertyRowMapper<Usuario>(Usuario.class));

	}

	@Override
	public List<Usuario> findByName(String name) {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM USUARIO WHERE NOME like :name";
		return jdbcTemplate.query(
				SqlConstante.SQL_USER_FIND_NAME, new Object[] { name } , new BeanPropertyRowMapper<Usuario>(Usuario.class));

	}

}
