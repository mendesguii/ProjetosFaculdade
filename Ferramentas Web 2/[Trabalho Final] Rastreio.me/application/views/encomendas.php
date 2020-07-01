<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<?php echo $this->session->flashdata('erro'); ?>
<?php echo $this->session->flashdata('sucesso'); ?>
<!DOCTYPE html>

<html>
<body>
  <div class="box cta" >
    <nav class="level">
      <div class="level-item">
        <div>
          <div style="height:38;"class="field has-addons">
            <div class="control has-icons-left has-icons-right is-expanded">



                <?php echo form_open('Encomendas/Pesquisar'); ?>

              <input type="text" class="input is-info" name='pesquisa' placeholder="Digite um código ou uma descrição" required>
            </div>
            <p class="control">
              <?php echo form_submit(array('id' => 'submit_1', 'value' => 'Pesquisar', 'class'=>'button is-block is-info'))?>
              <?php echo form_close(); ?>
            </p>
            </div>

        </div>
      </div>
      <div class="level-item">

      </div>
      <div class="level-item">
        <div>

          <div class="modal" id="modalEdicion">
         <div onclick="refs.modalEdicion.close()" class="modal-background"></div>
         <div class="modal-card">
        <header class="modal-card-head">
        <p class="modal-card-title">Adicionar Encomenda</p>
        </header>
       <?php echo form_open('cadastro/cadastro_encomenda'); ?>
       <section class="modal-card-body">
                           <form>
                             <div class="field">
                                <label class="label">Código de Rastreio</label>
                                 <div class="control">
                                  <input type="text" class="input" name="cod_rastreio" pattern="[A-Z0-9]{13}" maxlength="13" placeholder="Digite o Código de Rastreio" minlength="13" required>
                                   </div>
                                 </div>
                               <div class="field">
                                    <label class="label">Descrição</label>
                                   <div class="control">
                                     <input type="text" class="input" name="descricao" maxlength="40" placeholder="Digite uma descrição breve">
                                   </div>
                                   </div>
                                  <?php echo '<input type="hidden" name="url2" value="'.$this->uri->segment(2).'">'; ?>
                                 <?php echo form_submit(array('id' => 'submit', 'value' => 'Adicionar', 'class'=>'button is-block is-info is-large is-fullwidth')); ?>
                             </form>
           <?php echo form_close(); ?>
         </section>
           </div>
         <button class="modal-close is-large" aria-label="close" onclick="refs.modalEdicion.close()"></button>
           </div>
        </div>
      </div>
      <div class="level-item">

      </div>

      <div class="level-item">
        <div id='drop_down' class="dropdown is-hoverable">
        <div class="dropdown-trigger">
        <button class="button" aria-haspopup="true" aria-controls="dropdown-menu">
          <span>Ações</span>
          <span class="icon is-small">
            <i class="fas fa-angle-down" aria-hidden="true"></i>
          </span>
        </button>
        </div>
        <div class="dropdown-menu" id="dropdown-menu" role="menu">
        <div class="dropdown-content">
          <hr class="dropdown-divider">
          <a href="<?php echo base_url('/Encomendas')?>" class="dropdown-item" >
            Modo Completo
          </a>
          <hr class="dropdown-divider">
          <a href="<?php echo base_url('/Encomendas/resumo')?>" class="dropdown-item">
            Modo Resumo
          </a>
          <hr class="dropdown-divider">
          <!-- Adicionar Encomenda-->
          <a class="is-info level-item is-small" onclick="refs.modalEdicion.open()">
          <span>Adicionar Encomenda</span>
          </a>
          <div class="modal" id="modalEdicion">
         <div onclick="refs.modalEdicion.close()" class="modal-background"></div>
         <div class="modal-card">
        <header class="modal-card-head">
        <p class="modal-card-title">Adicionar Encomenda</p>
        </header>
       <?php echo form_open('cadastro/cadastro_encomenda'); ?>
       <section class="modal-card-body">
                           <form>
                             <div class="field">
                                <label class="label">Código de Rastreio</label>
                                 <div class="control">
                                  <input type="text" class="input" name="cod_rastreio" pattern="[A-Z0-9]{13}" maxlength="13" placeholder="Digite o Código de Rastreio" minlength="13" required>
                                   </div>
                                 </div>
                               <div class="field">
                                    <label class="label">Descrição</label>
                                   <div class="control">
                                     <input type="text" class="input" name="descricao" maxlength="40" placeholder="Digite uma descrição breve">
                                   </div>
                                   </div>
                                  <?php echo '<input type="hidden" name="url2" value="'.$this->uri->segment(2).'">'; ?>
                                 <?php echo form_submit(array('id' => 'submit_3', 'value' => 'Adicionar', 'class'=>'button is-block is-info is-large is-fullwidth')); ?>
                             </form>
           <?php echo form_close(); ?>
         </section>
           </div>
         <button class="modal-close is-large" aria-label="close" onclick="refs2.modalEdicion.close()"></button>
           </div>
        </div>
        </div>
        </div>

      </div>
    </nav>

  </div>
  <script>
  var refs = {
    modalEdicion: {
      open: function() { document.getElementById('modalEdicion').classList.add('is-active');
      },
      close:function() { document.getElementById('modalEdicion').classList.remove('is-active');

      }
    }
  };

