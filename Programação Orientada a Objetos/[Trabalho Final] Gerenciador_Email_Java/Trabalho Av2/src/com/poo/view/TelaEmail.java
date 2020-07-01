package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.model.EmailMensagem;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class TelaEmail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmail frame = new TelaEmail(null);
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
	public TelaEmail(EmailMensagem email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 459);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDe = new JLabel("De: "+email.getEmail_origem());
		lblDe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDe.setForeground(SystemColor.text);
		lblDe.setBounds(10, 11, 697, 14);
		contentPane.add(lblDe);
		
		JLabel lblAssunto = new JLabel("Assunto: "+email.getAssunto());
		lblAssunto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAssunto.setForeground(SystemColor.text);
		lblAssunto.setBounds(10, 36, 697, 14);
		contentPane.add(lblAssunto);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 73, 725, 320);
		textArea.setText(email.getMensagem());
		contentPane.add(textArea);
		
		
		
		
		
	}
}
