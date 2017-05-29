package br.com.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.crud.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	 Usuario usuario = new Usuario();
    	
    	 usuario.setId(rs.getLong("id"));
    	 usuario.setNome(rs.getString("nome"));
    	 usuario.setLogin(rs.getString("login"));
    	 usuario.setSenha(rs.getString("senha"));
    	 	
    	 return usuario;
    }

}
