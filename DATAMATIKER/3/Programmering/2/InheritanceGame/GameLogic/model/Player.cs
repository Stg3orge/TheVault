using GameLogic.model.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public class Player : IPlayer
    {
        private int hitpoints = 0;
        private bool isAlive;
        private Inventory inventory;

        public Inventory PlayerInventory
        {
            get { return inventory; }
            private set { inventory = value; }
        }
        public Player(int hitpoints)
        {
            this.hitpoints = hitpoints;
            this.isAlive = true;
            inventory = new Inventory();
        }

        public int Hitpoints
        {
            get { return hitpoints; }
            set { hitpoints = value; }
        }

        public bool IsAlive
        {
            get { return isAlive; }
            set { isAlive = value; }

        }

        
            
        public void Die()
        {
            throw new NotImplementedException();
        }

        public void Heal(int amount)
        {
            throw new NotImplementedException();
        }

        public void Respawn()
        {
            throw new NotImplementedException();
        }

        public void TakeDamage(int amount)
        {
            throw new NotImplementedException();
        }
    }
}
