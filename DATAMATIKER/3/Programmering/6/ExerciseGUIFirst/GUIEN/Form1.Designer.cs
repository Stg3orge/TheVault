namespace GUIEN
{
    partial class Form1
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
            this.ShowLabel = new System.Windows.Forms.Button();
            this.Shown = new System.Windows.Forms.Label();
            this.inputbox = new System.Windows.Forms.TextBox();
            this.shownPersonsBox = new System.Windows.Forms.ListBox();
            this.printPersonList = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // ShowLabel
            // 
            this.ShowLabel.Location = new System.Drawing.Point(63, 24);
            this.ShowLabel.Name = "ShowLabel";
            this.ShowLabel.Size = new System.Drawing.Size(152, 23);
            this.ShowLabel.TabIndex = 0;
            this.ShowLabel.Text = "Show Label";
            this.ShowLabel.UseVisualStyleBackColor = true;
            this.ShowLabel.Click += new System.EventHandler(this.ShowLabel_Click);
            // 
            // Shown
            // 
            this.Shown.AutoSize = true;
            this.Shown.Location = new System.Drawing.Point(101, 120);
            this.Shown.Name = "Shown";
            this.Shown.Size = new System.Drawing.Size(70, 17);
            this.Shown.TabIndex = 1;
            this.Shown.Text = "LABELLO";
            // 
            // inputbox
            // 
            this.inputbox.Location = new System.Drawing.Point(86, 66);
            this.inputbox.Name = "inputbox";
            this.inputbox.Size = new System.Drawing.Size(100, 22);
            this.inputbox.TabIndex = 2;
            // 
            // shownPersonsBox
            // 
            this.shownPersonsBox.FormattingEnabled = true;
            this.shownPersonsBox.ItemHeight = 16;
            this.shownPersonsBox.Location = new System.Drawing.Point(298, 190);
            this.shownPersonsBox.Name = "shownPersonsBox";
            this.shownPersonsBox.Size = new System.Drawing.Size(120, 84);
            this.shownPersonsBox.TabIndex = 3;
            this.shownPersonsBox.SelectedIndexChanged += new System.EventHandler(this.shownPersonsBox_SelectedIndexChanged);
            // 
            // printPersonList
            // 
            this.printPersonList.Location = new System.Drawing.Point(187, 216);
            this.printPersonList.Name = "printPersonList";
            this.printPersonList.Size = new System.Drawing.Size(75, 23);
            this.printPersonList.TabIndex = 4;
            this.printPersonList.Text = "Show all";
            this.printPersonList.UseVisualStyleBackColor = true;
            this.printPersonList.Click += new System.EventHandler(this.printPersonList_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(310, 306);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(108, 17);
            this.label1.TabIndex = 6;
            this.label1.Text = "SelectedPerson";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(524, 426);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.printPersonList);
            this.Controls.Add(this.shownPersonsBox);
            this.Controls.Add(this.inputbox);
            this.Controls.Add(this.Shown);
            this.Controls.Add(this.ShowLabel);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button ShowLabel;
        private System.Windows.Forms.Label Shown;
        private System.Windows.Forms.TextBox inputbox;
        private System.Windows.Forms.ListBox shownPersonsBox;
        private System.Windows.Forms.Button printPersonList;
        private System.Windows.Forms.Label label1;
    }
}

