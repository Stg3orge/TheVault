using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model.Interfaces
{
    interface IHealable : IDamageable
    {
        void Heal(int amount);
    }
}
