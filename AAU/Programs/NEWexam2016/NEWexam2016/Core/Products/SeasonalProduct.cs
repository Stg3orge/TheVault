/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NEWexam2016.Core
{
    class SeasonalProduct : Product
    {
        public SeasonalProduct(int ID, string name, decimal price, bool canBeBoughtOnCredit, DateTime startDate, DateTime endDate) : base(ID, name, price, false, canBeBoughtOnCredit)
        {
            SeasonStartDate = startDate;
            SeasonEndDate = endDate;
        }

        private DateTime _seasonStartDate;
        public DateTime SeasonStartDate
        {
            get
            {
                return _seasonStartDate;
            }

            set
            {
                _seasonStartDate = value;
            }
        }

        private DateTime _seasonEndDate;
        public DateTime SeasonEndDate
        {
            get
            {
                return _seasonEndDate;
            }

            set
            {
                if (DateTime.Now > value)
                {
                    Active = false;
                }
                else
                {
                    Active = true;
                }

                _seasonEndDate = value;
            }
        }

    }
}
