package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.MensagemDAO;
import com.poo.model.Mensagem;

public class MensagemController {

	public void Create(Mensagem Mensagem)
	{
		try
		{
			MensagemDAO dao = new MensagemDAO();
			dao.Create(Mensagem);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}
	public List<Mensagem> ReadAll()
	{	List<Mensagem> Mensagems1 =  new ArrayList<Mensagem>();
		try{
			MensagemDAO dao = new MensagemDAO();

			Mensagems1 = dao.readAll();

		}
		finally{
			System.out.println("Fim da Pesquisa");
		}
		return Mensagems1;

	}

	public void Delete(Mensagem Mensagem)
	{
		try
		{
			MensagemDAO dao = new MensagemDAO();
			dao.Delete(Mensagem);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}

	public String RetornaIDMensagem(Mensagem Mensagem)
	{
		try
		{
			MensagemDAO dao = new MensagemDAO();
			dao.RetornaIDMensagem(Mensagem);
			return dao.RetornaIDMensagem(Mensagem);
		}
		finally{
			System.out.println("Fim do retorno da mensagem");
		}
	}

}
