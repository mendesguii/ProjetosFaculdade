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
    public partial class ExibicaoFavorito : Form
    {
        Usuario u1 = new Usuario();
        List<Favorito> barraFavoritos = new List<Favorito>();
        public ExibicaoFavorito(Usuario u1, List<Favorito> listaFavorito)
        {
            this.u1.ID = u1.ID;
            barraFavoritos = listaFavorito;
            InitializeComponent();
        }

        private void btnDeletarFavorito_Click(object sender, EventArgs e)
        {
            try
            {
                if (this.listFav.SelectedItems.Count == 0)
                {
                    MessageBox.Show("É necessário escolher um item para deletar!");
                }
                else
                {
                    FavoritoCtrl f1 = new FavoritoCtrl();

                    List<Favorito> ListaFavoritoDeletar = new List<Favorito>();
                    for (int i = 0; i < this.listFav.SelectedItems.Count; i++)
                    {
                        Favorito fav = new Favorito();
                        fav.Nome = this.listFav.SelectedItems[i].SubItems[0].Text;
                        this.listFav.Items.Remove(this.listFav.SelectedItems[i]);
                        ListaFavoritoDeletar.Add(fav);
                    }
                    f1.RemoverFavorito(u1, ListaFavoritoDeletar);
                    MessageBox.Show("Favorito deletado");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
        }

        private void ExibicaoFavorito_Load(object sender, EventArgs e)
        {
            foreach (var itemFavorito in barraFavoritos)
            {
                ListViewItem item = new ListViewItem(itemFavorito.Nome);
                item.SubItems.Add(itemFavorito.Link);
                item.Tag = itemFavorito.ID;
                listFav.Items.Add(item);
            }
        }

        private void btnEditarFav_Click(object sender, EventArgs e)
        {
            if (this.listFav.SelectedItems.Count == 0)
            {
                MessageBox.Show("É necessário escolher um item para editar!");
            }
            else if (this.listFav.SelectedItems.Count == 1)
            {
                Favorito fav = new Favorito();
                fav.Nome = this.listFav.SelectedItems[0].SubItems[0].Text;
                fav.Link = this.listFav.SelectedItems[0].SubItems[1].Text;
                fav.ID = int.Parse(this.listFav.SelectedItems[0].Tag.ToString());
                EditarFavorito ef = new EditarFavorito(u1,fav);
                ef.Show();
                ef.FormClosing += ef_FormClosing;
                
            }
            else{
                MessageBox.Show("Só é possivel editar um favorito por vez!");
            }

        }

        void ef_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Focus(); // Foca nessa janela
            barraFavoritos.Clear(); // Limpa Lista
            listFav.Items.Clear(); // Limpa list view
            FavoritoCtrl fc = new FavoritoCtrl();
            fc.ExtracaoFavoritos(u1, barraFavoritos);
            foreach (var itemFavorito in barraFavoritos)
            {
                ListViewItem item = new ListViewItem(itemFavorito.Nome);
                item.SubItems.Add(itemFavorito.Link);
                item.Tag = itemFavorito.ID;
                listFav.Items.Add(item);
            }
        }


    }
}
