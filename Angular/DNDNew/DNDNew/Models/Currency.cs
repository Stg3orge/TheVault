using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Currency
    {
        public int Id { get; set; }
        public int? CharacterId { get; set; }
        public int? CurrencyNameId { get; set; }
        public int Amount { get; set; }

        public virtual Character Character { get; set; }
        public virtual CurrencyName CurrencyName { get; set; }
    }
}
