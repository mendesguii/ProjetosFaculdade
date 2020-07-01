<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?><!DOCTYPE html>
<?php echo $this->session->flashdata('erro'); ?>
<?php echo $this->session->flashdata('sucesso'); ?>
<html>
<body>
  <br>

</section>
<section class="hero is-info welcome is-small">
          <div class="hero-body">
              <div class="container">
                <div style=" float:right;">
                <button class="button is-light" onclick="refs.modalEdicion.open()">
                        <span>Editar Informações</span>
                    </button>
                  </div>
                  <h1 class="title">
                      Bem vindo, <?php echo $_SESSION['nome']; ?>
                  </h1>
                  <h2 class="subtitle">
                      Esperamos que suas encomendas estejam chegando a tempo!
                  </h2>
                </div>
          </div>
<br>
      </section>
      <article class='tile is-child box'>
               <section class="info-tiles">
                   <div class="tile is-ancestor ">

                       <div class="tile is-parent" align='center'>
                           <article class="tile is-child box">
                               <p class="title"><?php
                               if(isset($count))
                               {
                                 echo $count;
                               }
                                 else {
                                   echo '0';
                                 }
                                ?></p>
                               <p class="subtitle">Encomendas</p>
                           </article>
                       </div>
                       <div class="tile is-parent">

                             <article class="tile is-child box">
                                <div align='center'>
                                 <p class="title"><?php
                                 if(isset($count_att))
                                 {
                                   echo $count_att;
                                 }
                                   else {
                                     echo '0';
                                   }
                                  ?></p>
                                 <p class="subtitle">Atualizações por E-mail</p>
                                 </div>
                             </article>


                                   <div class="modal" id="modalEdicion">
                                     <div onclick="refs.modalEdicion.close()" class="modal-background"></div>
                                     <div class="modal-card">

                                        <article class='tile is-child box'>
                                        <p class="title">Editar Informações</p>
                                        <?php echo form_open('Cadastro/editar'); ?>
                                        <label class="label">Nome</label>
                                        <input type="text" class="input" name="Nome" placeholder="<?php echo $_SESSION['nome']; ?>" disabled>
                                        <br>
               <div class="field">
                 <label class="label">Usuário</label>
                 <div class="control has-icons-left has-icons-right">
                   <input type="text" class="input" name="Usuario" pattern="[A-Za-z0-9]{3,10}" maxlength="10" placeholder="<?php echo $_SESSION['usuario']; ?>"  disabled>
                   <span class="icon is-small is-left">
                     <b class="fas fa-user"></b>
                   </span>
                  </div>

               <div class="field">
                 <label class="label">E-mail</label>
                 <div class="control has-icons-left has-icons-right">
                    <input type="email" class="input" name="Email" placeholder="<?php echo $_SESSION['email']; ?>" disabled>
                   <span class="icon is-small is-left">
                     <b class="fas fa-envelope"></b>
                   </span>
                  </div>

               <div class="field">
                 <label class="label">Senha antiga</label>
                 <div class="control has-icons-left has-icons-right">
                    <input type="password" class="input" maxlength='8' name="Senha_antiga" id="pass" placeholder="Informe sua senha antiga" required>
                   <span class="icon is-small is-left">
                     <b class="fas fa-lock"></b>
                   </span>
                  </div>
                  <div class="field">
                    <label class="label">Senha nova</label>
                    <div class="control has-icons-left has-icons-right">
                       <input type="password" class="input" maxlength='8' name="Senhanova1" id="pass1" placeholder="Informe sua senha nova" required>
                      <span class="icon is-small is-left">
                        <b class="fas fa-lock"></b>
                      </span>
                     </div>
                  </div>
                  <div class="field">
                    <label class="label">Confirme a senha nova</label>
                    <div class="control has-icons-left has-icons-right">
                       <input type="password" class="input" maxlength='8' name="Senhanova2" id="pass2" placeholder="Confirme sua senha nova" required>
                      <span class="icon is-small is-left">
                        <b class="fas fa-lock"></b>
                      </span>
                     </div>
                  </div>
                     <br>
                      <center>
                                        <?php echo form_submit(array('id' => 'submit', 'value' => 'Editar', 'class'=>'button is-link is-fullwidth is-primary')); ?> <!-- na classe vai o css -->
                                        <?php echo form_close(); ?>
                                        </center>
                                      </div>
                                        </article>
                                       </div>
                                     <button class="modal-close is-large" aria-label="close" onclick="refs.modalEdicion.close()"></button>
                                 </div>
                           </article>
                       </div>

                   </div>
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
