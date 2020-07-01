package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.EmailController;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;

public class EnviarEmail extends JFrame {

	private JPanel contentPane;
	private JTextField Para;
	private JTextField Assunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarEmail frame = new EnviarEmail(null);
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
	public EnviarEmail(String email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 793, 444);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Para = new JTextField();
		Para.setBounds(119, 11, 568, 20);
		contentPane.add(Para);
		Para.setColumns(10);
		
		Assunto = new JTextField();
		Assunto.setBounds(119, 43, 568, 20);
		contentPane.add(Assunto);
		Assunto.setColumns(10);
		
		JTextArea Mensagem = new JTextArea();
		Mensagem.setBounds(10, 82, 757, 278);
		contentPane.add(Mensagem);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailController e1 = new EmailController();
				
				String Origem = email;
				String Destino = Para.getText();
				String Assunto_O = Assunto.getText();
				String Mensagem_O = Mensagem.getText();
				
				if (e1.Enviar_email(Origem,Destino,Assunto_O,Mensagem_O))
				{
					JOptionPane.showMessageDialog(contentPane, "Enviou o e-mail");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Erro ao enviar o e-mail!");
				}					
				
			}
		});
		btnEnviar.setBounds(678, 371, 89, 23);
		contentPane.add(btnEnviar);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setForeground(SystemColor.text);
		lblPara.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPara.setBounds(25, 14, 84, 14);
		contentPane.add(lblPara);
		
		JLabel lblAssunto = new JLabel("Assunto: ");
		lblAssunto.setForeground(SystemColor.text);
		lblAssunto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAssunto.setBounds(25, 46, 84, 14);
		contentPane.add(lblAssunto);
	}
}
