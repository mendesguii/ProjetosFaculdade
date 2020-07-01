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
    public partial class Browser : Form
    {
        List<Historico> HistoricoAtual = new List<Historico>(); 
        List<Favorito> Favoritos = new List<Favorito>(); 
        WebBrowser webTab = null;
        Usuario u1 = new Usuario();
        
        public Browser(Usuario u1)
        {
            this.u1.ID = u1.ID;
            InitializeComponent();
            this.sttsLabel.Text = "Usuário Logado: "+u1.Nome;
        }

        private void Browser_Load(object sender, EventArgs e)
        {
            btnItem.Navigate("https://www.google.com.br/");
            btnItem.DocumentCompleted += webBrowser1_DocumentCompleted;
            try
            {
                FavoritoCtrl fc = new FavoritoCtrl();
                fc.ExtracaoFavoritos(u1, Favoritos);// Carregar os favoritos na lista
                attBarraFavoritos(Favoritos, this.barFavorites); //Coloca os favoritos na barra 
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
        }
        
        // Atualiza o titulo da aba inicial e a url no text box

        void webBrowser1_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {
            DateTime now = DateTime.Now;
            Historico h1 = new Historico();
            tabControl1.SelectedTab.Text = btnItem.DocumentTitle;
            this.txtboxUrl.Text = btnItem.Url.AbsoluteUri;
            var histCount = HistoricoAtual.Count; // Checa Tamanho da Lista
            
            if (histCount > 0)
            {
                Historico h2 = new Historico();
                h2 = HistoricoAtual[histCount - 1]; 
                if (h2.Link != this.txtboxUrl.Text)
                {
                    h1.Link = this.txtboxUrl.Text;
                    h1.Data = now.ToString();
                    HistoricoAtual.Add(h1);
                }
            }
            else if (histCount == 0) 
            {  
                h1.Link = this.txtboxUrl.Text;
                h1.Data = now.ToString();
                HistoricoAtual.Add(h1);
            }
        }

         private void btnGo_Click(object sender, EventArgs e)
        {
            WebBrowser web = tabControl1.SelectedTab.Controls.OfType<WebBrowser>().FirstOrDefault();
            if (web != null && (txtboxUrl.Text.Contains(".com") || txtboxUrl.Text.Contains(".br"))) // Checando pra ver se é uma url ou pesquisa
            {
             web.Navigate(txtboxUrl.Text);
            }
            else
            {
                //Pesquisa no Google
                web.Navigate("https://www.google.com/search?q="+txtboxUrl.Text);
            }
         }
         
         private void btnNewTab_Click(object sender, EventArgs e)
         {
             //Instanciando Aba Nova
             attBarraFavoritos(Favoritos, barFavorites);
             TabPage tab = new TabPage();
             tab.Text = "New Tab";
             tabControl1.Controls.Add(tab);
             tabControl1.SelectTab(tabControl1.TabCount - 1); // Excluindo a primeira pra contagem funcionar;
             webTab = new WebBrowser(); // Iniciando Navegador
             webTab.ScriptErrorsSuppressed = true;
             webTab.Parent = tab;
             webTab.Dock = DockStyle.Fill;
             webTab.Navigate("https://www.google.com.br/");
             webTab.DocumentCompleted += webTab_DocumentCompleted;


         }
        // Atualiza o titulo da aba nova e a url no text box
         void webTab_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
         {
             try
             {
                 DateTime now = DateTime.Now;
                 Historico h1 = new Historico();
                 tabControl1.SelectedTab.Text = webTab.DocumentTitle;
                 this.txtboxUrl.Text = webTab.Url.AbsoluteUri; // @@@@@@@@@@@@@@@@@@
                 var histCount = HistoricoAtual.Count; // Checar Tamanho da Lista

                 if (histCount > 0)
                 {
                     Historico h2 = new Historico();
                     h2 = HistoricoAtual[histCount - 1];
                     if (h2.Link != this.txtboxUrl.Text)
                     {
                         h1.Link = this.txtboxUrl.Text;
                         h1.Data = now.ToString();
                         HistoricoAtual.Add(h1);
                     }
                 }
                 else if (histCount == 0)
                 {
                     h1.Link = this.txtboxUrl.Text;
                     h1.Data = now.ToString();
                     HistoricoAtual.Add(h1);
                 }
             }
             catch (Exception ex)
             {
                 MessageBox.Show("ERRO: " + ex.Message);
             }

         }

         private void btnBack_Click(object sender, EventArgs e)
         {
             WebBrowser web = tabControl1.SelectedTab.Controls.OfType<WebBrowser>().FirstOrDefault();
             if (web != null)
             {
                 if (web.CanGoBack)
                     web.GoBack();
             }
         }

         private void btnForward_Click(object sender, EventArgs e)
         {
             WebBrowser web = tabControl1.SelectedTab.Controls.OfType<WebBrowser>().FirstOrDefault();
             if (web != null)
             {
                 if (web.CanGoForward)
                     web.GoForward();
             }
         }

         private void txtboxUrl_KeyPress(object sender, KeyPressEventArgs e)
         {
             if (e.KeyChar == (char)13)
             {
                 WebBrowser web = tabControl1.SelectedTab.Controls.OfType<WebBrowser>().FirstOrDefault();
                 if (web != null && (txtboxUrl.Text.Contains(".com") || txtboxUrl.Text.Contains(".br"))) // Checando pra ver se é uma url ou pesquisa
                 {
                     web.Navigate(txtboxUrl.Text);
                 }
                 else
                 {
                     web.Navigate("https://www.google.com/search?q=" + txtboxUrl.Text);//Pesquisa no Google
                 }
             
             }
         }

         private void btnCloseTab_Click(object sender, EventArgs e)
         {
             tabControl1.TabPages.Remove(tabControl1.SelectedTab);
         }

         private void btnHistory_Click(object sender, EventArgs e)
         {
             try
             {
                 ExibicaoHistorico eh = new ExibicaoHistorico(u1, HistoricoAtual);
                 eh.Show();
             }
             catch (Exception ex)
             {
                 MessageBox.Show("ERRO: " + ex.Message);
             }
         }
         
         protected override void OnFormClosing(FormClosingEventArgs e) //Função para executar quando estiver fechando o form 
         {
             try
             {
                 // Salvando o histórico na nuvem ao fechar a aplicação.
                 HistoricoCtrl historico = new HistoricoCtrl();
                 historico.InserirHistorico(u1, HistoricoAtual);
                 base.OnFormClosing(e);
                 MessageBox.Show("Subindo seus dados para nossos servidores");
                 //Application.Exit(); // Fechando a Aplicação ao fechar essa janela
             }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
             
         }

         private void btnFavorites_Click(object sender, EventArgs e)
         {
             InserirFavorito ifav = new InserirFavorito(u1, this.txtboxUrl.Text,Favoritos);
             ifav.FormClosing += ifav_FormClosing;
             ifav.Show();
          }

         void ifav_FormClosing(object sender, FormClosingEventArgs e)
         {
             attBarraFavoritos(Favoritos, this.barFavorites); //Atualiza toda vez que terminar de inserir o favorito
         }

         private void attBarraFavoritos(List<Favorito> Favoritos, System.Windows.Forms.MenuStrip Barra)
        {
            Barra.Items.Clear();
            foreach (var itemFavorito in Favoritos)
            {
            System.Windows.Forms.ToolStripMenuItem a1 = new System.Windows.Forms.ToolStripMenuItem(); // Criando Novo item
            a1.Size = new System.Drawing.Size(125, 20);
            a1.Text = itemFavorito.Nome;
            a1.Name = itemFavorito.Link;
            a1.Click += itemFavBar_Click;
            Barra.Items.Add(a1);
            }
        }

         void itemFavBar_Click(object sender, EventArgs e)
         {
             var itemText = (sender as ToolStripMenuItem); 
             WebBrowser web = tabControl1.SelectedTab.Controls.OfType<WebBrowser>().FirstOrDefault(); //Seleciona a aba conforme clica na barra de favoritos
             if (web != null)
             {
                 web.Navigate(itemText.Name);
             }
            
         }

         private void btnFav_Click(object sender, EventArgs e)
         {
             try
             {
                 ExibicaoFavorito ef = new ExibicaoFavorito(u1, Favoritos);
                 ef.Show();
                 ef.FormClosing += ef_FormClosing;
             }
             catch (Exception ex)
             {
                 MessageBox.Show("ERRO: " + ex.Message);
             }
         }

         void ef_FormClosing(object sender, FormClosingEventArgs e)
         {
             try
             {
                 Favoritos.Clear();
                 FavoritoCtrl fc = new FavoritoCtrl();
                 fc.ExtracaoFavoritos(u1, Favoritos);// Carregar os favoritos na lista
                 attBarraFavoritos(Favoritos, this.barFavorites); //Coloca os favoritos na barra 
             }
             catch (Exception ex)
             {
                 MessageBox.Show("ERRO: " + ex.Message);
             }
         }

        


          
    }
}
