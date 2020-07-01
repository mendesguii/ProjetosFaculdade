<?php
class Cadastro_model extends CI_Model{
function __construct() {
parent::__construct();
}
function cadastro($data){
  $query= $this->db->get_where('usuarios', array('usuario' => $data['Usuario']));
  if ($query->result() != NULL)
  {
    $this->session->set_flashdata('erro', '<div class="notification is-danger"><center>Usuário já existe!</center></div>');
    redirect(base_url());
  }
  else {
    $this->session->set_flashdata('sucesso', '<div class="notification is-success"><center>Usuário cadastrado com sucesso!</center></div>');
    $this->db->insert('usuarios', $data);
    redirect(base_url());
  }

}
function cadastro_encomenda($data){
  $this->db->insert('encomendas', $data);
}
function exclui_encomenda($data){
  $this->db->query("DELETE FROM encomendas WHERE id ='$data[id]';");
  $this->db->query("DELETE FROM encomendas_status WHERE id_encomenda ='$data[id]';");
}
function editar_cadastro($data){
  $this->db->query("UPDATE usuarios set senha ='$data[Senha]' WHERE id ='$data[id]'");
}
function editar_encomenda($data){
  $this->db->query("UPDATE encomendas set descricao ='$data[descricao]' WHERE id ='$data[id]'");
}





}
