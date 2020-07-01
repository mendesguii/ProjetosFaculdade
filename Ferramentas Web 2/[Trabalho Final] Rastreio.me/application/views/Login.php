<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<?php echo $this->session->flashdata('erro'); ?>
<!DOCTYPE html>
<html>
<body>

<?php echo form_open('login/logar'); ?>
<div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Login</h3>
                    <p class="subtitle has-text-grey">Para desfrutar de nosso serviço faça o login.</p>
                    <div class="box">

                        <form>
                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="text" name="Usuario" pattern="[A-Za-z0-9]{3,10}" placeholder="Usuário" autofocus="">
                                    <span class="icon is-small is-left">
                        				      <b class="fas fa-user"></b>
                        				    </span>
                                </div>
                            </div>

                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="password"  name="Senha" placeholder="Senha">
                                    <span class="icon is-small is-left">
                        				      <b class="fas fa-lock"></b>
                        				    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="checkbox">

                            </div>
                            <?php echo form_submit(array('id' => 'submit', 'value' => 'Logar', 'class'=>'button is-block is-info is-large is-fullwidth')); ?>

                        </form>

                    </div>
<?php echo form_close(); ?>
</div>
</div>
<div align='center'>
<a class='button is-info is-outlined' href='<?php echo base_url()?>'>Cadastre-se</a> <a class='button is-info is-outlined'href='<?php echo base_url('/Esqueci/email_esq')?>'>Esqueci minha senha</a>
</div>



</body>
</html>
