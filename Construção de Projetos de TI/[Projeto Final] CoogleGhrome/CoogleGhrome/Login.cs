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
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
            CenterToScreen(); //Centralizar
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            UsuarioCtrl uCTRL = new UsuarioCtrl();
            Usuario u1 = new Usuario();
            u1.Email = txtboxEmail.Text;
            u1.Senha = txtboxSenha.Text;
            Usuario u2 = new Usuario();
            try
            {
                u2 = uCTRL.LoginUsuario(u1);
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }

                if (u2.Email != null)
            {
                MessageBox.Show("Login efetuado com sucesso!");

                // Inicia o Browser
                this.Hide();
                Browser br = new Browser(u2);
                br.FormClosed += br_FormClosed;
                br.Show();
            }
            else
            {
                MessageBox.Show("Erro ao logar!");
            }
        }

        void br_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void btnGoCadastrar_Click(object sender, EventArgs e)
        {
            this.Hide();
            Cadastro c1 = new Cadastro();
            c1.FormClosed += c1_FormClosed;
            c1.Show();
        }

        void c1_FormClosed(object sender, FormClosedEventArgs e)
        {
            this.Show();
        }

        private void Login_Load(object sender, EventArgs e)
        {

        }
    }
}
