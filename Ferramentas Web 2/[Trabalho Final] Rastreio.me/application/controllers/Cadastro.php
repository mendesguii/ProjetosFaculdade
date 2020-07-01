<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Cadastro extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
			$this->load->model('cadastro_model');
			$this->load->model('Login_model');
	}


	public function index()
	{
		$this->load->library('encryption');
		$data = array(
			'Nome' => $this->input->post('Nome'),
			'Email' => $this->input->post('Email'),
			'Senha' => $this->input->post('Senha'),
			'Usuario' => $this->input->post('Usuario')
		);
		//$senha = $data['Senha'];
		$password = password_hash($data['Senha'],PASSWORD_DEFAULT);
		$data['Senha']=$password;
		$this->cadastro_model->cadastro($data);
		redirect(base_url());

	}
	public function cadastro_encomenda()

{
	include ("simple_html_dom.php");
	$request = array('http' => array(
		'header' => 'Content-Type: application/x-www-form-urlencoded',
			'method' => 'POST',
			'content' => http_build_query(array(
					'Objetos' => $this->input->post('cod_rastreio')

			)),
	)
	);
	$context = stream_context_create($request);

	$html = file_get_html('https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm', false, $context);
	if($html)
	{


	if ($html->find('td') == null)
		{
			$this->session->set_flashdata('erro', '<div class="notification is-danger"><center>Código de rastreio inválido.Por favor tente novamente</center></div>');
			redirect(base_url('/encomendas'));
		}
	else {
			$this->session->set_flashdata('sucesso', '<div class="notification is-success"><center>Código de rastreio adicionado</center></div>');
			$id= $this->session->userdata('idusuario');
			if ($this->input->post('descricao') == NULL)
					$desc = $this->input->post('cod_rastreio');
			else
					$desc =$this->input->post('descricao');
				$data = array(
				'id_usuario' => $id,
				'cod_rastreio' => $this->input->post('cod_rastreio'),
				'descricao' => $desc,
			);

			//Grava dados no BD
			$this->cadastro_model->cadastro_encomenda($data);
			if($this->input->post('url2') == 'resumo')
			{
				redirect(base_url('/Encomendas/resumo'));
			}
			else
			redirect(base_url('/encomendas'));
		}
	}

}


public function exclui_encomenda()
{
	$data = array(
		'id' => $this->input->post('id'),
	);
	$this->cadastro_model->exclui_encomenda($data);
	if($this->input->post('url2') == 'resumo')
	{
		redirect(base_url('/Encomendas/resumo'));
	}
	else
		redirect(base_url('/Encomendas'));

}
public function editar_encomenda() // edita a descrição da encomenda
{
	$data = array(
		'id' => $this->input->post('id'),
		'descricao' =>$this->input->post('descricao'),
	);
	$this->cadastro_model->editar_encomenda($data);
	if($this->input->post('url2') == 'resumo')
	{
		redirect(base_url('/Encomendas/resumo'));
	}
	else
		redirect(base_url('/Encomendas'));

}

public function editar()//edita senha do usuário
{

	$data = array(
		'Usuario' => $_SESSION['usuario'],
		'id' => $_SESSION['idusuario'],
		'Senha' => $this->input->post('Senha_antiga'));
		$dados= $this->Login_model->login($data);
		$senha = password_verify($data['Senha'],$dados->senha);

		if($senha == TRUE)
		{
			$password = password_hash($this->input->post('Senhanova2'),PASSWORD_DEFAULT);
			$data['Senha']=$password;
			$this->cadastro_model->editar_cadastro($data);
			$this->session->set_flashdata('sucesso', '<div class="notification is-success"><center>Senha modificada.</center></div>');
			redirect(base_url('/Perfil'));
	 }
	 else {
		 $this->session->set_flashdata('erro', '<div class="notification is-danger"><center>Senha antiga não confere.</center></div>');
		 redirect(base_url('/Perfil'));
	 }
}


}
