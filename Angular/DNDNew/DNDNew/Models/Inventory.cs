using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Inventory
    {
        public Inventory()
        {
            Item = new HashSet<Item>();
        }

        public int Id { get; set; }
        public int? CharacterId { get; set; }
        public string Name { get; set; }
        public decimal? WeightLimit { get; set; }
        public bool OnPerson { get; set; }

        public virtual Character Character { get; set; }
        public virtual ICollection<Item> Item { get; set; }
    }
}
