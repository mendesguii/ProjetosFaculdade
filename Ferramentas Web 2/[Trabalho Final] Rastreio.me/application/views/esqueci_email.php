<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<?php echo $this->session->flashdata('erro'); ?>
<?php echo $this->session->flashdata('sucesso'); ?>
<!DOCTYPE html>
<html>
<body>

<?php echo form_open('Esqueci/enviar'); ?>
<div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Recuperação de Senha</h3>
                    <p class="subtitle has-text-grey">Digite o E-mail de cadastro.</p>
                    <br><br><br>
                    <div class="box">
                        <form>
                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="email" name='email' placeholder="Insira o E-mail" autofocus="" required>
                                    <span class="icon is-small is-left">
                        				      <b class="fas fa-envelope"></b>
                        				    </span>
                                </div>
                            </div>
                            <?php echo form_submit(array('id' => 'submit', 'value' => 'Recuperar', 'class'=>'button is-block is-info is-large is-fullwidth')); ?>

                        </form>

                    </div>
<?php echo form_close(); ?>
</div>
</div>
<div align='center'>
</div>



</body>
</html>
