package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.ClienteDAO;
import com.poo.model.Cliente;

public class ClienteController {

	public void Create(Cliente cliente)
	{
		try
		{
			ClienteDAO dao = new ClienteDAO();
			dao.Create(cliente);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}
	public List<Cliente> ReadAll()
	{	List<Cliente> clientes1 =  new ArrayList<Cliente>();
		try{
			ClienteDAO dao = new ClienteDAO();

			clientes1 = dao.readAll();

		}
		finally{
			System.out.println("Fim da Pesquisa");
		}
		return clientes1;

	}

	public void Delete(Cliente cliente)
	{
		try
		{
			ClienteDAO dao = new ClienteDAO();
			dao.Delete(cliente);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}

	public void Update(Cliente cliente)
	{
		try
		{
			ClienteDAO dao = new ClienteDAO();
			dao.Update(cliente);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}
	public String Login(String email)
	{
	try
	{
		ClienteDAO dao = new ClienteDAO();
		
		return dao.Login(email);
		
	}
	finally{
		System.out.println("Fim do Login");
	}
	}
	
	public boolean Cadastrar(Cliente cliente)
	{
	try
	{
		ClienteDAO dao = new ClienteDAO();
					
		if (dao.Login(cliente.getEmail()) == null)
		{
			dao.Create(cliente);
			return true;
		}
		else
		{
			return false;
		}		
	}
	finally{
		System.out.println("Fim do cadastro");
	}
	}
	
	public String PesquisarUsuario(String email) // Retorna o ID do usuario
	{
		try
		{
			ClienteDAO dao = new ClienteDAO();
			
			return dao.PesquisarCliente(email);
			
		}
		finally{
			System.out.println("Fim da pesquisa");
		}
	}


}
