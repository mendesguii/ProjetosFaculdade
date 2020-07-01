<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Encomendas extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
			$this->load->model('Encomenda_model');

	}

	public function index($pular=null,$post_per_page=null)
	{

		if($this->session->userdata('logado'))
		{
			$this->load->library('pagination');

			$post_per_page= 3;
			$config['base_url']= base_url('/Encomendas');
			$config['total_rows'] = $this->Encomenda_model->count();
			$config["uri_segment"] = 2;
			//$config['use_page_numbers'] = false;
			$config['num_links'] = $this->Encomenda_model->count();
			$config['per_page'] = $post_per_page;

			$this->pagination->initialize($config);

			$dados['links']=$this->pagination->create_links();

			if ($config['total_rows'] == 0)
			{
					$dados['show_warning'] = true;
			}

			$dados['encomendas'] = $this->Encomenda_model->exibe($pular,$post_per_page);

			$this->load->view('templates/html-header-Logado');
			$this->load->view('encomendas',$dados);

			$this->load->view('templates/footer');
		}
		else {
			redirect(base_url('/Login'));

		}

	}
	public function Pesquisar()
	{
		$info['pesquisa']=$this->input->post('pesquisa');
		$info['id'] = $this->session->userdata('idusuario');
		$dados['encomendas'] = $this->Encomenda_model->exibe_pesquisa($info);

		$this->load->view('templates/html-header-Logado');
		$this->load->view('encomendas',$dados);

		$this->load->view('templates/footer');
	}
	public function resumo()
	{

		$dados['encomendas'] = $this->Encomenda_model->resumo($_SESSION['idusuario']);
		if (!($dados['encomendas']))
				{
					$dados['show_warning'] = true;
				}
		$this->load->view('templates/html-header-Logado');
		$this->load->view('encomendas_resumo',$dados);

		$this->load->view('templates/footer');
	}


}
