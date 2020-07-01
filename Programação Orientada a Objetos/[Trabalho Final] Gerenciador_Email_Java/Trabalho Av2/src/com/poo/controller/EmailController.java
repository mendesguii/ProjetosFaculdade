package com.poo.controller;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.poo.dao.ClienteDAO;
import com.poo.dao.EmailDAO;
import com.poo.dao.MensagemDAO;
import com.poo.model.Email;
import com.poo.model.EmailMensagem;
import com.poo.model.Mensagem;

public class EmailController {

	public void Create(Email Email)
	{
		try
		{
			EmailDAO dao = new EmailDAO();
			dao.Create(Email);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}
	public ResultSet ReadAll(String email)
	{	ResultSet Emails1;
		try
		{
			EmailDAO dao = new EmailDAO();

			Emails1 = dao.readAll(email);

		}
		finally{
			System.out.println("Fim da Pesquisa");
		}
		return Emails1;

	}

	public void Delete(Email Email)
	{
		try
		{
			EmailDAO dao = new EmailDAO();
			dao.Delete(Email);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}

	public boolean Enviar_email(String Origem,String Destino,String Assunto,String Mensagem)
	{
		try {
		// Cria mensagem no banco 
		MensagemController m1 = new MensagemController();
		Mensagem mensagem1 = new Mensagem();
		mensagem1.setAssunto(Assunto);
		mensagem1.setMensagem(Mensagem);
		m1.Create(mensagem1);
		String IDMensagem = m1.RetornaIDMensagem(mensagem1);
		
		
		// Cria email no banco		
		ClienteController c1 = new ClienteController();
		Email e1 = new Email();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String datastring = formatter.format(date);
			
		
		String IDOrigem = c1.PesquisarUsuario(Origem);
		String IDDestino = c1.PesquisarUsuario(Destino);
		e1.setId_cliente_destino(Integer.valueOf(IDDestino));
		e1.setId_cliente_origem(Integer.valueOf(IDOrigem));
		e1.setId_mensagem(Integer.valueOf(IDMensagem));
		e1.setData_envio(datastring);
		
		EmailDAO dao = new EmailDAO();
		dao.Create(e1);	
		
		}
		finally
		{
			System.out.println("Fim do envio do e-mail");
		}
		return true;
	}
	public void ApagarEmail(EmailMensagem Email)
	{
		try
		{
			Email e1 = new Email();
			EmailDAO dao = new EmailDAO();
			MensagemDAO dao2 = new MensagemDAO();
			
			//Email.getEmail_origem()
			e1.setData_envio(Email.getData_envio());
			e1.setId_cliente_origem(Integer.valueOf(Email.getEmail_origem()));
			//e1.setId_email(Integer.valueOf(dao.Id_Email(e1)));
			
			Mensagem m1 = new Mensagem();
			m1.setAssunto(Email.getAssunto());
			m1.setMensagem(Email.getMensagem());
			m1.setId_mensagem(Integer.valueOf(dao2.RetornaIDMensagem(m1)));
			
			dao.Delete(e1);
			dao2.Delete(m1);
			
		}
		finally{
			System.out.println("Fim da remoção do email e mensagem");
		}
	}




}
