using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class CurrencyName
    {
        public CurrencyName()
        {
            Currency = new HashSet<Currency>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<Currency> Currency { get; set; }
    }
}
