package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.ClienteController;
import com.poo.model.Cliente;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class CadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField nome;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario frame = new CadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 274);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setBounds(120, 73, 185, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		nome = new JTextField();
		nome.setBounds(120, 104, 185, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(120, 135, 185, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController clientecon = new ClienteController();
				Cliente c1 = new Cliente();
				c1.setEmail(email.getText());
				c1.setNome(nome.getText());
				c1.setSenha(senha.getText());
				
				if (clientecon.Cadastrar(c1))
				{
					JOptionPane.showMessageDialog(contentPane, "Usuário cadastrado!");
					dispose();

					
				}
				else
				{
					email.setText(null);
					JOptionPane.showMessageDialog(contentPane, "Esse e-mail já existe!");
					
				}
				
				
			}
		});
		btnCadastrar.setBounds(133, 178, 102, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setBounds(34, 75, 60, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNome.setForeground(SystemColor.text);
		lblNome.setBounds(34, 106, 60, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSenha.setForeground(SystemColor.text);
		lblSenha.setBounds(34, 137, 60, 14);
		contentPane.add(lblSenha);
		
		JLabel lblCadastro = new JLabel("Dados pessoais");
		lblCadastro.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCadastro.setForeground(SystemColor.text);
		lblCadastro.setBounds(120, 32, 158, 14);
		contentPane.add(lblCadastro);
	}

}
