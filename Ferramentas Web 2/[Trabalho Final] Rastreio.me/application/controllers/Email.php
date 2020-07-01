<?php
//defined('BASEPATH') OR exit('No direct script access allowed');

class Email extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
			$this->load->model('Cron_model');
	}

	public function index()
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
		//$dados['dados'] = $this->Cron_model->email_select();
		//	$this->load->view('templates/email',$dados);

		// Pega todas a encomendas

		$dados = $this->Cron_model->email_select();
		foreach ($dados as $data) {

			$this->email->initialize($config);
			$this->email->from('contato@rastreio.me', 'Rastreio.me');
			$this->email->to($data->email);
			$dados2['dados']= $this->Cron_model->email_select_view($data->id_encomenda);
			$body = $this->load->view('templates/email',$dados2,true);
			$this->email->subject('Atualização da Sua Encomenda '.$data->cod_rastreio);
			$this->email->message($body);
			$a =$this->email->send();
			if ($a)
			{
			  $this->Cron_model->email_update($data->id_encomenda);
			}
		}

	}



}
