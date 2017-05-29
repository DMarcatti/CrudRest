package br.com.crud.dao;

import java.util.List;

import br.com.crud.model.Usuario;

public interface UsuarioDao {
	
	void salvar(Usuario usuario);
	void updateUsuario(Usuario usuario);
	void deleteUsuarioById(long id);
	void deleteAllUsuarios();
	
	Usuario findById(long id); 
	List<Usuario> findAllUsuarios();
	List<Usuario> findByName(String name);
	

}
