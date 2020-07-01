<?php
class Encomenda_model extends CI_Model{
function __construct() {
parent::__construct();
}
function exibe($pular=null,$post_per_page=null){
  $id = $this->session->userdata('idusuario');
  $this->db->order_by("id", "desc");
  if($pular && $post_per_page)
  {
    $this->db->limit($post_per_page,$pular);
  }
  else {
    $this->db->limit(3);
  }
  $query= $this->db->get_where('encomendas', array('id_usuario' => $id));

  return $query->result();
}

function exibe_pesquisa($info){
  $this->db->order_by("id", "desc");
  $query = $this->db->query("SELECT * FROM encomendas where id_usuario='$info[id]' and descricao like ('%$info[pesquisa]%') or cod_rastreio like ('%$info[pesquisa]%'); ");
  return $query->result();
}
function count(){
  $id = $this->session->userdata('idusuario');
  $query = $this->db->query("SELECT cod_rastreio FROM encomendas where id_usuario='$id' ");
  return $query->num_rows();
}
function count_att(){
  $id = $this->session->userdata('idusuario');
  $query = $this->db->query("SELECT id_encomenda FROM encomendas_status where id_usuario='$id' ");
  return $query->num_rows();
}
function resumo($id){
  $query = $this->db->query("SELECT * FROM encomendas where id_usuario='$id' ");
  $this->db->order_by("id", "desc");
  return $query->result();
}


}
