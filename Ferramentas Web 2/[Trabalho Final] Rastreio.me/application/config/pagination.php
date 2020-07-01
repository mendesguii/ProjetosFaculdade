<?php
defined('BASEPATH') OR exit('No direct script access allowed');
	$config['full_tag_open']    = "<nav class='pagination is-centered' role='navigation' aria-label='pagination'><ul class='pagination-list'>";
	$config['full_tag_close']   = '</ul></nav>';

	$config['first_link'] = '&laquo; First';
	$config['first_tag_open'] = '<button class = "button pagination-link">';
	$config['first_tag_close'] = '</button>';


	$config['last_tag_open'] = '<li><a class="pagination-link">';
	$config['last_tag_close'] = '</a></li>';

	$config['next_link'] = 'Próximo &rarr;';
  $config['next_tag_open'] = "<button class = 'button pagination-link'>";
  $config['next_tag_close']="</button>";

  $config['last_link'] = 'Último &raquo;';
  $config['last_tag_open'] = '<button class = "button pagination-link">';
  $config['last_tag_close'] = '</button>';

	$config['prev_link'] = '&larr; Anterior';
  $config['prev_tag_open'] = "<button class = 'button pagination-link'>";
	$config['prev_tag_close'] = "</button>";

  $config['cur_tag_open'] = '<li><a class="pagination-link is-current">';
  $config['cur_tag_close'] = '</a></li>';

  $config['num_tag_open'] = "<button class = 'button pagination-link'>";
  $config['num_tag_close'] = "</button>";
