using System;
using System.Collections.Generic;

namespace CodeFirstDB.Models
{
    public partial class Menu
    {
        public Menu()
        {
            Seafood = new HashSet<Seafood>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<Seafood> Seafood { get; set; }
    }
}
