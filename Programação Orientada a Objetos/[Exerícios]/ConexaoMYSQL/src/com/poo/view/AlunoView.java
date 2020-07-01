package com.poo.view;

import java.util.Scanner;

import com.poo.controller.AlunoController;
import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoView {
		public void Create()
		{
			try{
				String nome,matricula;
				Scanner s1 = new Scanner(System.in);
				Aluno a1 = new Aluno();
				System.out.println("Digite nome: ");
				nome = s1.nextLine();
				System.out.println("Digite Matricula: ");
				matricula = s1.next();
				a1.setMatricula(matricula);
				a1.setNome(nome);
				AlunoController ac = new AlunoController();
				ac.Create(a1);
				}
			catch (Exception e)
				{
				System.out.println("Erro ao incluir aluno");
				
				}
		}
		public void ReadAll()
		{
			AlunoController ac = new AlunoController();
			
			for (Aluno a : ac.ReadAll())
			{
				System.out.println("Matricula: " + a.getMatricula());
				System.out.println("Nome: "+a.getNome());
				System.out.println("");
			}
		}
	
	public static void main(String[] args) {
		
		AlunoView a1 = new AlunoView();
		a1.ReadAll();
		
		
	
	
	
	
	
	
	
	}

	
	}


