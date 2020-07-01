import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {

	public static void main(String[] args) {
		JFrame f = new JFrame("Login");
		   //setar tamanho e onde inicia na tela
		   f.setSize(400, 400);
		   f.setLocation(600, 600);
		   //Setar botão X para sair 
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   // Texto
		   JLabel texto = new JLabel("Insira os dados para logar");
		   texto.setBounds(120, 50, 200, 30);
		   
		   // Textfield do usuario
		   JTextField input1 = new JTextField();
		   input1.setBounds(100, 100, 200, 30);
		   // Textfield da senha com os caracteres escondidos
		   
		   JPasswordField input2 = new JPasswordField();
		   input2.setBounds(100, 130, 200, 30);
		   
		   // Botão
		   JButton b=new JButton("Login");
		   b.setBounds(150,250,100,40);
		   
		   // Event Listener para ativar ao checar os dados
		   ActionListener al = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (input1.getText().equals("admin") && input2.getText().equals("admin"))
					{
						input1.setText(null);
						input2.setText(null);
						JOptionPane.showMessageDialog(f, "Você logou !");
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Login Invalido");
					}
				}
			};
			// Adicionando o Listener ao Botão
			b.addActionListener(al);
		   
		   
		   //adicionando ao frame
		   f.add(texto);
		   f.add(input1);
		   f.add(input2);
		   f.add(b);
		   f.setLayout(null);
		   f.setVisible(true);
	}

}
