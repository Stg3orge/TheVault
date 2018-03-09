/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;
using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;

namespace Eksamensopgave2016
{
    public class ReadFile
    {
        public List<Product> Products;
        public ReadFile()
        {
            Products = InitializeProducts();
        }

        // Initializing products from file into a list of all products both active and non active
        public List<Product> InitializeProducts()
        {
            StreamReader filePointer = new StreamReader(File.OpenRead("../../../products.csv"));
            filePointer.ReadLine(); // Skip the first line
            List<Product> AllProducts = new List<Product>();

            while (!filePointer.EndOfStream)
            {
                AllProducts.Add(TransferData(filePointer));
            }

            return AllProducts; // Can sort through this later
        }


        // Removes silly HTML
        private static string removeHTML(string name)
        {
            return Regex.Replace(name, "<.*?>", string.Empty);
        }

        // Transfers data from the product list to variables
        private Product TransferData(StreamReader filePointer)
        {
            int productid;
            decimal pricetag;
            string productname;
            bool active;
            DateTime deactivatedate;

            string line = filePointer.ReadLine();
            string[] values = line.Split(';');
            Int32.TryParse(values[0], out productid);
            productname = values[1];
            Decimal.TryParse(values[2], out pricetag);
            pricetag = pricetag / 100; // Formatting to make sure to get right price

            if (values[3] == "0")
            {
                active = false;
            }
            else
            {
                active = true;
            }

            if (values[4] != null) // Where is the activate date
            {
                DateTime.TryParse(values[4], out deactivatedate);
                return new SeasonalProduct(productid, removeHTML(productname), pricetag, active, deactivatedate);
            }

            return new Product(productid, productname, pricetag, active);
        }
    }
}
