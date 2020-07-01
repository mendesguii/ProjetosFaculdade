package com.poo.model;

public class Cliente {
	private int id_cliente;
	private String nome;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id) {
		this.id_cliente = id;
	}
	
	

}
