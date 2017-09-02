package br.com.crud.dao;

import java.util.List;

import br.com.crud.model.Empresa;
import br.com.crud.model.Usuario;

public interface EmpresaDao {

	void salvar(Empresa empresa);
	List<Empresa> findAll();


}
