<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Home extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
	}


	public function index()
	{
		if($this->session->userdata('logado'))
			redirect(base_url('/Encomendas'));
		else {
			$this->load->view('templates/html-header-Deslogado');
			$this->load->view('home');
			$this->load->view('templates/footer');
		}
		
	}




/*	public function db_test()
	{
		$dados['mensagem']=$this->db->get('usuarios')->result();
		echo '<pre>';
		print_r($dados);
	}
*/

}
