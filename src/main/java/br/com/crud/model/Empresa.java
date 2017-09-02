package br.com.crud.model;

public class Empresa {

		private int id;
		private int cnpj;
		private String nome;

	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCnpj() {
			return cnpj;
		}
		public void setCnpj(int cnpj) {
			this.cnpj = cnpj;
		}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
