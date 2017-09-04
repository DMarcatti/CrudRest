package br.com.crud.dao;

import java.util.List;

import br.com.crud.model.Empresa;

public interface EmpresaDao {

	void salvar(Empresa empresa);
	List<Empresa> findAll();
	void deleteEmpresaById(long id);



}
