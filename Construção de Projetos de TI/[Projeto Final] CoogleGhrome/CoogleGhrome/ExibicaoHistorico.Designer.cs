namespace View
{
    partial class ExibicaoHistorico
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ExibicaoHistorico));
            this.listView1 = new System.Windows.Forms.ListView();
            this.headerLink = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.headerData = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.btnDeleteHistorico = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.SuspendLayout();
            // 
            // listView1
            // 
            this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.headerLink,
            this.headerData});
            this.listView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.listView1.GridLines = true;
            this.listView1.Location = new System.Drawing.Point(0, 0);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(662, 439);
            this.listView1.TabIndex = 0;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.Details;
            // 
            // headerLink
            // 
            this.headerLink.Text = "Link";
            this.headerLink.Width = 418;
            // 
            // headerData
            // 
            this.headerData.Text = "Data";
            this.headerData.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.headerData.Width = 206;
            // 
            // btnDeleteHistorico
            // 
            this.btnDeleteHistorico.Location = new System.Drawing.Point(0, 417);
            this.btnDeleteHistorico.Name = "btnDeleteHistorico";
            this.btnDeleteHistorico.Size = new System.Drawing.Size(70, 23);
            this.btnDeleteHistorico.TabIndex = 1;
            this.btnDeleteHistorico.Text = "Deletar";
            this.btnDeleteHistorico.UseVisualStyleBackColor = true;
            this.btnDeleteHistorico.Click += new System.EventHandler(this.DeletarHistorico_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.BackColor = System.Drawing.SystemColors.AppWorkspace;
            this.statusStrip1.Location = new System.Drawing.Point(0, 417);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(662, 22);
            this.statusStrip1.TabIndex = 2;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // ExibicaoHistorico
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(662, 439);
            this.Controls.Add(this.btnDeleteHistorico);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.listView1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ExibicaoHistorico";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Histórico";
            this.Load += new System.EventHandler(this.ExibicaoHistorico_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.ColumnHeader headerLink;
        private System.Windows.Forms.ColumnHeader headerData;
        private System.Windows.Forms.Button btnDeleteHistorico;
        private System.Windows.Forms.StatusStrip statusStrip1;
    }
}