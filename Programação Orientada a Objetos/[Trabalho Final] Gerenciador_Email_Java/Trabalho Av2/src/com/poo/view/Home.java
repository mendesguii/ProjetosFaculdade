package com.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.poo.controller.ClienteController;
import com.poo.controller.EmailController;
import com.poo.dao.DbUtils;
import com.poo.model.EmailMensagem;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable Tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(null);
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
	public Home(String email) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 451);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Novo = new JButton("Novo");
		Novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnviarEmail ee = new EnviarEmail(email);
				ee.setVisible(true);
	
			}
		});
		Novo.setBounds(23, 104, 89, 23);
		contentPane.add(Novo);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmailMensagem e1 = new EmailMensagem();
				ClienteController cc = new ClienteController();
				
				
				Vector data =(Vector) ((DefaultTableModel) Tabela.getModel()).getDataVector().elementAt(Tabela.getSelectedRow());
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");  
				
				String email_v = (String) data.get(0);
				String data_v = dateFormat.format(data.get(1));
				String assunto_v = (String) data.get(2);
				String mensagem_v =(String) data.get(3);
				
				e1.setAssunto(assunto_v);
				e1.setData_envio(data_v);
				e1.setEmail_origem(cc.PesquisarUsuario(email_v));
				e1.setMensagem(mensagem_v);
				
				EmailController ec = new EmailController();
				ec.ApagarEmail(e1);
				
				/* Apaga do modelo */
				DefaultTableModel tm = (DefaultTableModel)Tabela.getModel();
				tm.removeRow(Tabela.getSelectedRow());
				Tabela.setModel(tm);
				JOptionPane.showMessageDialog(contentPane, "E-mail deletado!");
				
				
			}
		});
		btnApagar.setBounds(23, 138, 89, 23);
		contentPane.add(btnApagar);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailMensagem e1 = new EmailMensagem();
				
				Vector data =(Vector) ((DefaultTableModel) Tabela.getModel()).getDataVector().elementAt(Tabela.getSelectedRow());
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");  
				
				String email_v = (String) data.get(0);
				String data_v = dateFormat.format(data.get(1));
				String assunto_v = (String) data.get(2);
				String mensagem_v =(String) data.get(3);
				e1.setAssunto(assunto_v);
				e1.setData_envio(data_v);
				e1.setEmail_origem(email_v);
				e1.setMensagem(mensagem_v);
				
				TelaEmail ee = new TelaEmail(e1);
				ee.setVisible(true);		
				
				
				
				
				
			}
		});
		btnAbrir.setBounds(23, 70, 89, 23);
		contentPane.add(btnAbrir);
		
		JLabel lblBemVindo = new JLabel("E-mail: "+email);
		lblBemVindo.setForeground(SystemColor.text);
		lblBemVindo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBemVindo.setBounds(23, 11, 340, 14);
		contentPane.add(lblBemVindo);
		
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmailController ec = new EmailController();
				
				Tabela.setModel(DbUtils.resultSetToTableModel(ec.ReadAll(email)));
				
			}
		});
		btnAtualizar.setBounds(23, 36, 89, 23);
		contentPane.add(btnAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 36, 600, 365);
		contentPane.add(scrollPane);
		
		Tabela = new JTable();
		scrollPane.setViewportView(Tabela);
		
		JButton btnEditarPerfil = new JButton("Senha");
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditarPerfil perfil = new EditarPerfil(email);
				perfil.setVisible(true);
			}
		});
		btnEditarPerfil.setBounds(23, 344, 89, 23);
		contentPane.add(btnEditarPerfil);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l1 =new Login();
				l1.setVisible(true);
			}
		});
		btnSair.setBounds(23, 378, 89, 23);
		contentPane.add(btnSair);
	}
}
