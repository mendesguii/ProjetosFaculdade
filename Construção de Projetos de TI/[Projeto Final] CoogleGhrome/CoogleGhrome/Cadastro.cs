using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Model;
using Control;

namespace View
{
    public partial class Cadastro : Form
    {
        public Cadastro()
        {
            InitializeComponent();
            CenterToScreen(); //Centralizar
        }

        private void btnCadastrar_Click(object sender, EventArgs e)
        {
            UsuarioCtrl uCTRL = new UsuarioCtrl();
            Usuario u1 = new Usuario();
            u1.Nome = txtboxNome.Text;
            u1.Email = txtboxEmail.Text;
            u1.Senha = txtboxSenha.Text;
            if (txtboxSenha.Text == txtboxSenhaConfere.Text)
            {                 
                lblConfere.Text = "Senhas Conferem";
            }
            else{

                lblConfere.Text = "Senhas não conferem";
            
            }


            try
            {
                if (checkBox1.Checked && u1.Nome != null && u1.Email != null && u1.Senha != null && (txtboxSenha.Text == txtboxSenhaConfere.Text))
                {
                    if (uCTRL.InserirUsuario(u1))
                    {
                        MessageBox.Show("Cadastro feito com sucesso!");
                        //Vai para o login
                        this.Hide();
                        Login c1 = new Login();
                        c1.Show();
                    }
                    else
                    {
                        MessageBox.Show("Erro ao Cadastrar!");
                    }

                }
                else
                {
                    MessageBox.Show("É necessário aceitar os termos de uso para cadastrar!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
            

        }

        private void Cadastro_Load(object sender, EventArgs e)
        {

        }

    }
}
