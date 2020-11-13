﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using SpaceTransporter.Database;

namespace SpaceTransporter.Migrations
{
    [DbContext(typeof(ApplicationDbContext))]
    partial class ApplicationDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .UseIdentityColumns()
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("ProductVersion", "5.0.0");

            modelBuilder.Entity("SpaceTransporter.Entities.Planet", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .UseIdentityColumn();

                    b.Property<int>("DockingCapacityLimit")
                        .HasColumnType("int");

                    b.Property<string>("Name")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("PlanetsTable");
                });

            modelBuilder.Entity("SpaceTransporter.Entities.Ship", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .UseIdentityColumn();

                    b.Property<bool>("IsDocked")
                        .HasColumnType("bit");

                    b.Property<double>("MaxWarpSpeed")
                        .HasColumnType("float");

                    b.Property<int>("Name")
                        .HasColumnType("int");

                    b.Property<int>("PlanetId")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.HasIndex("PlanetId");

                    b.ToTable("ShipsTable");
                });

            modelBuilder.Entity("SpaceTransporter.Entities.Ship", b =>
                {
                    b.HasOne("SpaceTransporter.Entities.Planet", "CurrentLocation")
                        .WithMany("DockedShip")
                        .HasForeignKey("PlanetId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("CurrentLocation");
                });

            modelBuilder.Entity("SpaceTransporter.Entities.Planet", b =>
                {
                    b.Navigation("DockedShip");
                });
#pragma warning restore 612, 618
        }
    }
}