<?php
class Cron_model extends CI_Model{
function __construct() {
parent::__construct();
}
  function cron_get()
  {
    $query = $this->db->query("SELECT * FROM encomendas "); //where id not in (SELECT id_encomenda from encomendas_status where status like ('%Objeto entregue ao destinatário%'))
    return $query->result();
  }

  function cron_update($data){

  $query = $this->db->query("SELECT * FROM encomendas_status where id_encomenda='$data[id_encomenda]'");
  if (!$query->result())
  {
      $this->db->insert('encomendas_status', $data);
  }
  if($query->row()->status != $data['status'] && $query->row()->id_encomenda == $data['id_encomenda'])
   {
      $query =$this->db->query("UPDATE encomendas_status SET status = '$data[status]', email= 0 where id_encomenda = '$data[id_encomenda]'");
   }
  }

  function email_select_view($data)
  {
    $query = $this->db->query("SELECT es.id_encomenda,u.email,u.nome,e.cod_rastreio,es.status,es.data,e.descricao FROM encomendas_status es,usuarios u,encomendas e where es.email = 0 and u.id = es.id_usuario and es.id_encomenda = e.id and e.id='$data'");
    return $query->result();
  }
  function email_select()
  {
    $query = $this->db->query("SELECT es.id_encomenda,u.email,u.nome,e.cod_rastreio,es.status,es.data,e.descricao FROM encomendas_status es,usuarios u,encomendas e where es.email = 0 and u.id = es.id_usuario and es.id_encomenda = e.id");
    return $query->result();
  }
  function email_update($data)
  {
    $query =$this->db->query("UPDATE encomendas_status SET email = 1 where id_encomenda = $data ");
  }

}
