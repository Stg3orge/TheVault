using System;
using System.Collections.Generic;

namespace DogTestApi.Models
{
    public partial class RobotFactories
    {
        public RobotFactories()
        {
            RobotDogs = new HashSet<RobotDogs>();
        }

        public int RobotFactoryId { get; set; }
        public string Name { get; set; }
        public string Location { get; set; }

        public ICollection<RobotDogs> RobotDogs { get; set; }
    }
}
