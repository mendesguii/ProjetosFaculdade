using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Data;
using Model;

namespace Control
{
    public class HistoricoCtrl
    {
        public bool InserirHistorico(Usuario u1, List<Historico> HistList)
        {
            try
            {
                HistoricoDAO dao = new HistoricoDAO();

                return dao.InserirHistorico(u1, HistList);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO SALVAR HISTORICO: " + ex.Message);
            }
        }
        public bool RemoverHistorico(Usuario u1, List<Historico> HistList)
        {
            try
            {
                HistoricoDAO dao = new HistoricoDAO();

                return dao.RemoverHistorico(u1, HistList);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO REMOVER HISTORICO: " + ex.Message);
            }
        }
        public void ExtracaoHistorico(Usuario u1, ListView l1, List<Historico> HistoricoAtual)
        {
            try 
            {
                 l1.Items.Clear();
                 HistoricoDAO dao = new HistoricoDAO();
                 List<Historico> resultado = new List<Historico>();
                 resultado = dao.ExtracaoHistorico(u1);
                 foreach (var itemHistorico in HistoricoAtual)
                  { 
                     resultado.Add(itemHistorico);
                  } 
                  foreach (var itemHistorico in resultado)   
                  {
                      ListViewItem item = new ListViewItem(itemHistorico.Link);
                      item.SubItems.Add(itemHistorico.Data);
                      item.Tag = itemHistorico.ID;
                      l1.Items.Add(item);
                  } 
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO EXIBIR HISTORICO: " + ex.Message);
            }
        
        
        }




    }
}
