package com.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.ClienteController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField senha;
	private JLabel lblLogin;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 226);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JTextField();
		login.setBounds(101, 28, 209, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(101, 61, 209, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(136, 110, 104, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cc = new ClienteController();
				String senhaString = cc.Login(login.getText());
				if (senha.getText().equals(senhaString))
				{
					Home ee = new Home(login.getText());
					login.setText(null);
					senha.setText(null);
					JOptionPane.showMessageDialog(contentPane, "Você logou!");
					// Não está funcionando esconder o login//
					dispose(); 					
					ee.setVisible(true);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Login Invalido");
				}
			}
		});
		contentPane.add(btnLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(136, 144, 104, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario cu = new CadastrarUsuario();
				cu.setVisible(true);		
				
			}
		});
		contentPane.add(btnCadastrar);
		
		lblLogin = new JLabel("E-mail:");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLogin.setForeground(SystemColor.text);
		lblLogin.setBounds(32, 30, 59, 14);
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSenha.setForeground(SystemColor.text);
		lblSenha.setBounds(32, 63, 59, 14);
		contentPane.add(lblSenha);
	}

}
