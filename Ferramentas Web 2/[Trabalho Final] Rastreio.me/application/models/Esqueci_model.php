<?php
class Esqueci_model extends CI_Model{
function __construct() {
parent::__construct();
}

  function check_email($data)
  {
    $query = $this->db->query("SELECT * FROM usuarios where email='$data' or id='$data'");
    return $query->result();
  }


}
