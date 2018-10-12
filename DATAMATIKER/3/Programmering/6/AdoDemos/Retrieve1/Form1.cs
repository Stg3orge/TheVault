using System;
using System.Diagnostics;
using System.Windows.Forms;
using System.Data.SqlClient;
using CompanyData.Model;

namespace Retrieve1 {

    public partial class Form1 : Form {

        string connectionString;
        SqlConnection con;

        public Form1() {
            InitializeComponent();

            this.Text = "ADO.NET simple - Retrieve 1";

            // Setup connection to local database - Windows authentication
            //connectionString = "Integrated Security=SSPI;Persist Security Info=False;" +
            //                      "Initial Catalog=AdoDemos;Data Source=localhost";
            connectionString = "data Source=.; database=AdoDemos; integrated security=SSPI";

            this.Load += new System.EventHandler(Form1_Load);
            
        }


        private void Form1_Load(object sender, System.EventArgs e) {
            // Prepare command
            string queryString = "select * from tblProduct Order by name";
            // Setup connection to local database - Windows authentication
            using (con = new SqlConnection(connectionString))
            using (SqlCommand readCommand = new SqlCommand(queryString, con)) {
                SqlDataReader productReader = null;
                try {
                    Debug.WriteLine(con.State);
                    // Open connection
                    con.Open();
                    // Read and use data
                    productReader = readCommand.ExecuteReader();
                    int foundRows = PopulateProductList(productReader);
                    if (foundRows > 0) {
                        this.labelResult.Text = foundRows + " produkter fundet";
                    } else {
                        this.labelResult.Text = "Ingen produkter fundet";
                    }
                } catch(Exception ex) {
                    Debug.Write(ex.Message);
                } finally {
                    if (productReader != null) {
                        productReader.Close();
                    }
                }
            }
        }

        private int PopulateProductList(SqlDataReader prodReader) {
            int numRows = 0;
            int tempId = 0;
            string tempName = null;
            decimal tempPrice = 0;
            if (prodReader.HasRows) {
                while (prodReader.Read()) {
                    tempId = prodReader.GetInt32(0);
                    tempName = prodReader.GetString(1);
                    tempPrice = prodReader.GetDecimal(2);
                    this.listBoxProducts.Items.Add( new Product(tempId, tempName, tempPrice) );
                    numRows++;
                }
            }
            return numRows;
        }
    }
}


//private void Form1_Load(object sender, System.EventArgs e) {
//    // Setup connection to local database - Windows authentication
//    con = new SqlConnection(connectionString);
//    Debug.WriteLine(con.State);
//    // Prepare command
//    string queryString = "select * from tblProduct Order by name";
//    SqlCommand readCommand = new SqlCommand(queryString, con);
//    // Open connection late and close it early
//    con.Open();
//    // Execute read
//    SqlDataReader productReader = readCommand.ExecuteReader();
//    // Use read data
//    int foundRows = PopulateProductList(productReader);
//    if (foundRows > 0) {
//        this.labelResult.Text = foundRows + " produkter fundet";
//    } else {
//        this.labelResult.Text = "Ingen produkter fundet";
//    }
//    // 
//    productReader.Close();
//}

//private void Form2_Load(object sender, System.EventArgs e) {

//    // Setup connection to database
//    // Instantiate SqlConnection object with connectionstring
//    con = new SqlConnection(connectionString);

//    // Write SQL query
//    // Instantiate SqlCommand object with query string and SqlConnection object
//    string queryString = "select * from tblProduct Order by name";
//    SqlCommand readCommand = new SqlCommand(queryString, con);

//    // Open connection 
//    con.Open();

//    // Execure SqlCommand and assign read data to a SqlDataReader object
//    SqlDataReader productReader = readCommand.ExecuteReader();

//    // Use data for the reader
//    // E.g. convert read "rows" to domain object
//    int foundRows = PopulateProductList(productReader);

//    // Close used resources
//    productReader.Close();
//}
