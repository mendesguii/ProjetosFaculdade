<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Login extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
			$this->load->model('Login_model');

	}

	public function logar()
	{
		$data = array(
			'Usuario' => $this->input->post('Usuario'),
			'Senha' => $this->input->post('Senha'));
			$dados= $this->Login_model->login($data);
			$senha = password_verify($data['Senha'],$dados->senha);

			if($senha == TRUE)
			{
				$Session_dados['logado'] = TRUE;
				$Session_dados['nome'] = $dados->nome;
				$Session_dados['usuario'] = $dados->usuario;
				$Session_dados['idusuario'] = $dados->id;
				$Session_dados['email']=$dados->email;
				$this->session->set_userdata($Session_dados);
				redirect(base_url('/Encomendas'));
		 }
		 else {
		 	 $this->session->set_flashdata('erro', '<div class="notification is-danger"><center>Usuário ou senha incorreta. Por favor tente novamente</center></div>');
			 redirect(base_url('/Login'));
		 }


	}
	public function deslogar() {
         $this->session->sess_destroy();
         redirect(base_url());
     }



	public function index()
	{
		if($this->session->userdata('logado'))
		{
			redirect(base_url('/Encomendas'));
		}
		else {
			$this->load->view('templates/html-header-Deslogado');
			$this->load->view('Login');
			$this->load->view('templates/footer');
		}


	}



}
