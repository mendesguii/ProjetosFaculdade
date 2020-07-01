<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<?php echo $this->session->flashdata('erro'); ?>
<?php echo $this->session->flashdata('sucesso'); ?>
<!DOCTYPE html>
<html>
<body>

<?php echo form_open('Esqueci/trocar'); ?>
<div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Trocar senha</h3>
                    <p class="subtitle has-text-grey">Digite a senha nova abaixo.</p>
                    <div class="box">
                        <?php echo '<input type="hidden" name="seg2" value="'.$this->uri->segment(2).'">'; ?>
                          <?php echo '<input type="hidden" name="seg3" value="'.$this->uri->segment(3).'">'; ?>
                        <form>
                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="password" id='pass1' name="pass1" maxlength='8'  placeholder="Insira a senha" autofocus="" required>
                                    <span class="icon is-small is-left">
                        				      <b class="fas fa-lock"></b>
                        				    </span>
                                </div>
                            </div>

                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="password"  id ='pass2' name="pass2" maxlength='8' placeholder="Insira novamente a senha" required1>
                                    <span class="icon is-small is-left">
                        				      <b class="fas fa-lock"></b>
                        				    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="checkbox">

                            </div>
                            <?php echo form_submit(array('id' => 'submit', 'value' => 'Trocar', 'class'=>'button is-block is-info is-large is-fullwidth')); ?>

                        </form>

                    </div>
<?php echo form_close(); ?>
</div>
</div>
<div align='center'>
</div>
<script>
var password = document.getElementById("pass1")
  , confirm_password = document.getElementById("pass2");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Senhas não conferem");

  }
 else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;


</script>


</body>
</html>
