package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoController {

	public void Create(Aluno aluno)
	{
		try
		{
			AlunoDAO dao = new AlunoDAO();
			dao.Create(aluno);
		}
		finally{
			System.out.println("Fim da Inserção");
		}
	}
	public List<Aluno> ReadAll()
	{	List<Aluno> Alunos1 =  new ArrayList<Aluno>();
		try{
			AlunoDAO dao = new AlunoDAO();
			
			Alunos1 = dao.readAll();
			
		}
		finally{
			System.out.println("Fim da Pesquisa");
		}
		return Alunos1;
		
	}
}
