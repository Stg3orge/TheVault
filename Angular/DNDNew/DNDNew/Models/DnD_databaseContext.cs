using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace DNDNew.Models
{
    public partial class DnD_databaseContext : DbContext
    {
        public DnD_databaseContext()
        {
        }

        public DnD_databaseContext(DbContextOptions<DnD_databaseContext> options)
            : base(options)
        {
        }

        public DbSet<AbilityPrerequisite> AbilityPrerequisite { get; set; }
        public DbSet<AbilityScore> AbilityScore { get; set; }
        public DbSet<AbilityScoreName> AbilityScoreName { get; set; }
        public DbSet<Armor> Armor { get; set; }
        public DbSet<ArmorClass> ArmorClass { get; set; }
        public DbSet<Battle> Battle { get; set; }
        public DbSet<BonusAttackPrerequisite> BonusAttackPrerequisite { get; set; }
        public DbSet<Character> Character { get; set; }
        public DbSet<CharacterBattle> CharacterBattle { get; set; }
        public DbSet<CharacterClass> CharacterClass { get; set; }
        public DbSet<CharacterFeat> CharacterFeat { get; set; }
        public DbSet<CharacterLanguage> CharacterLanguage { get; set; }
        public DbSet<Class> Class { get; set; }
        public DbSet<ClassFeat> ClassFeat { get; set; }
        public DbSet<ClassSpell> ClassSpell { get; set; }
        public DbSet<Currency> Currency { get; set; }
        public DbSet<CurrencyName> CurrencyName { get; set; }
        public DbSet<Feat> Feat { get; set; }
        public DbSet<FeatAbilityPrerequisite> FeatAbilityPrerequisite { get; set; }
        public DbSet<FeatBonusAttackPrerequisite> FeatBonusAttackPrerequisite { get; set; }
        public DbSet<FeatLevelPrerequisite> FeatLevelPrerequisite { get; set; }
        public DbSet<FeatPrerequisite> FeatPrerequisite { get; set; }
        public DbSet<Game> Game { get; set; }
        public DbSet<Hitpoints> Hitpoints { get; set; }
        public DbSet<Inventory> Inventory { get; set; }
        public DbSet<Item> Item { get; set; }
        public DbSet<Language> Language { get; set; }
        public DbSet<Level> Level { get; set; }
        public DbSet<LevelPrerequisite> LevelPrerequisite { get; set; }
        public DbSet<Notification> Notification { get; set; }
        public DbSet<Player> Player { get; set; }
        public DbSet<PlayerGame> PlayerGame { get; set; }
        public DbSet<Potion> Potion { get; set; }
        public DbSet<SavingThrow> SavingThrow { get; set; }
        public DbSet<SavingThrowName> SavingThrowName { get; set; }
        public DbSet<School> School { get; set; }
        public DbSet<Scroll> Scroll { get; set; }
        public DbSet<Shield> Shield { get; set; }
        public DbSet<Skill> Skill { get; set; }
        public DbSet<SkillName> SkillName { get; set; }
        public DbSet<Spell> Spell { get; set; }
        public DbSet<Weapon> Weapon { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=(local)\\SQLEXPRESS;Database=DnD_database;Trusted_Connection=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("ProductVersion", "2.2.4-servicing-10062");

            modelBuilder.Entity<AbilityPrerequisite>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Ability).HasColumnName("ability");

                entity.Property(e => e.AbilityNameId).HasColumnName("abilityName_id");

                entity.HasOne(d => d.AbilityName)
                    .WithMany(p => p.AbilityPrerequisite)
                    .HasForeignKey(d => d.AbilityNameId)
                    .HasConstraintName("FKAbilityPrerequisite_AbilityScoreName");
            });

            modelBuilder.Entity<AbilityScore>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.AbilityNameId).HasColumnName("abilityName_id");

                entity.Property(e => e.Base).HasColumnName("base");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.EnchantmentBonus).HasColumnName("enchantmentBonus");

                entity.Property(e => e.MiscBonus).HasColumnName("miscBonus");

                entity.Property(e => e.MiscPenalty).HasColumnName("miscPenalty");

                entity.HasOne(d => d.AbilityName)
                    .WithMany(p => p.AbilityScore)
                    .HasForeignKey(d => d.AbilityNameId)
                    .HasConstraintName("FKAbilityScore_AbilityScoreName");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.AbilityScore)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKAbilityScore_Character");
            });

            modelBuilder.Entity<AbilityScoreName>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__AbilityS__72E12F1B07831394")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Armor>(entity =>
            {
                entity.HasKey(e => e.ItemId)
                    .HasName("PKArmor_item_id");

                entity.Property(e => e.ItemId)
                    .HasColumnName("item_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.MaxDex).HasColumnName("maxDex");

                entity.Property(e => e.Weight)
                    .HasColumnName("weight")
                    .HasColumnType("decimal(4, 2)");

                entity.HasOne(d => d.Item)
                    .WithOne(p => p.Armor)
                    .HasForeignKey<Armor>(d => d.ItemId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKArmor_Item");
            });

            modelBuilder.Entity<ArmorClass>(entity =>
            {
                entity.HasKey(e => e.CharacterId)
                    .HasName("PKArmorClass_character_id");

                entity.Property(e => e.CharacterId)
                    .HasColumnName("character_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.DeflectionMod).HasColumnName("deflectionMod");

                entity.Property(e => e.MiscMod).HasColumnName("miscMod");

                entity.Property(e => e.NaturalArmor).HasColumnName("naturalArmor");

                entity.HasOne(d => d.Character)
                    .WithOne(p => p.ArmorClass)
                    .HasForeignKey<ArmorClass>(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKArmorClass_Character");
            });

            modelBuilder.Entity<Battle>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Activebattle).HasColumnName("activebattle");

                entity.Property(e => e.GameId).HasColumnName("game_id");

                entity.HasOne(d => d.Game)
                    .WithMany(p => p.Battle)
                    .HasForeignKey(d => d.GameId)
                    .HasConstraintName("FKBattle_Game");
            });

            modelBuilder.Entity<BonusAttackPrerequisite>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Attack).HasColumnName("attack");
            });

            modelBuilder.Entity<Character>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Age).HasColumnName("age");

                entity.Property(e => e.Alignment)
                    .IsRequired()
                    .HasColumnName("alignment")
                    .HasMaxLength(50);

                entity.Property(e => e.CharacterName)
                    .IsRequired()
                    .HasColumnName("characterName")
                    .HasMaxLength(50);

                entity.Property(e => e.GameId).HasColumnName("game_id");

                entity.Property(e => e.Gender)
                    .HasColumnName("gender")
                    .HasMaxLength(10);

                entity.Property(e => e.Height)
                    .HasColumnName("height")
                    .HasColumnType("decimal(4, 2)");

                entity.Property(e => e.InitiativeMod).HasColumnName("initiativeMod");

                entity.Property(e => e.Looks)
                    .HasColumnName("looks")
                    .HasMaxLength(50);

                entity.Property(e => e.MiscGrappleMod).HasColumnName("miscGrappleMod");

                entity.Property(e => e.PlayerId).HasColumnName("player_id");

                entity.Property(e => e.Race)
                    .IsRequired()
                    .HasColumnName("race")
                    .HasMaxLength(50);

                entity.Property(e => e.Religion)
                    .HasColumnName("religion")
                    .HasMaxLength(50);

                entity.Property(e => e.Size)
                    .IsRequired()
                    .HasColumnName("size")
                    .HasMaxLength(1);

                entity.Property(e => e.Speed).HasColumnName("speed");

                entity.Property(e => e.Weight)
                    .HasColumnName("weight")
                    .HasColumnType("decimal(6, 2)");

                entity.HasOne(d => d.Game)
                    .WithMany(p => p.Character)
                    .HasForeignKey(d => d.GameId)
                    .HasConstraintName("FKCharacter_Game");

                entity.HasOne(d => d.Player)
                    .WithMany(p => p.Character)
                    .HasForeignKey(d => d.PlayerId)
                    .HasConstraintName("FKCharacter_Player");
            });

            modelBuilder.Entity<CharacterBattle>(entity =>
            {
                entity.HasKey(e => new { e.BattleId, e.CharacterId })
                    .HasName("CPKCharacterBattle_battle_id_haracter_id");

                entity.Property(e => e.BattleId).HasColumnName("battle_id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.Active)
                    .IsRequired()
                    .HasColumnName("active")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.Initiative).HasColumnName("initiative");

                entity.HasOne(d => d.Battle)
                    .WithMany(p => p.CharacterBattle)
                    .HasForeignKey(d => d.BattleId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterBattle_Battle");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.CharacterBattle)
                    .HasForeignKey(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterBattle_Character");
            });

            modelBuilder.Entity<CharacterClass>(entity =>
            {
                entity.HasKey(e => new { e.CharacterId, e.ClassId })
                    .HasName("CPKCharacterClass_character_id_class_id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.ClassId).HasColumnName("class_id");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.CharacterClass)
                    .HasForeignKey(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterClass_Character");

                entity.HasOne(d => d.Class)
                    .WithMany(p => p.CharacterClass)
                    .HasForeignKey(d => d.ClassId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterClass_Class");
            });

            modelBuilder.Entity<CharacterFeat>(entity =>
            {
                entity.HasKey(e => new { e.CharacterId, e.FeatId })
                    .HasName("CPKCharacterFeat_character_id_feat_id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.FeatId).HasColumnName("feat_id");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.CharacterFeat)
                    .HasForeignKey(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterFeat_Character");

                entity.HasOne(d => d.Feat)
                    .WithMany(p => p.CharacterFeat)
                    .HasForeignKey(d => d.FeatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterFeat_Feat");
            });

            modelBuilder.Entity<CharacterLanguage>(entity =>
            {
                entity.HasKey(e => new { e.CharacterId, e.LanguageId })
                    .HasName("CPKCharacterLanguage_character_id_language_id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.LanguageId).HasColumnName("language_id");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.CharacterLanguage)
                    .HasForeignKey(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterLanguage_Character");

                entity.HasOne(d => d.Language)
                    .WithMany(p => p.CharacterLanguage)
                    .HasForeignKey(d => d.LanguageId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKCharacterLanguage_Language");
            });

            modelBuilder.Entity<Class>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__Class__72E12F1BFBF49348")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.Spellcaster).HasColumnName("spellcaster");
            });

            modelBuilder.Entity<ClassFeat>(entity =>
            {
                entity.HasKey(e => new { e.ClassId, e.FeatId })
                    .HasName("CPKClassFeat_class_id_feat_id");

                entity.Property(e => e.ClassId).HasColumnName("class_id");

                entity.Property(e => e.FeatId).HasColumnName("feat_id");

                entity.HasOne(d => d.Class)
                    .WithMany(p => p.ClassFeat)
                    .HasForeignKey(d => d.ClassId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKClassFeat_Class");

                entity.HasOne(d => d.Feat)
                    .WithMany(p => p.ClassFeat)
                    .HasForeignKey(d => d.FeatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKClassFeat_Feat");
            });

            modelBuilder.Entity<ClassSpell>(entity =>
            {
                entity.HasKey(e => new { e.ClassId, e.SpellId })
                    .HasName("CPKClassSpell_class_id_spell_id");

                entity.Property(e => e.ClassId).HasColumnName("class_id");

                entity.Property(e => e.SpellId).HasColumnName("spell_id");

                entity.Property(e => e.SpellLevel).HasColumnName("spellLevel");

                entity.HasOne(d => d.Class)
                    .WithMany(p => p.ClassSpell)
                    .HasForeignKey(d => d.ClassId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKClassSpell_Class");

                entity.HasOne(d => d.Spell)
                    .WithMany(p => p.ClassSpell)
                    .HasForeignKey(d => d.SpellId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKClassSpell_Spell");
            });

            modelBuilder.Entity<Currency>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Amount).HasColumnName("amount");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.CurrencyNameId).HasColumnName("currencyName_id");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.Currency)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKCurrency_Character");

                entity.HasOne(d => d.CurrencyName)
                    .WithMany(p => p.Currency)
                    .HasForeignKey(d => d.CurrencyNameId)
                    .HasConstraintName("FKCurrency_CurrencyName");
            });

            modelBuilder.Entity<CurrencyName>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__Currency__72E12F1B95824821")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(10);
            });

            modelBuilder.Entity<Feat>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__Feat__72E12F1B24923A8C")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.ClassId).HasColumnName("class_id");

                entity.Property(e => e.Effect)
                    .IsRequired()
                    .HasColumnName("effect")
                    .HasMaxLength(100);

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.HasOne(d => d.Class)
                    .WithMany(p => p.Feat)
                    .HasForeignKey(d => d.ClassId)
                    .HasConstraintName("FKFeat_Class");
            });

            modelBuilder.Entity<FeatAbilityPrerequisite>(entity =>
            {
                entity.HasKey(e => new { e.FeatId, e.ApId })
                    .HasName("CPKFeatAbilityPrerequisite_feat_id_ap_id");

                entity.Property(e => e.FeatId).HasColumnName("feat_id");

                entity.Property(e => e.ApId).HasColumnName("ap_id");

                entity.HasOne(d => d.Ap)
                    .WithMany(p => p.FeatAbilityPrerequisite)
                    .HasForeignKey(d => d.ApId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatAbilityPrerequisite_AP");

                entity.HasOne(d => d.Feat)
                    .WithMany(p => p.FeatAbilityPrerequisite)
                    .HasForeignKey(d => d.FeatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatAbilityPrerequisite_Feat");
            });

            modelBuilder.Entity<FeatBonusAttackPrerequisite>(entity =>
            {
                entity.HasKey(e => new { e.FeatId, e.BapId })
                    .HasName("CPKFeatBonusAttackPrerequisite_feat_id_bap_id");

                entity.Property(e => e.FeatId).HasColumnName("feat_id");

                entity.Property(e => e.BapId).HasColumnName("bap_id");

                entity.HasOne(d => d.Bap)
                    .WithMany(p => p.FeatBonusAttackPrerequisite)
                    .HasForeignKey(d => d.BapId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatBonusAttackPrerequisite_BAP");

                entity.HasOne(d => d.Feat)
                    .WithMany(p => p.FeatBonusAttackPrerequisite)
                    .HasForeignKey(d => d.FeatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatBonusAttackPrerequisite_Feat");
            });

            modelBuilder.Entity<FeatLevelPrerequisite>(entity =>
            {
                entity.HasKey(e => new { e.FeatId, e.LpId })
                    .HasName("CPKFeatLevelPrerequisite_feat_id_lp_id");

                entity.Property(e => e.FeatId).HasColumnName("feat_id");

                entity.Property(e => e.LpId).HasColumnName("lp_id");

                entity.HasOne(d => d.Feat)
                    .WithMany(p => p.FeatLevelPrerequisite)
                    .HasForeignKey(d => d.FeatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatLevelPrerequisite_Feat");

                entity.HasOne(d => d.Lp)
                    .WithMany(p => p.FeatLevelPrerequisite)
                    .HasForeignKey(d => d.LpId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatLevelPrerequisite_LP");
            });

            modelBuilder.Entity<FeatPrerequisite>(entity =>
            {
                entity.HasKey(e => new { e.FeatCurrId, e.FeatReqId })
                    .HasName("CPKFeatPrerequisite_featCurr_id_featReq_id");

                entity.Property(e => e.FeatCurrId).HasColumnName("featCurr_id");

                entity.Property(e => e.FeatReqId).HasColumnName("featReq_id");

                entity.HasOne(d => d.FeatCurr)
                    .WithMany(p => p.FeatPrerequisiteFeatCurr)
                    .HasForeignKey(d => d.FeatCurrId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatPrerequisite_FeatCurr");

                entity.HasOne(d => d.FeatReq)
                    .WithMany(p => p.FeatPrerequisiteFeatReq)
                    .HasForeignKey(d => d.FeatReqId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKFeatPrerequisite_FeatReq");
            });

            modelBuilder.Entity<Game>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.DungeonMasterId).HasColumnName("dungeonMaster_id");

                entity.HasOne(d => d.DungeonMaster)
                    .WithMany(p => p.Game)
                    .HasForeignKey(d => d.DungeonMasterId)
                    .HasConstraintName("FKGame_Player");
            });

            modelBuilder.Entity<Hitpoints>(entity =>
            {
                entity.HasKey(e => e.CharacterId)
                    .HasName("PKHitpoints_character_id");

                entity.Property(e => e.CharacterId)
                    .HasColumnName("character_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.Current).HasColumnName("current");

                entity.Property(e => e.Max).HasColumnName("max");

                entity.Property(e => e.Temp).HasColumnName("temp");

                entity.HasOne(d => d.Character)
                    .WithOne(p => p.Hitpoints)
                    .HasForeignKey<Hitpoints>(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKHitpoints_Character");
            });

            modelBuilder.Entity<Inventory>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.OnPerson).HasColumnName("onPerson");

                entity.Property(e => e.WeightLimit)
                    .HasColumnName("weightLimit")
                    .HasColumnType("decimal(6, 2)");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.Inventory)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKInventory_Character");
            });

            modelBuilder.Entity<Item>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Equipped).HasColumnName("equipped");

                entity.Property(e => e.InventoryId).HasColumnName("inventory_id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.Weight)
                    .HasColumnName("weight")
                    .HasColumnType("decimal(5, 2)");

                entity.HasOne(d => d.Inventory)
                    .WithMany(p => p.Item)
                    .HasForeignKey(d => d.InventoryId)
                    .HasConstraintName("FKItem_Inventory");
            });

            modelBuilder.Entity<Language>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__Language__72E12F1B022F6A55")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Level>(entity =>
            {
                entity.HasKey(e => e.CharacterId)
                    .HasName("PKLevel_character_id");

                entity.Property(e => e.CharacterId)
                    .HasColumnName("character_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.Experience).HasColumnName("experience");

                entity.Property(e => e.Level1).HasColumnName("level");

                entity.HasOne(d => d.Character)
                    .WithOne(p => p.Level)
                    .HasForeignKey<Level>(d => d.CharacterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKLevel_Character");
            });

            modelBuilder.Entity<LevelPrerequisite>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Level).HasColumnName("level");
            });

            modelBuilder.Entity<Notification>(entity =>
            {
                entity.HasKey(e => e.BattleId)
                    .HasName("PKNotification_battle_id");

                entity.Property(e => e.BattleId)
                    .HasColumnName("battle_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnName("description")
                    .HasMaxLength(50);

                entity.Property(e => e.DurationLeft).HasColumnName("durationLeft");

                entity.HasOne(d => d.Battle)
                    .WithOne(p => p.Notification)
                    .HasForeignKey<Notification>(d => d.BattleId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKNotification_Battle");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.Notification)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKNotification_Character");
            });

            modelBuilder.Entity<Player>(entity =>
            {
                entity.HasIndex(e => e.Username)
                    .HasName("UQ__Player__F3DBC572654175F2")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasColumnName("password")
                    .HasMaxLength(50);

                entity.Property(e => e.Username)
                    .IsRequired()
                    .HasColumnName("username")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<PlayerGame>(entity =>
            {
                entity.HasKey(e => new { e.PlayerId, e.GameId })
                    .HasName("CPKPlayerGame_player_id_game_id");

                entity.Property(e => e.PlayerId).HasColumnName("player_id");

                entity.Property(e => e.GameId).HasColumnName("game_id");

                entity.HasOne(d => d.Game)
                    .WithMany(p => p.PlayerGame)
                    .HasForeignKey(d => d.GameId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKPlayerGame_Game");

                entity.HasOne(d => d.Player)
                    .WithMany(p => p.PlayerGame)
                    .HasForeignKey(d => d.PlayerId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKPlayerGame_Player");
            });

            modelBuilder.Entity<Potion>(entity =>
            {
                entity.HasKey(e => e.ItemId)
                    .HasName("PKPotion_item_id");

                entity.Property(e => e.ItemId)
                    .HasColumnName("item_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.Effect)
                    .IsRequired()
                    .HasColumnName("effect")
                    .HasMaxLength(250);

                entity.HasOne(d => d.Item)
                    .WithOne(p => p.Potion)
                    .HasForeignKey<Potion>(d => d.ItemId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKPotion_Item");
            });

            modelBuilder.Entity<SavingThrow>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.ConditionalMod).HasColumnName("conditionalMod");

                entity.Property(e => e.MagicMod).HasColumnName("magicMod");

                entity.Property(e => e.MiscMod).HasColumnName("miscMod");

                entity.Property(e => e.SavingThrowNameId).HasColumnName("savingThrowName_id");

                entity.Property(e => e.TempMod).HasColumnName("tempMod");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.SavingThrow)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKSavingThrow_Character");

                entity.HasOne(d => d.SavingThrowName)
                    .WithMany(p => p.SavingThrow)
                    .HasForeignKey(d => d.SavingThrowNameId)
                    .HasConstraintName("FKSavingThrow_SavingThrowName");
            });

            modelBuilder.Entity<SavingThrowName>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__SavingTh__72E12F1B22A68ED9")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(20);
            });

            modelBuilder.Entity<School>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__School__72E12F1B008B334E")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Scroll>(entity =>
            {
                entity.HasKey(e => e.ItemId)
                    .HasName("PKScroll_item_id");

                entity.Property(e => e.ItemId)
                    .HasColumnName("item_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.ClassType)
                    .IsRequired()
                    .HasColumnName("classType")
                    .HasMaxLength(50);

                entity.Property(e => e.NumberOfSpells).HasColumnName("numberOfSpells");

                entity.Property(e => e.Size)
                    .IsRequired()
                    .HasColumnName("size")
                    .HasMaxLength(10);

                entity.HasOne(d => d.Item)
                    .WithOne(p => p.Scroll)
                    .HasForeignKey<Scroll>(d => d.ItemId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKScroll_Item");
            });

            modelBuilder.Entity<Shield>(entity =>
            {
                entity.HasKey(e => e.ItemId)
                    .HasName("PKShield_item_id");

                entity.Property(e => e.ItemId)
                    .HasColumnName("item_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.AttackBonus).HasColumnName("attackBonus");

                entity.Property(e => e.Critical)
                    .IsRequired()
                    .HasColumnName("critical")
                    .HasMaxLength(10);

                entity.Property(e => e.Damage)
                    .IsRequired()
                    .HasColumnName("damage")
                    .HasMaxLength(5);

                entity.Property(e => e.DamageType)
                    .IsRequired()
                    .HasColumnName("damageType")
                    .HasMaxLength(50);

                entity.Property(e => e.HandType)
                    .IsRequired()
                    .HasColumnName("handType")
                    .HasMaxLength(50);

                entity.Property(e => e.ProficiencyType)
                    .IsRequired()
                    .HasColumnName("proficiencyType")
                    .HasMaxLength(50);

                entity.HasOne(d => d.Item)
                    .WithOne(p => p.Shield)
                    .HasForeignKey<Shield>(d => d.ItemId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKShield_Armor");
            });

            modelBuilder.Entity<Skill>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.AsNameId).HasColumnName("asName_id");

                entity.Property(e => e.CharacterId).HasColumnName("character_id");

                entity.Property(e => e.MiscMod).HasColumnName("miscMod");

                entity.Property(e => e.SkillNameId).HasColumnName("skillName_id");

                entity.Property(e => e.SkillpointAmount).HasColumnName("skillpointAmount");

                entity.HasOne(d => d.AsName)
                    .WithMany(p => p.Skill)
                    .HasForeignKey(d => d.AsNameId)
                    .HasConstraintName("FKSkill_AbilityScoreName");

                entity.HasOne(d => d.Character)
                    .WithMany(p => p.Skill)
                    .HasForeignKey(d => d.CharacterId)
                    .HasConstraintName("FKSkill_Character");

                entity.HasOne(d => d.SkillName)
                    .WithMany(p => p.Skill)
                    .HasForeignKey(d => d.SkillNameId)
                    .HasConstraintName("FKSkill_SkillName");
            });

            modelBuilder.Entity<SkillName>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__SkillNam__72E12F1BBE573044")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Spell>(entity =>
            {
                entity.HasIndex(e => e.Name)
                    .HasName("UQ__Spell__72E12F1BB9B6D252")
                    .IsUnique();

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.AreaOrTarget)
                    .IsRequired()
                    .HasColumnName("areaOrTarget")
                    .HasMaxLength(100);

                entity.Property(e => e.CastingTime)
                    .IsRequired()
                    .HasColumnName("castingTime")
                    .HasMaxLength(50);

                entity.Property(e => e.Components)
                    .HasColumnName("components")
                    .HasMaxLength(50);

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnName("description")
                    .HasMaxLength(500);

                entity.Property(e => e.Duration)
                    .IsRequired()
                    .HasColumnName("duration")
                    .HasMaxLength(50);

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.Property(e => e.Range)
                    .IsRequired()
                    .HasColumnName("range")
                    .HasMaxLength(50);

                entity.Property(e => e.SavingThrow)
                    .IsRequired()
                    .HasColumnName("savingThrow")
                    .HasMaxLength(20);

                entity.Property(e => e.SchoolId).HasColumnName("school_id");

                entity.Property(e => e.SpellResistance)
                    .IsRequired()
                    .HasColumnName("spellResistance")
                    .HasMaxLength(20);

                entity.HasOne(d => d.School)
                    .WithMany(p => p.Spell)
                    .HasForeignKey(d => d.SchoolId)
                    .HasConstraintName("PKSpell_School");
            });

            modelBuilder.Entity<Weapon>(entity =>
            {
                entity.HasKey(e => e.ItemId)
                    .HasName("PKWeapon_item_id");

                entity.Property(e => e.ItemId)
                    .HasColumnName("item_id")
                    .ValueGeneratedNever();

                entity.Property(e => e.AttackBonus).HasColumnName("attackBonus");

                entity.Property(e => e.Critical)
                    .IsRequired()
                    .HasColumnName("critical")
                    .HasMaxLength(10);

                entity.Property(e => e.Damage)
                    .IsRequired()
                    .HasColumnName("damage")
                    .HasMaxLength(5);

                entity.Property(e => e.DamageType)
                    .IsRequired()
                    .HasColumnName("damageType")
                    .HasMaxLength(50);

                entity.Property(e => e.HandType)
                    .IsRequired()
                    .HasColumnName("handType")
                    .HasMaxLength(50);

                entity.Property(e => e.NotesAmmunition)
                    .HasColumnName("notesAmmunition")
                    .HasMaxLength(50);

                entity.Property(e => e.ProficiencyType)
                    .IsRequired()
                    .HasColumnName("proficiencyType")
                    .HasMaxLength(50);

                entity.Property(e => e.RangeIncrement).HasColumnName("rangeIncrement");

                entity.HasOne(d => d.Item)
                    .WithOne(p => p.Weapon)
                    .HasForeignKey<Weapon>(d => d.ItemId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKWeapon_Item");
            });
        }
    }
}
