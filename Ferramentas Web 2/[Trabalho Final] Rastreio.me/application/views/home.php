<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<!DOCTYPE html>
<html>
<body>
<?php echo $this->session->flashdata('erro'); ?>
<?php echo $this->session->flashdata('sucesso'); ?>
<section class="hero is-fullheight is-light is-bold">
<div class="hero-body">
        <div class="container">
            <div class="columns is-vcentered">
                <div class="column is-5 is-offset-1 landing-caption">
                    <h1 class="title is-1 is-bold is-spaced">
                        Rastreio, Simples.
                    </h1>
                    <h2 class="subtitle is-5 is-muted">Solução final para o rastreio de forma fácil, prática e eficiente. </h2>
                    <p>

                      <button class="button is-link" onclick="refs.modalEdicion.open()">
                              <span>Cadastre-se</span>
                          </button>

                          <div class="modal" id="modalEdicion">
                              <div onclick="refs.modalEdicion.close()" class="modal-background"></div>
                              <div class="modal-card">

                                 <article class='tile is-child box'>
                                 <p class="title">Cadastro</p>
                                 <?php echo form_open('cadastro'); ?>
                                 <label class="label">Nome</label>
                                 <input type="text" class="input" name="Nome" placeholder="Informe o seu nome" required>
                                 <br>
				<div class="field">
				  <label class="label">Usuário</label>
				  <div class="control has-icons-left has-icons-right">
				    <input type="text" class="input" name="Usuario" pattern="[A-Za-z0-9]{3,10}" maxlength="10" placeholder="Informe o seu usuário de 4 ou mais caracteres." required>
				    <span class="icon is-small is-left">
				      <b class="fas fa-user"></b>
				    </span>
				   </div>

				<div class="field">
				  <label class="label">E-mail</label>
				  <div class="control has-icons-left has-icons-right">
				     <input type="email" class="input" name="Email" placeholder="Informe o seu e-mail" required>
				    <span class="icon is-small is-left">
				      <b class="fas fa-envelope"></b>
				    </span>
				   </div>

				<div class="field">
				  <label class="label">Senha</label>
				  <div class="control has-icons-left has-icons-right">
				     <input type="password" class="input" maxlength='8' name="Senha" id="pass1" placeholder="Informe sua senha" required>
				    <span class="icon is-small is-left">
				      <b class="fas fa-lock"></b>
				    </span>
				   </div>
           </div>
           <div class="field">
   				  <label class="label">Confirme a Senha</label>
   				  <div class="control has-icons-left has-icons-right">
   				     <input type="password" class="input" maxlength='8' name="Senha" id="pass2" placeholder="Confirme sua senha" required>
   				    <span class="icon is-small is-left">
   				      <b class="fas fa-lock"></b>
   				    </span>
   				   </div>
              </div>
			        <br>
			         <center>
                                 <?php echo form_submit(array('id' => 'submit', 'value' => 'Cadastrar', 'class'=>'button is-link is-primary')); ?> <!-- na classe vai o css -->
                                 </center>
                                 </div>
                                 <?php echo form_close(); ?>
                                 </article>
                                </div>
                              <button class="modal-close is-large" aria-label="close" onclick="refs.modalEdicion.close()"></button>
                          </div>

                    </p>
                </div>
                <div class="column is-5 is-offset-1">
                  <figure class="image is-512x">
                    <img class ="is-rounded" src="https://rastreio.me/img.png" alt="box">
                  </figure>


                </div>

            </div>
        </div>
    </div>
  </div>
</section>

<script>
/* Modal */
var refs = {
  modalEdicion: {
    open: function() { document.getElementById('modalEdicion').classList.add('is-active');
    },
    close:function() { document.getElementById('modalEdicion').classList.remove('is-active');

    }
  }
};
/* Senha */
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
