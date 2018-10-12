namespace ProperGui
{
    partial class Form2
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
            this.page1button = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // page1button
            // 
            this.page1button.Location = new System.Drawing.Point(32, 13);
            this.page1button.Name = "page1button";
            this.page1button.Size = new System.Drawing.Size(211, 23);
            this.page1button.TabIndex = 0;
            this.page1button.Text = "Go to page 1";
            this.page1button.UseVisualStyleBackColor = true;
            this.page1button.Click += new System.EventHandler(this.page1button_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(282, 253);
            this.Controls.Add(this.page1button);
            this.Name = "Form2";
            this.Text = "Form2";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button page1button;
    }
}