using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class CharacterLanguage
    {
        public int CharacterId { get; set; }
        public int LanguageId { get; set; }

        public Character Character { get; set; }
        public Language Language { get; set; }
    }
}
