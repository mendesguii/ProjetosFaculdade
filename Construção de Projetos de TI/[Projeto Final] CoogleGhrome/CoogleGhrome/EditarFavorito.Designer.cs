namespace View
{
    partial class EditarFavorito
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
            this.lblNome = new System.Windows.Forms.Label();
            this.txtboxNome = new System.Windows.Forms.TextBox();
            this.btnEditarFav = new System.Windows.Forms.Button();
            this.lblLink = new System.Windows.Forms.Label();
            this.txtboxLink = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lblNome
            // 
            this.lblNome.AutoSize = true;
            this.lblNome.Location = new System.Drawing.Point(39, 58);
            this.lblNome.Name = "lblNome";
            this.lblNome.Size = new System.Drawing.Size(35, 13);
            this.lblNome.TabIndex = 0;
            this.lblNome.Text = "Nome";
            // 
            // txtboxNome
            // 
            this.txtboxNome.Location = new System.Drawing.Point(108, 55);
            this.txtboxNome.Name = "txtboxNome";
            this.txtboxNome.Size = new System.Drawing.Size(253, 20);
            this.txtboxNome.TabIndex = 1;
            // 
            // btnEditarFav
            // 
            this.btnEditarFav.Location = new System.Drawing.Point(163, 146);
            this.btnEditarFav.Name = "btnEditarFav";
            this.btnEditarFav.Size = new System.Drawing.Size(75, 23);
            this.btnEditarFav.TabIndex = 2;
            this.btnEditarFav.Text = "Editar";
            this.btnEditarFav.UseVisualStyleBackColor = true;
            this.btnEditarFav.Click += new System.EventHandler(this.btnEditarFav_Click);
            // 
            // lblLink
            // 
            this.lblLink.AutoSize = true;
            this.lblLink.Location = new System.Drawing.Point(39, 97);
            this.lblLink.Name = "lblLink";
            this.lblLink.Size = new System.Drawing.Size(27, 13);
            this.lblLink.TabIndex = 0;
            this.lblLink.Text = "Link";
            // 
            // txtboxLink
            // 
            this.txtboxLink.Location = new System.Drawing.Point(108, 94);
            this.txtboxLink.Name = "txtboxLink";
            this.txtboxLink.Size = new System.Drawing.Size(253, 20);
            this.txtboxLink.TabIndex = 1;
            // 
            // EditarFavorito
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(409, 193);
            this.Controls.Add(this.btnEditarFav);
            this.Controls.Add(this.txtboxLink);
            this.Controls.Add(this.lblLink);
            this.Controls.Add(this.txtboxNome);
            this.Controls.Add(this.lblNome);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "EditarFavorito";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Editar Historico";
            this.Load += new System.EventHandler(this.EditarFavorito_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNome;
        private System.Windows.Forms.TextBox txtboxNome;
        private System.Windows.Forms.Button btnEditarFav;
        private System.Windows.Forms.Label lblLink;
        private System.Windows.Forms.TextBox txtboxLink;
    }
}