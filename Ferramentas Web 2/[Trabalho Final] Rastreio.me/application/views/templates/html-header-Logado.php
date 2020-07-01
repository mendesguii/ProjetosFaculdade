</head>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Solução final para o rastreio de forma fácil, prática e eficiente das suas encomendas.">
    <meta name="google-site-verification" content="jFb7eShV_JmWcQa0hDsS1zaB-RuMs3fSixnNxZWOj7s" />
    <meta name="msvalidate.01" content="B48B766D07C5D900F3B1AE90A2221007" />
        <title>Rastreio.me</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">

        <link rel="shortcut icon" type="image/png" href="https://rastreio.me/favicon.png"/>
        <!-- Bulma Version 0.7.1-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>


        <section class="hero is-info is-medium is-bold">
            <div class="hero-head">
                <nav class="navbar">
                    <div class="container">
                        <div class="navbar-brand">
                            <a class="navbar-item" href="<?php echo base_url(''); ?>">
                                <img src="https://rastreio.me/logo.png" alt="Logo">
                            </a>
                            <span class="navbar-burger burger" data-target="navbarMenu">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </div>
                        <div id="navbarMenu" class="navbar-menu">
                            <div class="navbar-end">
                                <div class="tabs is-right">
                                    <ul>
                                        <li class=""><a href="<?php echo base_url(); ?>">Home</a></li>
                                        <li class="is-active"><a href="<?php echo base_url('/Encomendas'); ?>">Encomendas</a></li>
                                        <li class=""><a href="<?php echo base_url('/Perfil'); ?>"> <?php echo $_SESSION['nome']; ?> </a></li>

                                    </ul>

                                        <span class="navbar-item">
                                        <a class="button is-white is-outlined" href="<?php echo base_url('/Login/deslogar'); ?>">

                                            <span title="">Sair</span>
                                        </a>
                                    </span>

                                </div>
                            </div>

                        </div>
                    </div>
                </nav>
            </div>
</head>
</section>


<script>
(function() {
    var burger = document.querySelector('.burger');
    var menu = document.querySelector('#'+burger.dataset.target);
    burger.addEventListener('click', function() {
        burger.classList.toggle('is-active');
        menu.classList.toggle('is-active');
    });
})();

</script>
