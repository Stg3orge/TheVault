/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Text.RegularExpressions;


namespace NEWexam2016.Core
{
    public class ReadFile
    {
        public List<Product> Products;

        public ReadFile()
        {
            Products = ReadProducts();
        }

        public List<Product> ReadProducts()
        {
            StreamReader Reader = new StreamReader(File.OpenRead("../../../products.csv"));

            Reader.ReadLine();

            List<Product> AllProductsFromFile = new List<Product>();

            while (!Reader.EndOfStream)
            {
                AllProductsFromFile.Add(TransferData(Reader));
            }

            return AllProductsFromFile;
        }

        private static string RemoveHTML(string name)
        {
            return Regex.Replace(name, "<.*?>", string.Empty);
        }

        private Product TransferData(StreamReader Reader)
        {
            int ID;

            string Name;

            decimal Price;

            bool Active;

            DateTime DeactivateDate;

            string line = Reader.ReadLine();

            string[] values = line.Split(';');

            Int32.TryParse(values[0], out ID);

            Name = values[1];

            Decimal.TryParse(values[2], out Price);

            Price = Price / 100; // .csv has prices in the hundreds

            if (values[3] == "0")
            {
                Active = false;
            }
            else
            {
                Active = true;
            }

            if (values[4] != null && values[4].Length > 0)
            {
                DateTime.TryParse(values[4], out DeactivateDate);

                return new SeasonalProduct(ID, RemoveHTML(Name), Price, false, DateTime.Now, DeactivateDate);
            }

            return new Product(ID, RemoveHTML(Name), Price, Active, false);
        }
    }
}

