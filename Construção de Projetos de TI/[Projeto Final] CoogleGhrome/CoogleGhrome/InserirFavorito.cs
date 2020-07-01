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
    public partial class InserirFavorito : Form
    {
        Usuario u2 = new Usuario();
        Favorito fav = new Favorito();
        FavoritoCtrl f1 = new FavoritoCtrl();
        List<Favorito> FavoritosInserir = new List<Favorito>();
        
        public InserirFavorito(Usuario u1, String url, List<Favorito> Favoritos)
        {
            FavoritosInserir = Favoritos;
            InitializeComponent();
            this.lblUrl.Text = url; //Setando label com a url atual
            fav.Link = url;
            this.u2.ID =u1.ID; // Copiando id para o Usuario2
        }

        private void InserirFavorito_Load(object sender, EventArgs e)
        {
        }

        private void btnInserirFavorito_Click(object sender, EventArgs e)
        {
            try
            {
                fav.Nome = this.txtBoxNome.Text;
                f1.InserirFavorito(u2, fav, FavoritosInserir);

                MessageBox.Show("Favorito adicionado com sucesso");
                this.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
        }
    }
}
