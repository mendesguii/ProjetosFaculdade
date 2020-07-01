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
    public class FavoritoCtrl
    {
        public bool InserirFavorito(Usuario u1, Favorito fav, List<Favorito> Favoritos)
        {
            try
            {
                FavoritoDAO dao = new FavoritoDAO();

                return dao.InserirFavorito(u1, fav, Favoritos);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO INSERIR FAVORITO: " + ex.Message);
            }
        }
        public void ExtracaoFavoritos(Usuario u1, List<Favorito> Favoritos)
        {
            try
            {
                FavoritoDAO dao = new FavoritoDAO();

                dao.ExtracaoFavoritos(u1, Favoritos);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO EXTRAIR FAVORITOS: " + ex.Message);
            }
        }
        public bool RemoverFavorito(Usuario u1, List<Favorito> listFav)
        {
            try
            {
                FavoritoDAO dao = new FavoritoDAO();

                return dao.RemoverFavorito(u1, listFav);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO REMOVER FAVORITO: " + ex.Message);
            }
        }
        public bool EditarFavorito(Usuario u1, Favorito fav)
        {
            try
            {
                FavoritoDAO dao = new FavoritoDAO();

                return dao.EditarFavorito(u1, fav);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO REMOVER FAVORITO: " + ex.Message);
            }
        }
    }
}
