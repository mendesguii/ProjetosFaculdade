using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Control;
using Model;

namespace View
{
    public partial class EditarFavorito : Form
    {
        Usuario u1 = new Usuario();
        Favorito fav = new Favorito();
        public EditarFavorito(Usuario u1,Favorito fav)
        {
            InitializeComponent();
            this.u1 = u1;
            this.fav = fav;
        }

        private void btnEditarFav_Click(object sender, EventArgs e)
        {
            try
            {
                FavoritoCtrl f1 = new FavoritoCtrl();
                fav.Nome = this.txtboxNome.Text;
                fav.Link = this.txtboxLink.Text;
                f1.EditarFavorito(u1, fav);
                DialogResult result = MessageBox.Show("Favorito editado com sucesso!");

                if (result == DialogResult.OK)
                {
                    this.Close();
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }

        }

        private void EditarFavorito_Load(object sender, EventArgs e)
        {
            this.txtboxLink.Text = fav.Link;
            this.txtboxNome.Text = fav.Nome;
        }
    }
}
