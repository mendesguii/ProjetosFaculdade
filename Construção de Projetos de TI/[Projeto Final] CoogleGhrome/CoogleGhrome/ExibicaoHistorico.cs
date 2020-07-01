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
    public partial class ExibicaoHistorico : Form
    {
        Usuario u1 = new Usuario();
        List<Historico> HistoricoAtualizado;
          
        public ExibicaoHistorico(Usuario u1, List<Historico> HistoricoCompleto)
        {
            HistoricoAtualizado = HistoricoCompleto;
            this.u1.ID = u1.ID;
            InitializeComponent();
        }

        private void ExibicaoHistorico_Load(object sender, EventArgs e)
        {
            try
            {
                HistoricoCtrl h1 = new HistoricoCtrl();
                h1.ExtracaoHistorico(u1, this.listView1, HistoricoAtualizado);
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERRO: " + ex.Message);
            }
        }

        private void DeletarHistorico_Click(object sender, EventArgs e)
        {
            if (this.listView1.SelectedItems.Count == 0)
            {
                MessageBox.Show("É necessário escolher um item para deletar!");
            }
            else
            {
                try
                {
                    HistoricoCtrl h1 = new HistoricoCtrl();
                    List<Historico> ListaHistoricoDeletar = new List<Historico>();
                    Boolean SQLChecker = false;
                    Boolean LocalData = false;
                    
                    foreach (ListViewItem item in this.listView1.SelectedItems)
                    {    Historico hist = new Historico();
                        if (item.Tag.Equals(0))
                        {
                            item.Remove();
                            LocalData = true;
                        }
                        else
                        {
                            hist.Data = item.SubItems[1].Text;
                            ListaHistoricoDeletar.Add(hist);
                            SQLChecker = true;
                        }
                    }
                    if (SQLChecker == true)
                    {
                        h1.RemoverHistorico(u1, ListaHistoricoDeletar);
                    }

                    DialogResult result = MessageBox.Show("Historico deletado");
                    if (result == DialogResult.OK)
                    {
                        h1.ExtracaoHistorico(u1, this.listView1, HistoricoAtualizado);
                    }   
                }
                catch (Exception ex)
                {
                    MessageBox.Show("ERRO: " + ex.Message);
                }
            }

        }
    }
}
