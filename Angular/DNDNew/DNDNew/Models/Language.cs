using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Language
    {
        public Language()
        {
            CharacterLanguage = new HashSet<CharacterLanguage>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public ICollection<CharacterLanguage> CharacterLanguage { get; set; }
    }
}
