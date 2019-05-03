using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace DogTestApi.Models
{
    public partial class DogDatabaseContext : DbContext
    {
        public DogDatabaseContext()
        {
        }

        public DogDatabaseContext(DbContextOptions<DogDatabaseContext> options)
            : base(options)
        {
        }

        public virtual DbSet<RobotDogs> RobotDogs { get; set; }
        public virtual DbSet<RobotFactories> RobotFactories { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=(local)\\SQLEXPRESS;Database=DogDatabase;Trusted_Connection=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<RobotDogs>(entity =>
            {
                entity.HasKey(e => e.RobotDogId);

                entity.Property(e => e.Name).HasMaxLength(200);

                entity.HasOne(d => d.RobotFactory)
                    .WithMany(p => p.RobotDogs)
                    .HasForeignKey(d => d.RobotFactoryId)
                    .HasConstraintName("FK_dbo.RobotDogs_dbo.RobotFactory_RobotFactoryId");
            });

            modelBuilder.Entity<RobotFactories>(entity =>
            {
                entity.HasKey(e => e.RobotFactoryId);

                entity.Property(e => e.Location).HasColumnType("ntext");

                entity.Property(e => e.Name).HasMaxLength(200);
            });
        }
    }
}
