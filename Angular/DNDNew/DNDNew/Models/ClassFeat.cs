using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class ClassFeat
    {
        public int ClassId { get; set; }
        public int FeatId { get; set; }

        public virtual Class Class { get; set; }
        public virtual Feat Feat { get; set; }
    }
}
