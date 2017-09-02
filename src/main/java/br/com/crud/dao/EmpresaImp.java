package br.com.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.crud.constante.SqlConstante;
import br.com.crud.model.Empresa;

@Repository
public class EmpresaImp implements EmpresaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public void salvar(Empresa empresa) {
		// TODO Auto-generated method stub
	     jdbcTemplate.update(SqlConstante.SQL_EMPRESA_INSERT
				 , empresa.getCnpj()
				 , empresa.getNome());
	}

}
