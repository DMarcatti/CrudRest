package br.com.crud.model;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.crud.validation.Telefone;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9048353933718054104L;
	
	private long    id;
	
	@NotEmpty
	@Size(min=2, max=30)
	private String nome;
	@NotEmpty
	@Size(min=2, max=30)
	private String login;
	@NotEmpty
	@Size(min=5, max=10)
	private String senha;
	
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull @Past
	private Date dataAniversario;
    
    @Telefone
	private String telefone;    
	
	public Usuario (){}
	public Usuario (long id, String nome, String login, String senha){
		
		this.nome  = nome;
		this.login = login;
		this.senha = senha;
		this.id    = id ;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setId(long id) {
		this.id = id;
	}

	
}
