using System;
using System.Collections.Generic;

namespace CodeFirstDB.Models
{
    public partial class Seafood
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public int? MenuId { get; set; }

        public virtual Menu Menu { get; set; }
    }
}
