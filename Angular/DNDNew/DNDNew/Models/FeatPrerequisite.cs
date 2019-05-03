using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class FeatPrerequisite
    {
        public int FeatCurrId { get; set; }
        public int FeatReqId { get; set; }

        public virtual Feat FeatCurr { get; set; }
        public virtual Feat FeatReq { get; set; }
    }
}
