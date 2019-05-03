using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace CodeFirstDB.Models
{
    public partial class FoodDBContext : DbContext
    {
        public FoodDBContext()
        {
        }

        public FoodDBContext(DbContextOptions<FoodDBContext> options)
            : base(options)
        {
        }

        public DbSet<Menu> Menu { get; set; }
        public DbSet<Seafood> Seafood { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=(local)\\SQLEXPRESS;Database=FoodDB;Trusted_Connection=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Menu>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(200);
            });

            modelBuilder.Entity<Seafood>(entity =>
            {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnName("description")
                    .HasMaxLength(200);

                entity.Property(e => e.MenuId).HasColumnName("menu_id");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.HasOne(d => d.Menu)
                    .WithMany(p => p.Seafood)
                    .HasForeignKey(d => d.MenuId)
                    .HasConstraintName("FKSeafood_Menu");
            });
        }
    }
}
