package br.com.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				SqlConstante.SQL_EMPRESA_FIND_ALL, new BeanPropertyRowMapper<Empresa>(Empresa.class));
	}

	@Override
	public void deleteEmpresaById(long id) {
		// TODO Auto-generated method stub
        jdbcTemplate.update(SqlConstante.SQL_EMPRESA_DELETE_ID,id);
	}

}
