using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Character
    {
        public Character()
        {
            AbilityScore = new HashSet<AbilityScore>();
            CharacterBattle = new HashSet<CharacterBattle>();
            CharacterClass = new HashSet<CharacterClass>();
            CharacterFeat = new HashSet<CharacterFeat>();
            CharacterLanguage = new HashSet<CharacterLanguage>();
            Currency = new HashSet<Currency>();
            Inventory = new HashSet<Inventory>();
            Notification = new HashSet<Notification>();
            SavingThrow = new HashSet<SavingThrow>();
            Skill = new HashSet<Skill>();
        }

        public int Id { get; set; }
        public string CharacterName { get; set; }
        public string Alignment { get; set; }
        public string Religion { get; set; }
        public string Race { get; set; }
        public int Speed { get; set; }
        public int InitiativeMod { get; set; }
        public int MiscGrappleMod { get; set; }
        public int? Age { get; set; }
        public decimal? Height { get; set; }
        public decimal? Weight { get; set; }
        public string Size { get; set; }
        public string Gender { get; set; }
        public string Looks { get; set; }
        public int? PlayerId { get; set; }
        public int? GameId { get; set; }

        public virtual Game Game { get; set; }
        public virtual Player Player { get; set; }
        public virtual ArmorClass ArmorClass { get; set; }
        public Hitpoints Hitpoints { get; set; }
        public virtual Level Level { get; set; }
        public virtual ICollection<AbilityScore> AbilityScore { get; set; }
        public virtual ICollection<CharacterBattle> CharacterBattle { get; set; }
        public virtual ICollection<CharacterClass> CharacterClass { get; set; }
        public virtual ICollection<CharacterFeat> CharacterFeat { get; set; }
        public ICollection<CharacterLanguage> CharacterLanguage { get; set; }
        public virtual ICollection<Currency> Currency { get; set; }
        public virtual ICollection<Inventory> Inventory { get; set; }
        public virtual ICollection<Notification> Notification { get; set; }
        public virtual ICollection<SavingThrow> SavingThrow { get; set; }
        public virtual ICollection<Skill> Skill { get; set; }
    }
}
