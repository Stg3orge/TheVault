using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model.Interfaces
{
    interface IPlayer : IHealable
    {
        int Hitpoints { get; set; }
        bool IsAlive { get; set; }

        void Die();
        void Respawn();
    }
}
