using System;
using System.Collections.Generic;

namespace DogTestApi.Models
{
    public partial class RobotDogs
    {
        public int RobotDogId { get; set; }
        public string Name { get; set; }
        public bool Armed { get; set; }
        public int RobotFactoryId { get; set; }

        public RobotFactories RobotFactory { get; set; }
    }
}
