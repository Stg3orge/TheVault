using System;
using System.Data.SqlClient;
using System.Windows.Forms;
using DataLayer;

namespace DbConnectionBetter {
    public partial class JustConnect : Form {

        SqlConnection con;

        public JustConnect() {
            InitializeComponent();
        }

        private void JustConnect_Load(object sender, EventArgs e) {
            string connString = DB.DbConnectionString;

            // Should be inside a try-catch block
            con = new SqlConnection(connString);
            con.Open();
            this.textBox1.Text = "Connection state 1: " + con.State + Environment.NewLine;
            con.Close();
            this.textBox1.Text += "Connection state 2: " + con.State;
        }
    }
}
