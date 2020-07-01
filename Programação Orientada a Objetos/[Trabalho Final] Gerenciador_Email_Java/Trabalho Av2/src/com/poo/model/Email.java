package com.poo.model;

public class Email {

	private int id_email,id_cliente_destino,id_cliente_origem,id_mensagem;
	private String data_envio;
	
	public int getId_email() {
		return id_email;
	}
	public void setId_email(int id_email) {
		this.id_email = id_email;
	}
	public int getId_cliente_destino() {
		return id_cliente_destino;
	}
	public void setId_cliente_destino(int id_cliente_destino) {
		this.id_cliente_destino = id_cliente_destino;
	}
	public int getId_cliente_origem() {
		return id_cliente_origem;
	}
	public void setId_cliente_origem(int id_cliente_origem) {
		this.id_cliente_origem = id_cliente_origem;
	}
	public int getId_mensagem() {
		return id_mensagem;
	}
	public void setId_mensagem(int id_mensagem) {
		this.id_mensagem = id_mensagem;
	}
	public String getData_envio() {
		return data_envio;
	}
	public void setData_envio(String data_envio) {
		this.data_envio = data_envio;
	}
	
	
}
