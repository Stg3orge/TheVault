using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class LevelPrerequisite
    {
        public LevelPrerequisite()
        {
            FeatLevelPrerequisite = new HashSet<FeatLevelPrerequisite>();
        }

        public int Id { get; set; }
        public int Level { get; set; }

        public virtual ICollection<FeatLevelPrerequisite> FeatLevelPrerequisite { get; set; }
    }
}
