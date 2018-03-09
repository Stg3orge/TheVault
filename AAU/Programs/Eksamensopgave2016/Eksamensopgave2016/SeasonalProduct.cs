/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;

namespace Eksamensopgave2016
{
    class SeasonalProduct : Product // Unfortunately weren't able to locate an activate date, which makes implementing this parameter hard to code
    {
        public DateTime deactivatedate;
        // inherit from constructor from Product
        public SeasonalProduct(int _productId, string _productname, decimal _productpricetag, bool _active, DateTime _deactivatedate) : base(_productId, _productname, _productpricetag, _active)
        {
            this.deactivatedate = _deactivatedate;
        }
        private DateTime seasonStartDate; // start date of the season, not found in the .csv file
        private DateTime seasonEndDate; // end date of the season, not implemented

        public override string ToString()
        {
            return "ID: " + productID + " " + productName + " Price: " + productPriceTag + "kr " + Active;
        }
    }
}
