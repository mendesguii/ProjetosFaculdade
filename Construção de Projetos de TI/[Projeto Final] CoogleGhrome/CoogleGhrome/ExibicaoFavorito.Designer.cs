namespace View
{
    partial class ExibicaoFavorito
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ExibicaoFavorito));
            this.listFav = new System.Windows.Forms.ListView();
            this.colNomeFav = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colLinkFav = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.btnDeletarFavorito = new System.Windows.Forms.Button();
            this.btnEditar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listFav
            // 
            this.listFav.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.listFav.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colNomeFav,
            this.colLinkFav});
            this.listFav.Dock = System.Windows.Forms.DockStyle.Fill;
            this.listFav.GridLines = true;
            this.listFav.Location = new System.Drawing.Point(0, 0);
            this.listFav.Name = "listFav";
            this.listFav.Size = new System.Drawing.Size(662, 439);
            this.listFav.TabIndex = 0;
            this.listFav.UseCompatibleStateImageBehavior = false;
            this.listFav.View = System.Windows.Forms.View.Details;
            // 
            // colNomeFav
            // 
            this.colNomeFav.Text = "Nome";
            this.colNomeFav.Width = 270;
            // 
            // colLinkFav
            // 
            this.colLinkFav.Text = "Link";
            this.colLinkFav.Width = 388;
            // 
            // statusStrip1
            // 
            this.statusStrip1.BackColor = System.Drawing.SystemColors.AppWorkspace;
            this.statusStrip1.Location = new System.Drawing.Point(0, 417);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(662, 22);
            this.statusStrip1.TabIndex = 1;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // btnDeletarFavorito
            // 
            this.btnDeletarFavorito.Location = new System.Drawing.Point(0, 417);
            this.btnDeletarFavorito.Name = "btnDeletarFavorito";
            this.btnDeletarFavorito.Size = new System.Drawing.Size(70, 23);
            this.btnDeletarFavorito.TabIndex = 2;
            this.btnDeletarFavorito.Text = "Deletar";
            this.btnDeletarFavorito.UseVisualStyleBackColor = true;
            this.btnDeletarFavorito.Click += new System.EventHandler(this.btnDeletarFavorito_Click);
            // 
            // btnEditar
            // 
            this.btnEditar.Location = new System.Drawing.Point(587, 416);
            this.btnEditar.Name = "btnEditar";
            this.btnEditar.Size = new System.Drawing.Size(75, 23);
            this.btnEditar.TabIndex = 3;
            this.btnEditar.Text = "Editar";
            this.btnEditar.UseVisualStyleBackColor = true;
            this.btnEditar.Click += new System.EventHandler(this.btnEditarFav_Click);
            // 
            // ExibicaoFavorito
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(662, 439);
            this.Controls.Add(this.btnEditar);
            this.Controls.Add(this.btnDeletarFavorito);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.listFav);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ExibicaoFavorito";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Favoritos";
            this.Load += new System.EventHandler(this.ExibicaoFavorito_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView listFav;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ColumnHeader colNomeFav;
        private System.Windows.Forms.ColumnHeader colLinkFav;
        private System.Windows.Forms.Button btnDeletarFavorito;
        private System.Windows.Forms.Button btnEditar;
    }
}