namespace Retrieve1 {
    partial class Form1 {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.listBoxProducts = new System.Windows.Forms.ListBox();
            this.labelResult = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // listBoxProducts
            // 
            this.listBoxProducts.FormattingEnabled = true;
            this.listBoxProducts.ItemHeight = 16;
            this.listBoxProducts.Location = new System.Drawing.Point(12, 54);
            this.listBoxProducts.Name = "listBoxProducts";
            this.listBoxProducts.Size = new System.Drawing.Size(261, 340);
            this.listBoxProducts.TabIndex = 0;
            // 
            // labelResult
            // 
            this.labelResult.AutoSize = true;
            this.labelResult.Location = new System.Drawing.Point(289, 54);
            this.labelResult.Name = "labelResult";
            this.labelResult.Size = new System.Drawing.Size(16, 17);
            this.labelResult.TabIndex = 1;
            this.labelResult.Text = "..";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(580, 419);
            this.Controls.Add(this.labelResult);
            this.Controls.Add(this.listBoxProducts);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox listBoxProducts;
        private System.Windows.Forms.Label labelResult;
    }
}

