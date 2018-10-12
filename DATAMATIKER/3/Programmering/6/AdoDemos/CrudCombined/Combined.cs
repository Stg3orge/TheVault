using System;
using System.Diagnostics;
using System.Data.SqlClient;
using System.Windows.Forms;
using System.Globalization;
using System.Data;
using CompanyData.Model;
using DataLayer;

namespace CrudCombined {

    public partial class Combined : Form {

        string connectionString;
        SqlConnection con;

        public Combined() {

            InitializeComponent();

            // Initial Catalog and Database are synonyms
            connectionString = "data Source=.; Database=AdoDemos; integrated security=SSPI";

            // Setup connection to local database - Windows authentication
            con = new SqlConnection(connectionString);
        }

        private void Combined_Load(object sender, EventArgs e) {
        }

        private void buttonProductsAll_Click(object sender, EventArgs e) {

            DBProduct dbProduct = new DBProduct();
            DataTable dataTable = dbProduct.GetAllProducts(); 

            this.dataGridView1.DataSource = dataTable;
            int numberOfProducts = dataTable.Rows.Count;
            if (numberOfProducts > 0) {
                this.labelResult.Text = numberOfProducts + " produkter fundet";
            } else {
                this.labelResult.Text = "Ingen produkter fundet";
            }
        }

        private void btnSearch_Click(object sender, EventArgs e) {
            // Get raw values
            string prodSearchIdRaw = this.tbSearchId.Text;
            int prodSearchId = GetProductIdFromRaw(prodSearchIdRaw);
            //
            DB.OpMode useOpMode = DB.OpMode.SqlInline;
            DBProduct dbProduct = new DBProduct();
            Product foundProduct = dbProduct.GetProductById(prodSearchId, useOpMode);
            //
            DisplayProduct(prodSearchId, foundProduct);
        }

        private void btnSearchParam_Click(object sender, EventArgs e) {
            // Get raw values
            string prodSearchIdRaw = this.tbSearchId.Text;
            int prodSearchId = GetProductIdFromRaw(prodSearchIdRaw);
            //
            DB.OpMode useOpMode = DB.OpMode.SqlInlineParam;
            DBProduct dbProduct = new DBProduct();
            Product foundProduct = dbProduct.GetProductById(prodSearchId, useOpMode);
            //
            DisplayProduct(prodSearchId, foundProduct);
        }

        private void btnSearchStoredProcedure_Click(object sender, EventArgs e) {
            // Get raw values
            string prodSearchIdRaw = this.tbSearchId.Text;
            int prodSearchId = GetProductIdFromRaw(prodSearchIdRaw);
            //
            DB.OpMode useOpMode = DB.OpMode.StoredProcedure;
            DBProduct dbProduct = new DBProduct();
            Product foundProduct = dbProduct.GetProductById(prodSearchId, useOpMode);
            //
            DisplayProduct(prodSearchId, foundProduct);
        }

        private void btnProdIns_Click(object sender, EventArgs e) {
            // Get raw values
            string prodNameRaw = this.tbProdName.Text;
            string prodPriceRaw = this.tbProdPrice.Text;

            Product newProduct = GetProductFromRaw(prodNameRaw, prodPriceRaw);

            bool wasInsertedOk = false;
            if (newProduct != null) {
                DB.OpMode useOpMode = DB.OpMode.SqlInline;
                DBProduct dbProduct = new DBProduct();
                wasInsertedOk = dbProduct.InsertProduct(newProduct, useOpMode);
            }
            //
            this.labelInsResult.Text = "Was inserted: " + wasInsertedOk;
        }

        private void btnInsertStoredProcedure_Click(object sender, EventArgs e) {
            // Get raw values
            string prodNameRaw = this.tbProdName.Text;
            string prodPriceRaw = this.tbProdPrice.Text;

            Product newProduct = GetProductFromRaw(prodNameRaw, prodPriceRaw);

            bool wasInsertedOk = false;
            if (newProduct != null) {
                DB.OpMode useOpMode = DB.OpMode.StoredProcedure;
                DBProduct dbProduct = new DBProduct();
                wasInsertedOk = dbProduct.InsertProduct(newProduct, useOpMode);
            }
            //
            this.labelInsResult.Text = "Was inserted: " + wasInsertedOk;
        }

        private int GetProductIdFromRaw(string prodId) {
            int foundId;
            Int32.TryParse(prodId, out foundId);

            return foundId;
        }

        private Product GetProductFromRaw(string prodNameRaw, string prodPriceRaw) {
            Product foundProduct = null;
            string prodName = null;
            decimal prodPrice = 0;

            // Check input
            bool allOk = true;
            if (!String.IsNullOrWhiteSpace(prodNameRaw)) {
                prodName = prodNameRaw.Trim();
            } else {
                allOk = false;
            }
            if (allOk) {
                allOk = Decimal.TryParse(prodPriceRaw, NumberStyles.Any, CultureInfo.GetCultureInfo("da-DK"), out prodPrice);
            }

            if (allOk) {
                foundProduct = new Product(prodName, prodPrice);
            }

            return foundProduct;
        }

        private void DisplayProduct(int prodSearchId, Product foundProduct) {
            if (foundProduct != null) {
                this.tbProdIdS.Text = foundProduct.Id.ToString();
                this.tbProdNameS.Text = foundProduct.ProductName;
                this.tbProdPriceS.Text = foundProduct.Price.ToString();
                this.labelSearchResult.Text = "Product " + prodSearchId + " was found";
            } else {
                this.labelSearchResult.Text = "Product " + prodSearchId + " not found";
            }
        }


    }

}
