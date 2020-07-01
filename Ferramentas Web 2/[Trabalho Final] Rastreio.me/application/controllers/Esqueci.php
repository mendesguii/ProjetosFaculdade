<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Esqueci extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
			$this->load->model('Esqueci_model');
			$this->load->model('Cadastro_model');
	}


	public function index()
	{
			$this->load->view('templates/html-header-Deslogado');
			$this->load->view('esqueci');
			$this->load->view('templates/footer');

	}
	public function trocar()
	{
		$dados=$this->Esqueci_model->check_email($this->input->post('seg3'));
		if ($dados)
		{
			if (md5($dados[0]->usuario) == $this->input->post('seg2'))
			{
				$data =array(
             'Senha' => password_hash($this->input->post('pass2'),PASSWORD_DEFAULT),
             'id'   => $dados[0]->id,);
						 $this->Cadastro_model->editar_cadastro($data);
						 $this->session->set_flashdata('sucesso', '<div class="notification is-success"><center>Senha alterada com sucesso.</center></div>');
						 redirect(base_url(''));

			}
			else {
				redirect(base_url(''));
			}

		}



	}
	public function email_esq()
	{
		if($this->session->userdata('logado'))
		{
			redirect(base_url('/Encomendas'));
		}
		else {
			$this->load->view('templates/html-header-Deslogado');
			$this->load->view('esqueci_email');
			$this->load->view('templates/footer');
		}


	}
	public function enviar()
	{
		if($this->session->userdata('logado'))
		{
			redirect(base_url(''));
		}
		else {

		$email=$this->input->post('email');
		$dados['dados']=$this->Esqueci_model->check_email($email);
		if ($dados['dados'])
		{
			$this->load->library('email');
			$config['protocol'] = 'smtp';
			$config['mailpath'] = '/usr/sbin/sendmail';
			$config['charset'] = 'iso-8859-1';
			$config['wordwrap'] = TRUE;
			$config['smtp_host']='mx1.hostinger.com.br';
			$config['smtp_user'] ='contato@rastreio.me';
			$config['smtp_pass']='rastreiotop';
			$config['smtp_port']=587;
			$config['charset'] ='utf-8';
			$config['mailtype']='html';
			$config['smtp_keepalive']=TRUE;
			$config['bcc_batch_mode']=TRUE;
			$config['smtp_timeout']=100;
			//
			$this->email->initialize($config);
			$this->email->from('contato@rastreio.me', 'Rastreio.me');
			$this->email->to($email);
			$this->email->subject('Troca de Senha');
			$body = $this->load->view('templates/email_esq',$dados,true);
			$this->email->message($body);
			$a =$this->email->send();
			$this->session->set_flashdata('sucesso', '<div class="notification is-success"><center>E-mail enviado com sucesso.</center></div>');
			redirect(base_url('/Esqueci/email_esq'));


			}
			else {
				$this->session->set_flashdata('erro', '<div class="notification is-danger"><center>E-mail inexistente, tente novamente.</center></div>');
 			 	redirect(base_url('/Esqueci/email_esq'));

			}
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
