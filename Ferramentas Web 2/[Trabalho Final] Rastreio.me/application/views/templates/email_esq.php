
 <!DOCTYPE html>
 <html style="box-sizing: border-box;margin: 0;padding: 0;background-color: #fff;font-size: 16px;-moz-osx-font-smoothing: grayscale;-webkit-font-smoothing: antialiased;min-width: 300px;overflow-x: hidden;overflow-y: scroll;text-rendering: optimizeLegibility;-webkit-text-size-adjust: 100%;-moz-text-size-adjust: 100%;-ms-text-size-adjust: 100%;text-size-adjust: 100%;">
     <head style="box-sizing: inherit;">
         <meta charset="utf-8" style="box-sizing: inherit;">
         <meta http-equiv="X-UA-Compatible" content="IE=edge" style="box-sizing: inherit;">
         <meta name="viewport" content="width=device-width, initial-scale=1" style="box-sizing: inherit;">
         <title style="box-sizing: inherit;">Rastreio.me</title>
         <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" style="box-sizing: inherit;">

         <link rel="shortcut icon" type="image/png" href="http://rastreio.me/favicon.png" style="box-sizing: inherit;">
         <!-- Bulma Version 0.7.1-->
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css" style="box-sizing: inherit;">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" style="box-sizing: inherit;">
         <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js" style="box-sizing: inherit;"></script>


         <section class="hero is-info is-medium is-bold" style="box-sizing: inherit;display: flex;align-items: stretch;flex-direction: column;justify-content: space-between;background-color: #209cee;color: #fff;background-image: linear-gradient(141deg,#04a6d7 0,#209cee 71%,#3287f5 100%);">
             <div class="hero-head" style="box-sizing: inherit;flex-grow: 0;flex-shrink: 0;">
                 <nav class="navbar" style="box-sizing: inherit;background-color: #fff;min-height: 3.25rem;position: relative;z-index: 30;background: 0 0;">
                     <div class="container" style="box-sizing: inherit;margin: 0 auto;position: relative;align-items: stretch;display: flex;min-height: 3.25rem;width: 100%;">
                         <div class="navbar-brand" style="box-sizing: inherit;align-items: stretch;display: flex;flex-shrink: 0;min-height: 3.25rem;margin-left: -.75rem;">
                             <a class="navbar-item" href="&lt;?php echo base_url(''); ?&gt;" style="box-sizing: inherit;color: inherit;cursor: pointer;text-decoration: none;display: flex;line-height: 1.5;padding: .5rem .75rem;position: relative;align-items: center;flex-grow: 0;flex-shrink: 0;">
                                 <img src="https://rastreio.me/logo.png" alt="Logo" style="box-sizing: inherit;height: auto;max-width: 100%;max-height: 1.75rem;">
                             </a>
                       </div>
                     </div>
                 </nav>

           </div>
 </section>
     <article class="tile is-child notification" style="box-sizing: inherit;display: block;background-color: #f5f5f5;border-radius: 4px;padding: 1.25rem 2.5rem 1.25rem 1.5rem;position: relative;align-items: stretch;flex-basis: 0;flex-grow: 1;flex-shrink: 1;min-height: min-content;margin-bottom: 1.5rem;margin: 0!important;"><center style="box-sizing: inherit;">
       <div class="container" align="left" style="box-sizing: inherit;margin: 0 auto;position: relative;">
         <br style="box-sizing: inherit;"><br style="box-sizing: inherit;">


         <p class="title" style="box-sizing: inherit;margin: 0;padding: 0;word-break: break-word;color: currentColor;font-size: 2rem;font-weight: 600;line-height: 1.125;margin-bottom: 1.5rem;">  Olá <?php echo $dados[0]->nome; ?>, </p>
         <p class="subtitle" style="box-sizing: inherit;margin: 0;padding: 0;word-break: break-word;color: currentColor;font-size: 1.25rem;font-weight: 400;line-height: 1.25;margin-bottom: 1.5rem;margin-top: -1.25rem;">Você solicitou a troca da senha da sua conta.</p>
         <br style="box-sizing: inherit;"><br style="box-sizing: inherit;">


       </div>
        <div align="center" style="box-sizing: inherit;">
            <a href="<?php

            $url='Esqueci/'.md5($dados[0]->usuario).'/'.$dados[0]->id;
            echo base_url().$url;
            ?>" style="font-size: 1.25rem;">Clique Aqui</a>

        <div style="box-sizing: inherit;">


           </div></div></center>
         </article>
         <section class="hero is-info is-medium is-bold" style="box-sizing: inherit;display: flex;align-items: stretch;flex-direction: column;justify-content: space-between;background-color: #209cee;color: #fff;background-image: linear-gradient(141deg,#04a6d7 0,#209cee 71%,#3287f5 100%);">
             <div class="hero-head" style="box-sizing: inherit;flex-grow: 0;flex-shrink: 0;">
                 <nav class="navbar" style="box-sizing: inherit;background-color: #fff;min-height: 3.25rem;position: relative;z-index: 30;background: 0 0;">
                     <div class="container" style="box-sizing: inherit;margin: 0 auto;position: relative;align-items: stretch;display: flex;min-height: 3.25rem;width: 100%;">
                         <div class="navbar-brand" style="box-sizing: inherit;align-items: stretch;display: flex;flex-shrink: 0;min-height: 3.25rem;margin-left: -.75rem;">

                       </div>
                     </div>
                 </nav>

           </div>
         </section>
</head></html>
