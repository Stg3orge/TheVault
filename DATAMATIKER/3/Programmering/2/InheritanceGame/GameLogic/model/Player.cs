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
        private bool isAlive = false;
        private Inventory inventory;

        public Player(int hitpoints)
        {
            this.hitpoints = hitpoints;
            this.isAlive = true;
            inventory = new Inventory();
        }

        public Inventory PlayerInventory
        {
            get { return inventory; }
            private set { inventory = value; }
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
            if (Hitpoints == 0)
            {
                IsAlive = false;
            }
            else
            {
                Console.WriteLine("I cannot die just yet!");
            }
        }

        public void Heal(int amount)
        {
            throw new NotImplementedException();
        }

        public void Respawn()
        {
            Hitpoints = 20;
            IsAlive = true;
            Console.WriteLine("I live again!");
        }

        public void TakeDamage(int amount)
        {
            Hitpoints -= amount;
        }
    }
}
