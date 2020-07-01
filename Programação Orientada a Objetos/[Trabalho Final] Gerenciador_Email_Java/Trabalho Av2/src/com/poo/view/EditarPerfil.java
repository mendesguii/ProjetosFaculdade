package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.ClienteController;
import com.poo.model.Cliente;
import com.poo.model.Email;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class EditarPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPerfil frame = new EditarPerfil(null);
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
	public EditarPerfil(String email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 197);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(78, 74, 245, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Nova senha");
		lblSenha.setForeground(SystemColor.text);
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSenha.setBounds(156, 41, 79, 14);
		contentPane.add(lblSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cc = new ClienteController();
				Cliente c1 = new Cliente();
				c1.setEmail(email);
				c1.setSenha(textFieldSenha.getText());
				cc.Update(c1);	
				JOptionPane.showMessageDialog(contentPane, "Dados Alterados com sucesso");
				
				
				dispose();
			}
		});
		btnSalvar.setBounds(156, 111, 89, 23);
		contentPane.add(btnSalvar);
	}
}
