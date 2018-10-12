namespace CrudCombined {
    partial class Combined {
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.labelResult = new System.Windows.Forms.Label();
            this.buttonProductsAll = new System.Windows.Forms.Button();
            this.labelProdIns = new System.Windows.Forms.Label();
            this.labelProdName = new System.Windows.Forms.Label();
            this.labelProdPrice = new System.Windows.Forms.Label();
            this.tbProdName = new System.Windows.Forms.TextBox();
            this.tbProdPrice = new System.Windows.Forms.TextBox();
            this.btnProdIns = new System.Windows.Forms.Button();
            this.labelInsResult = new System.Windows.Forms.Label();
            this.labelReadProd = new System.Windows.Forms.Label();
            this.tbProdNameS = new System.Windows.Forms.TextBox();
            this.labelProdNameS = new System.Windows.Forms.Label();
            this.tbProdPriceS = new System.Windows.Forms.TextBox();
            this.labelProdPriceS = new System.Windows.Forms.Label();
            this.labelSearchId = new System.Windows.Forms.Label();
            this.tbSearchId = new System.Windows.Forms.TextBox();
            this.labelProdId = new System.Windows.Forms.Label();
            this.tbProdIdS = new System.Windows.Forms.TextBox();
            this.btnSearch = new System.Windows.Forms.Button();
            this.labelSearchResult = new System.Windows.Forms.Label();
            this.btnSearchParam = new System.Windows.Forms.Button();
            this.btnSearchStoredProcedure = new System.Windows.Forms.Button();
            this.btnInsertStoredProcedure = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.BackgroundColor = System.Drawing.SystemColors.ControlLightLight;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(33, 84);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(550, 450);
            this.dataGridView1.TabIndex = 0;
            // 
            // labelResult
            // 
            this.labelResult.AutoSize = true;
            this.labelResult.Location = new System.Drawing.Point(30, 547);
            this.labelResult.Name = "labelResult";
            this.labelResult.Size = new System.Drawing.Size(107, 17);
            this.labelResult.TabIndex = 1;
            this.labelResult.Text = "Number of rows";
            // 
            // buttonProductsAll
            // 
            this.buttonProductsAll.Location = new System.Drawing.Point(33, 55);
            this.buttonProductsAll.Name = "buttonProductsAll";
            this.buttonProductsAll.Size = new System.Drawing.Size(130, 29);
            this.buttonProductsAll.TabIndex = 2;
            this.buttonProductsAll.Text = "Get all products";
            this.buttonProductsAll.UseVisualStyleBackColor = true;
            this.buttonProductsAll.Click += new System.EventHandler(this.buttonProductsAll_Click);
            // 
            // labelProdIns
            // 
            this.labelProdIns.AutoSize = true;
            this.labelProdIns.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelProdIns.Location = new System.Drawing.Point(614, 84);
            this.labelProdIns.Name = "labelProdIns";
            this.labelProdIns.Size = new System.Drawing.Size(109, 17);
            this.labelProdIns.TabIndex = 3;
            this.labelProdIns.Text = "Insert product";
            // 
            // labelProdName
            // 
            this.labelProdName.AutoSize = true;
            this.labelProdName.Location = new System.Drawing.Point(635, 110);
            this.labelProdName.Name = "labelProdName";
            this.labelProdName.Size = new System.Drawing.Size(100, 17);
            this.labelProdName.TabIndex = 4;
            this.labelProdName.Text = "Product name:";
            // 
            // labelProdPrice
            // 
            this.labelProdPrice.AutoSize = true;
            this.labelProdPrice.Location = new System.Drawing.Point(635, 139);
            this.labelProdPrice.Name = "labelProdPrice";
            this.labelProdPrice.Size = new System.Drawing.Size(93, 17);
            this.labelProdPrice.TabIndex = 5;
            this.labelProdPrice.Text = "ProductPrice:";
            // 
            // tbProdName
            // 
            this.tbProdName.Location = new System.Drawing.Point(742, 104);
            this.tbProdName.Name = "tbProdName";
            this.tbProdName.Size = new System.Drawing.Size(100, 22);
            this.tbProdName.TabIndex = 6;
            // 
            // tbProdPrice
            // 
            this.tbProdPrice.Location = new System.Drawing.Point(742, 133);
            this.tbProdPrice.Name = "tbProdPrice";
            this.tbProdPrice.Size = new System.Drawing.Size(66, 22);
            this.tbProdPrice.TabIndex = 7;
            // 
            // btnProdIns
            // 
            this.btnProdIns.Location = new System.Drawing.Point(742, 161);
            this.btnProdIns.Name = "btnProdIns";
            this.btnProdIns.Size = new System.Drawing.Size(114, 36);
            this.btnProdIns.TabIndex = 8;
            this.btnProdIns.Text = "Insert product";
            this.btnProdIns.UseVisualStyleBackColor = true;
            this.btnProdIns.Click += new System.EventHandler(this.btnProdIns_Click);
            // 
            // labelInsResult
            // 
            this.labelInsResult.AutoSize = true;
            this.labelInsResult.Location = new System.Drawing.Point(614, 215);
            this.labelInsResult.Name = "labelInsResult";
            this.labelInsResult.Size = new System.Drawing.Size(16, 17);
            this.labelInsResult.TabIndex = 9;
            this.labelInsResult.Text = "..";
            // 
            // labelReadProd
            // 
            this.labelReadProd.AutoSize = true;
            this.labelReadProd.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelReadProd.Location = new System.Drawing.Point(614, 282);
            this.labelReadProd.Name = "labelReadProd";
            this.labelReadProd.Size = new System.Drawing.Size(119, 17);
            this.labelReadProd.TabIndex = 10;
            this.labelReadProd.Text = "Search product";
            // 
            // tbProdNameS
            // 
            this.tbProdNameS.Location = new System.Drawing.Point(742, 371);
            this.tbProdNameS.Name = "tbProdNameS";
            this.tbProdNameS.Size = new System.Drawing.Size(100, 22);
            this.tbProdNameS.TabIndex = 12;
            // 
            // labelProdNameS
            // 
            this.labelProdNameS.AutoSize = true;
            this.labelProdNameS.Location = new System.Drawing.Point(635, 377);
            this.labelProdNameS.Name = "labelProdNameS";
            this.labelProdNameS.Size = new System.Drawing.Size(100, 17);
            this.labelProdNameS.TabIndex = 11;
            this.labelProdNameS.Text = "Product name:";
            // 
            // tbProdPriceS
            // 
            this.tbProdPriceS.Location = new System.Drawing.Point(742, 399);
            this.tbProdPriceS.Name = "tbProdPriceS";
            this.tbProdPriceS.Size = new System.Drawing.Size(66, 22);
            this.tbProdPriceS.TabIndex = 14;
            // 
            // labelProdPriceS
            // 
            this.labelProdPriceS.AutoSize = true;
            this.labelProdPriceS.Location = new System.Drawing.Point(635, 405);
            this.labelProdPriceS.Name = "labelProdPriceS";
            this.labelProdPriceS.Size = new System.Drawing.Size(93, 17);
            this.labelProdPriceS.TabIndex = 13;
            this.labelProdPriceS.Text = "ProductPrice:";
            // 
            // labelSearchId
            // 
            this.labelSearchId.AutoSize = true;
            this.labelSearchId.Location = new System.Drawing.Point(635, 310);
            this.labelSearchId.Name = "labelSearchId";
            this.labelSearchId.Size = new System.Drawing.Size(68, 17);
            this.labelSearchId.TabIndex = 15;
            this.labelSearchId.Text = "Search id";
            // 
            // tbSearchId
            // 
            this.tbSearchId.Location = new System.Drawing.Point(709, 305);
            this.tbSearchId.Name = "tbSearchId";
            this.tbSearchId.Size = new System.Drawing.Size(41, 22);
            this.tbSearchId.TabIndex = 16;
            // 
            // labelProdId
            // 
            this.labelProdId.AutoSize = true;
            this.labelProdId.Location = new System.Drawing.Point(635, 346);
            this.labelProdId.Name = "labelProdId";
            this.labelProdId.Size = new System.Drawing.Size(76, 17);
            this.labelProdId.TabIndex = 17;
            this.labelProdId.Text = "Product id:";
            // 
            // tbProdIdS
            // 
            this.tbProdIdS.Location = new System.Drawing.Point(742, 341);
            this.tbProdIdS.Name = "tbProdIdS";
            this.tbProdIdS.Size = new System.Drawing.Size(44, 22);
            this.tbProdIdS.TabIndex = 18;
            // 
            // btnSearch
            // 
            this.btnSearch.Location = new System.Drawing.Point(786, 291);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(139, 36);
            this.btnSearch.TabIndex = 19;
            this.btnSearch.Text = "Search product";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // labelSearchResult
            // 
            this.labelSearchResult.AutoSize = true;
            this.labelSearchResult.Location = new System.Drawing.Point(614, 444);
            this.labelSearchResult.Name = "labelSearchResult";
            this.labelSearchResult.Size = new System.Drawing.Size(16, 17);
            this.labelSearchResult.TabIndex = 20;
            this.labelSearchResult.Text = "..";
            // 
            // btnSearchParam
            // 
            this.btnSearchParam.Location = new System.Drawing.Point(939, 291);
            this.btnSearchParam.Name = "btnSearchParam";
            this.btnSearchParam.Size = new System.Drawing.Size(88, 36);
            this.btnSearchParam.TabIndex = 21;
            this.btnSearchParam.Text = "Search P";
            this.btnSearchParam.UseVisualStyleBackColor = true;
            this.btnSearchParam.Click += new System.EventHandler(this.btnSearchParam_Click);
            // 
            // btnSearchStoredProcedure
            // 
            this.btnSearchStoredProcedure.Location = new System.Drawing.Point(1042, 291);
            this.btnSearchStoredProcedure.Name = "btnSearchStoredProcedure";
            this.btnSearchStoredProcedure.Size = new System.Drawing.Size(99, 36);
            this.btnSearchStoredProcedure.TabIndex = 22;
            this.btnSearchStoredProcedure.Text = "Search S P";
            this.btnSearchStoredProcedure.UseVisualStyleBackColor = true;
            this.btnSearchStoredProcedure.Click += new System.EventHandler(this.btnSearchStoredProcedure_Click);
            // 
            // btnInsertStoredProcedure
            // 
            this.btnInsertStoredProcedure.Location = new System.Drawing.Point(871, 161);
            this.btnInsertStoredProcedure.Name = "btnInsertStoredProcedure";
            this.btnInsertStoredProcedure.Size = new System.Drawing.Size(104, 36);
            this.btnInsertStoredProcedure.TabIndex = 23;
            this.btnInsertStoredProcedure.Text = "Insert S P";
            this.btnInsertStoredProcedure.UseVisualStyleBackColor = true;
            this.btnInsertStoredProcedure.Click += new System.EventHandler(this.btnInsertStoredProcedure_Click);
            // 
            // Combined
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1218, 587);
            this.Controls.Add(this.btnInsertStoredProcedure);
            this.Controls.Add(this.btnSearchStoredProcedure);
            this.Controls.Add(this.btnSearchParam);
            this.Controls.Add(this.labelSearchResult);
            this.Controls.Add(this.btnSearch);
            this.Controls.Add(this.tbProdIdS);
            this.Controls.Add(this.labelProdId);
            this.Controls.Add(this.tbSearchId);
            this.Controls.Add(this.labelSearchId);
            this.Controls.Add(this.tbProdPriceS);
            this.Controls.Add(this.labelProdPriceS);
            this.Controls.Add(this.tbProdNameS);
            this.Controls.Add(this.labelProdNameS);
            this.Controls.Add(this.labelReadProd);
            this.Controls.Add(this.labelInsResult);
            this.Controls.Add(this.btnProdIns);
            this.Controls.Add(this.tbProdPrice);
            this.Controls.Add(this.tbProdName);
            this.Controls.Add(this.labelProdPrice);
            this.Controls.Add(this.labelProdName);
            this.Controls.Add(this.labelProdIns);
            this.Controls.Add(this.buttonProductsAll);
            this.Controls.Add(this.labelResult);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Combined";
            this.Text = "Combined CRUD";
            this.Load += new System.EventHandler(this.Combined_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Label labelResult;
        private System.Windows.Forms.Button buttonProductsAll;
        private System.Windows.Forms.Label labelProdIns;
        private System.Windows.Forms.Label labelProdName;
        private System.Windows.Forms.Label labelProdPrice;
        private System.Windows.Forms.TextBox tbProdName;
        private System.Windows.Forms.TextBox tbProdPrice;
        private System.Windows.Forms.Button btnProdIns;
        private System.Windows.Forms.Label labelInsResult;
        private System.Windows.Forms.Label labelReadProd;
        private System.Windows.Forms.TextBox tbProdNameS;
        private System.Windows.Forms.Label labelProdNameS;
        private System.Windows.Forms.TextBox tbProdPriceS;
        private System.Windows.Forms.Label labelProdPriceS;
        private System.Windows.Forms.Label labelSearchId;
        private System.Windows.Forms.TextBox tbSearchId;
        private System.Windows.Forms.Label labelProdId;
        private System.Windows.Forms.TextBox tbProdIdS;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.Label labelSearchResult;
        private System.Windows.Forms.Button btnSearchParam;
        private System.Windows.Forms.Button btnSearchStoredProcedure;
        private System.Windows.Forms.Button btnInsertStoredProcedure;
    }
}

