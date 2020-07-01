package com.poo.model;

public class Mensagem {
	private int id_mensagem;
	private String assunto,mensagem;
	public int getId_mensagem() {
		return id_mensagem;
	}
	public void setId_mensagem(int id_mensagem) {
		this.id_mensagem = id_mensagem;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
