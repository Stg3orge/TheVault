using System;
using System.Diagnostics;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Data;
using CompanyData.Model;

namespace Retrieve3 {
    public partial class Form3 : Form {

        string connectionString;
        SqlConnection con;

        public Form3() {
            InitializeComponent();

            this.Text = "ADO.NET simple - Retrieve 3";

            // Initial Catalog and Database are synonyms
            connectionString = "data Source=.; Database=AdoDemos; integrated security=SSPI";

            this.Load += new System.EventHandler(Form3_Load);
        }

        private void Form3_Load(object sender, System.EventArgs e) {
            // Setup connection to local database - Windows authentication
            con = new SqlConnection(connectionString);
            Debug.WriteLine(con.State);
            // Prepare command
            string queryString = "select * from tblProduct Order by name";
            SqlCommand readCommand = new SqlCommand(queryString, con);
            // Open connection late
            con.Open();
            // Execute read
            SqlDataReader productReader = readCommand.ExecuteReader();
            // Use read data - Create a data table to hold the retrieved data.
            DataTable dataTable = new DataTable();
            // Load the data from SqlDataReader into the data table.
            dataTable.Load(productReader);
            this.dataGridView1.DataSource = dataTable;
            int numberOfProducts = dataTable.Rows.Count;
            if (numberOfProducts > 0) {
                this.labelResult.Text = numberOfProducts + " produkter fundet";
            } else {
                this.labelResult.Text = "Ingen produkter fundet";
            }

            // Close the SqlDataReader.
            productReader.Close();

        }

    }
}
