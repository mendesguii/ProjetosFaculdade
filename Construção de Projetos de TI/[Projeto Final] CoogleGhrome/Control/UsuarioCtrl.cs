using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Data;
using Model;

namespace Control
{
    public class UsuarioCtrl
    {
        public Boolean InserirUsuario(Usuario user)
        {
            try
            {
                UsuarioDAO dao = new UsuarioDAO();

                return dao.InserirUsuario(user);
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO INSERIR PESSOA: " + ex.Message);
            }
        }
         public Usuario LoginUsuario(Usuario user)
         {
            try
            {
                UsuarioDAO dao = new UsuarioDAO();
                Usuario resultadoUser = new Usuario();
                resultadoUser = dao.LoginUsuario(user);
                return resultadoUser;
            }
            catch (Exception ex)
            {
                throw new Exception("ERRO AO LOGAR PESSOA: " + ex.Message);
            }
          }
         public Usuario BuscarPorIdUsuario(int id)
         {
             try
             {
                 UsuarioDAO dao = new UsuarioDAO();

                 return dao.BuscarPorIdUsuario(id);
             }
             catch (Exception ex)
             {
                 throw new Exception("ERRO AO PROCURAR PESSOA: " + ex.Message);
             }
         }

    }
}
