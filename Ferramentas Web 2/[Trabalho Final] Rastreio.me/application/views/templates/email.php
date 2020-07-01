
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="box-sizing: border-box;margin: 0;padding: 0;background-color: #fff;font-size: 16px;-moz-osx-font-smoothing: grayscale;-webkit-font-smoothing: antialiased;min-width: 300px;overflow-x: hidden;overflow-y: scroll;text-rendering: optimizeLegibility;-webkit-text-size-adjust: 100%;-moz-text-size-adjust: 100%;-ms-text-size-adjust: 100%;text-size-adjust: 100%;">
    <head style="box-sizing: inherit;">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" style="box-sizing: inherit;">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" style="box-sizing: inherit;">

        <meta charset="utf-8" style="box-sizing: inherit;">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" style="box-sizing: inherit;">
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
        <p class="subtitle" style="box-sizing: inherit;margin: 0;padding: 0;word-break: break-word;color: currentColor;font-size: 1.25rem;font-weight: 400;line-height: 1.25;margin-bottom: 1.5rem;margin-top: -1.25rem;">Aqui estão as últimas atualizações da sua encomenda<b style="box-sizing: inherit;"> <?php echo $dados[0]->descricao; ?></b>.</p>
        <br style="box-sizing: inherit;"><br style="box-sizing: inherit;">


      </div>


          <table class="table is-striped is-fullwidth" style="box-sizing: inherit;border-collapse: collapse;border-spacing: 0;background-color: #fff;color: #363636;width: 100%;">
          <thead style="box-sizing: inherit;">
            <tr style="box-sizing: inherit;">
              <th style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;color: #363636;border: 1px solid #dbdbdb;border-width: 0 0 2px;"><abbr style="box-sizing: inherit;">Cód. de Rastreio</abbr></th>
              <th style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;color: #363636;border: 1px solid #dbdbdb;border-width: 0 0 2px;"><abbr style="box-sizing: inherit;"></abbr></th>
              <th style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;color: #363636;border: 1px solid #dbdbdb;border-width: 0 0 2px;"><abbr style="box-sizing: inherit;">Data</abbr></th>
              <th style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;color: #363636;border: 1px solid #dbdbdb;border-width: 0 0 2px;"><abbr style="box-sizing: inherit;"></abbr></th>
              <th style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;color: #363636;border: 1px solid #dbdbdb;border-width: 0 0 2px;"><abbr style="box-sizing: inherit;">Status</abbr></th>
            </tr>
          </thead>
            <tbody style="box-sizing: inherit;">

              <tr style="box-sizing: inherit;">
              <td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;"> <?php echo $dados[0]->cod_rastreio; ?> </td><td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;">
              </td><td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;"> <?php echo $dados[0]->data; ?> </td><td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;">
              </td><td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;"> <?php echo $dados[0]->status; ?> </td><td style="box-sizing: inherit;padding: .5em .75em;text-align: left;vertical-align: top;border: 1px solid #dbdbdb;border-width: 0 0 1px;">
              </td></tr>
            </tbody>


          </table></center>
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