</script>

	<?php
  include ("simple_html_dom.php");
 function remove_br($td)
	{
		if ($td->tag=='br')
							$td->innertext = '';
		if ($td->tag=='br')
					 		$td->outertext = '';

	}

  foreach($encomendas as $dados_enc)
	{

    $request = array('http' => array(
		  'header' => 'Content-Type: application/x-www-form-urlencoded',
		    'method' => 'POST',
		    'content' => http_build_query(array(
		        'Objetos' => $dados_enc->cod_rastreio

		    )),
		)
		);

		$context = stream_context_create($request);

		$html = file_get_html('https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm', false, $context);
		//echo $html;


		$vetor= Array();
		$i = 0;

		$html->set_callback('remove_br');

		if ($html)
		{
			echo "<div class = 'container'>";
		  echo '<hr>';
			echo "<p class='subtitle'>".$dados_enc->descricao;
      echo '<button class="button is-small" style="float: right"onclick="refs'.$dados_enc->id.'.modal'.$dados_enc->id.'.open()">'.'<span>Editar</span></button>'.'</p>';


      echo ' <div class="modal" id="mod_'.$dados_enc->id.'">
             <div onclick="refs'.$dados_enc->id.'.modal'.$dados_enc->id.'.close()" class="modal-background"></div>
             <div class="modal-card">
            <header class="modal-card-head">
            <p class="modal-card-title">Editar Encomenda</p>';

            echo form_open('cadastro/exclui_encomenda');
            echo '<input type="hidden" name="id" value="'.$dados_enc->id.'">';
            echo form_submit(array('id' => 'submit_exclui', 'value' => 'Excluir', 'class'=>'button is-small')).form_close();
            echo '</header>';

          echo form_open("cadastro/editar_encomenda");
           echo ' <section class="modal-card-body">
                               <form>
                                 <div class="field">
                                    <label class="label">Código de Rastreio</label>
                                     <div class="control">';

                                        echo '<input type="text" class="input" value = "'.$dados_enc->cod_rastreio.'" disabled>
                                       </div>
                                     </div>
                                     <div class="field">
                                          <label class="label">Descrição atual</label>
                                         <div class="control">
                                           <input type="text" class="input" value = "'.$dados_enc->descricao.'" disabled>
                                         </div>

                                         </div>
                                         <div class="field">
                                              <label class="label">Descrição nova</label>
                                             <div class="control">
                                               <input type="text" class="input" name="descricao" maxlength="40" placeholder="Digite uma descrição breve">
                                             </div>

                                             </div>';
             echo '<input type="hidden" name="url2" value="'.$this->uri->segment(2).'">';
             echo '<input type="hidden" name="id" value="'.$dados_enc->id.'">';

            echo form_submit(array('id' => 'submit_editar', 'value' => 'Alterar', 'class'=>'button is-block is-info is-large is-fullwidth'));
            echo form_close();
            echo'</section>
               </div>
             <button class="modal-close is-large" aria-label="close" onclick="refs'.$dados_enc->id.'.modal'.$dados_enc->id.'.close()"></button>
               </div>';
            echo '<script>
            var refs'.$dados_enc->id.' = {
              modal'.$dados_enc->id.': {
                open: function() { document.getElementById("mod_'.$dados_enc->id.'").classList.add("is-active");
                },
                close:function() { document.getElementById("mod_'.$dados_enc->id.'").classList.remove("is-active");

                }
              }
            };

            </script>';
      echo "<article class='tile is-child box'>";
			echo '<div align="right"><span class="tag is-link">'.'<b>'.$dados_enc->cod_rastreio.'</b></span>'.'</div>';

      if ($html->find('td') == null)
      {
        echo "<div class = 'container'>";

        echo '<p class="title">Código de rastreio errado ou muito antigo. </p>';

        echo '</div>';
      }
      else {
        echo "<table class='table'>";
        echo "<tbody>";
        echo '<tr>';
			foreach($html->find('td') as $td)
		  {
				echo '<td>';
				if ($i%2 ==0)
					echo $td.'</td>';
				else {
          echo $td.'</tr>';
				}
				$i++;

		  }
    }
			echo '</table>';
			echo '</article>';
			echo "</tbody>";
			echo "</div>";
			$html->clear();
		  unset($html);
		}

 }



  if (isset($links))
  {
    echo "<section class='hero'><div class='hero-body'><div class='container'>";
    echo $links;
    echo "</div></div></section>";

  }
if (isset($show_warning)) {
  echo "<div class = 'container'>";
  echo "<article class='tile is-child notification is-info'><center>";
  echo '<p class="title">Você não tem encomendas cadastradas ainda :(</p>';
  echo '</center></article>';
  echo '</div>';

  }



	?>

</body>
</html>
