<?php

class CronJob extends CI_Controller {

	public function __construct()
	{
			parent::__construct();
				$this->load->model('Cron_model');
	}


	public function index()
	{
		include ("simple_html_dom.php");
		$dados=$this->Cron_model->cron_get();
		//print_r($dados);
		foreach ($dados as $enc)
		{


		$request = array('http' => array(
			'header' => 'Content-Type: application/x-www-form-urlencoded',
				'method' => 'POST',
				'content' => http_build_query(array(
						'Objetos' => $enc->cod_rastreio

				)),
		)
		);
		$context = stream_context_create($request);

		$html = file_get_html('https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm', false, $context);
		$i = 0;
		$email = false;
		if($html)
		{
			echo "<table class='table'>";
			echo "<tbody>";
			echo '<tr>';
		foreach($html->find('td') as $td)
		{
				echo '<td>';
			if ($i%2 ==0)
			{
				$data['id_encomenda'] = $enc->id;
				$data['id_usuario']=$enc->id_usuario;
				$data['data'] =strip_tags($td);

			}
			else {
				$data['status']=strip_tags($td);

				if (strpos(strip_tags($td),'saiu para entrega' )|| strpos(strip_tags($td),'entregue ao destinatário' ) || strpos(strip_tags($td),'A entrega não pode ser efetuada') || strpos(strip_tags($td),'Objeto aguardando retirada no endereço indicado')
				|| strpos(strip_tags($td),'Objeto ainda não chegou à unidade') || strpos(strip_tags($td),'Objeto devolvido'))
				{
					$email = true;
				}
			}
			if ($i == 1)
			{
				break;
			}
			$i++;

		}
		}
		$html->clear();
		unset($html);
		if ($email)
		{
		$this->Cron_model->cron_update($data);
		}
    }

		}








}
