using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Text;
using System.Threading.Tasks;
using CompanyData.Model;

namespace DataLayer {

    public class DBProduct {

        public DataTable GetAllProducts() {
            DataTable foundProdTable = new DataTable();

            // Get connection
            string connectString = DB.DbConnectionString;
            SqlConnection con = new SqlConnection(connectString);
            Debug.WriteLine(con.State);

            // Prepare command
            string queryString = "select * from tblProduct Order by name";
            SqlCommand readCommand = new SqlCommand(queryString, con);

            // Open connection late
            con.Open();

            // Execute read
            SqlDataReader productReader = readCommand.ExecuteReader();
 
            // Load the data from SqlDataReader into the data table.
            foundProdTable.Load(productReader);

            // Close the SqlDataReader.
            productReader.Close();
            con.Close();

            return foundProdTable;
        }

        public Product GetProductById(int searchId, DB.OpMode commandType) {
            Product foundProd = null;

            // Get connection
            string connectString = DB.DbConnectionString;
            SqlConnection con = new SqlConnection(connectString);

            // Prepare command
            string queryString = null;
            SqlCommand readCommand = null;
            switch (commandType) {
                case DB.OpMode.SqlInline:   
                    queryString = "select * from tblProduct WHERE id = " + searchId;
                    readCommand = new SqlCommand(queryString, con);
                    Debug.WriteLine("SQL inline: " + queryString);
                    break;    
                case DB.OpMode.StoredProcedure:
                    string storedProcName = "spSelectProductById";
                    readCommand = new SqlCommand(storedProcName, con);
                    readCommand.CommandType = CommandType.StoredProcedure;
                    readCommand.Parameters.AddWithValue("@Id", searchId);
                    Debug.WriteLine("Stored Procedure: " + storedProcName);
                    break;
                case DB.OpMode.SqlInlineParam:
                case DB.OpMode.Unknown:
                    queryString = "select * from tblProduct WHERE id = @Id";
                    readCommand = new SqlCommand(queryString, con);
                    SqlParameter idParam = new SqlParameter("@Id", searchId);
                    readCommand.Parameters.Add(idParam);
                    Debug.WriteLine("SQL inline parameterisized: " + queryString);
                    break;
                default:
                    break;
            }

            // Todo: Try-catch
            // Open connection late
            con.Open();
            // Execute read
            SqlDataReader productReader = readCommand.ExecuteReader();

            // 
            int tempId;
            string tempName;
            decimal tempPrice;
            if (productReader.HasRows) {
                while (productReader.Read()) {
                    tempId = productReader.GetInt32(0);
                    tempName = productReader.GetString(1);
                    tempPrice = productReader.GetDecimal(2);
                    foundProd = new Product(tempId, tempName, tempPrice);
                }
            }

            // Close the SqlDataReader.
            productReader.Close();
            con.Close();

            return foundProd;
        }

        public bool InsertProduct(Product insProduct, DB.OpMode useOpMode) {
            bool allOk = true;

            // Get connection
            string connectString = DB.DbConnectionString;
            SqlConnection con = new SqlConnection(connectString);

            // Prepare command
            string insertString = null;
            SqlCommand insertCommand = null;
            SqlParameter outputParameter = null;
            switch (useOpMode) {
                case DB.OpMode.Unknown:
                    break;
                case DB.OpMode.SqlInline:
                    insertString = "INSERT INTO tblProduct VALUES('" + insProduct.ProductName + "'," + insProduct.Price + ")";
                    insertCommand = new SqlCommand(insertString, con);
                    Debug.WriteLine("SQL inline: " + insertString);
                    break;
                case DB.OpMode.SqlInlineParam:
                    break;
                case DB.OpMode.StoredProcedure:
                    string storedProcName = "spAddProduct";
                    insertCommand = new SqlCommand(storedProcName, con);
                    insertCommand.CommandType = CommandType.StoredProcedure;
                    insertCommand.Parameters.AddWithValue("@Name", insProduct.ProductName);
                    insertCommand.Parameters.AddWithValue("@Price", insProduct.Price);
                    outputParameter = new SqlParameter();
                    outputParameter.ParameterName = "@ProductId";
                    outputParameter.SqlDbType = SqlDbType.Int;
                    outputParameter.Direction = ParameterDirection.Output;
                    insertCommand.Parameters.Add(outputParameter);
                    Debug.WriteLine("Stored Procedure: " + storedProcName);
                    break;
                default:
                    break;
            }

            try {
                con.Open();
                int rowsAffected = insertCommand.ExecuteNonQuery();
                if (rowsAffected <= 0) {
                    allOk = false;
                }
                if (useOpMode == DB.OpMode.StoredProcedure) {
                    Debug.WriteLine(outputParameter.Value.ToString());
                }
            } catch {
                allOk = false;
            } finally {
                con.Close();
            }

            return allOk;
        }

    }
}
