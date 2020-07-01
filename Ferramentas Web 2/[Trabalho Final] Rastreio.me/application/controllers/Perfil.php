<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Perfil extends CI_Controller {

	public function __construct()
	{
			parent::__construct();

			$this->load->model('Encomenda_model');


	}
  public function index()
	{
    if($this->session->userdata('logado'))
    {
			$dados['count']=$this->Encomenda_model->count();
			$dados['count_att']=$this->Encomenda_model->count_att();
			$this->load->view('templates/html-header-Logado');
			$this->load->view('perfil',$dados);
			$this->load->view('templates/footer');
		}
    else {
      redirect(base_url('/Login'));
    }








}
}
