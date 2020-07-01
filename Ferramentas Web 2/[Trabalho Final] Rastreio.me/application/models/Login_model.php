<?php
class Login_model extends CI_Model{
function __construct() {
parent::__construct();
}

function login($data){
  $query= $this->db->get_where('usuarios', array('usuario' => $data['Usuario']));
  return $query->row();

}

}
