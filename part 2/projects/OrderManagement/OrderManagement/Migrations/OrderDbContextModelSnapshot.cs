﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using OrderManagement.Infrastructure;

namespace OrderManagement.Migrations
{
    [DbContext(typeof(OrderDbContext))]
    partial class OrderDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "3.1.17")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("OrderManagement.Domain.Deliveries.Delivery", b =>
                {
                    b.Property<string>("Id")
                        .HasColumnType("nvarchar(450)");

                    b.Property<string>("OrderId")
                        .HasColumnType("nvarchar(450)");

                    b.Property<int>("status")
                        .HasColumnName("DeliveryStatus")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.HasIndex("OrderId");

                    b.ToTable("Deliveries");
                });

            modelBuilder.Entity("OrderManagement.Domain.Orders.Order", b =>
                {
                    b.Property<string>("Id")
                        .HasColumnType("nvarchar(450)");

                    b.HasKey("Id");

                    b.ToTable("Orders");
                });

            modelBuilder.Entity("OrderManagement.Domain.Deliveries.Delivery", b =>
                {
                    b.HasOne("OrderManagement.Domain.Orders.Order", null)
                        .WithMany("orderDeliveries")
                        .HasForeignKey("OrderId");

                    b.OwnsOne("OrderManagement.Domain.Deliveries.ValueObjects.DeliveryDay", "day", b1 =>
                        {
                            b1.Property<string>("DeliveryId")
                                .HasColumnType("nvarchar(450)");

                            b1.Property<DateTime>("deliveryDate")
                                .HasColumnName("DeliveryDate")
                                .HasColumnType("datetime2");

                            b1.HasKey("DeliveryId");

                            b1.ToTable("Deliveries");

                            b1.WithOwner()
                                .HasForeignKey("DeliveryId");
                        });

                    b.OwnsMany("OrderManagement.Domain.Deliveries.ValueObjects.OrderSandwich", "items", b1 =>
                        {
                            b1.Property<string>("DeliveryId")
                                .HasColumnType("nvarchar(450)");

                            b1.Property<int>("Id")
                                .ValueGeneratedOnAdd()
                                .HasColumnType("int")
                                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                            b1.HasKey("DeliveryId", "Id");

                            b1.ToTable("OrderSandwiches");

                            b1.WithOwner()
                                .HasForeignKey("DeliveryId");

                            b1.OwnsOne("OrderManagement.Domain.Deliveries.ValueObjects.OrderSandwichQuantity", "quantity", b2 =>
                                {
                                    b2.Property<string>("OrderSandwichDeliveryId")
                                        .HasColumnType("nvarchar(450)");

                                    b2.Property<int>("OrderSandwichId")
                                        .ValueGeneratedOnAdd()
                                        .HasColumnType("int")
                                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                                    b2.Property<int>("Quantity")
                                        .HasColumnName("quantity")
                                        .HasColumnType("int");

                                    b2.HasKey("OrderSandwichDeliveryId", "OrderSandwichId");

                                    b2.ToTable("OrderSandwiches");

                                    b2.WithOwner()
                                        .HasForeignKey("OrderSandwichDeliveryId", "OrderSandwichId");
                                });

                            b1.OwnsOne("OrderManagement.Domain.Deliveries.ValueObjects.SandwichInternalId", "sandwichId", b2 =>
                                {
                                    b2.Property<string>("OrderSandwichDeliveryId")
                                        .HasColumnType("nvarchar(450)");

                                    b2.Property<int>("OrderSandwichId")
                                        .ValueGeneratedOnAdd()
                                        .HasColumnType("int")
                                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                                    b2.Property<string>("id")
                                        .HasColumnName("sandwichId")
                                        .HasColumnType("nvarchar(max)");

                                    b2.HasKey("OrderSandwichDeliveryId", "OrderSandwichId");

                                    b2.ToTable("OrderSandwiches");

                                    b2.WithOwner()
                                        .HasForeignKey("OrderSandwichDeliveryId", "OrderSandwichId");
                                });
                        });

                    b.OwnsOne("OrderManagement.Domain.Deliveries.ValueObjects.ShopInternalId", "shopId", b1 =>
                        {
                            b1.Property<string>("DeliveryId")
                                .HasColumnType("nvarchar(450)");

                            b1.Property<string>("id")
                                .HasColumnName("ShopId")
                                .HasColumnType("nvarchar(max)");

                            b1.HasKey("DeliveryId");

                            b1.ToTable("Deliveries");

                            b1.WithOwner()
                                .HasForeignKey("DeliveryId");
                        });
                });

            modelBuilder.Entity("OrderManagement.Domain.Orders.Order", b =>
                {
                    b.OwnsOne("OrderManagement.Domain.Orders.ValueObjects.OrderPrice", "price", b1 =>
                        {
                            b1.Property<string>("OrderId")
                                .HasColumnType("nvarchar(450)");

                            b1.Property<decimal>("Price")
                                .HasColumnName("OrderPrice")
                                .HasColumnType("decimal(18,2)");

                            b1.HasKey("OrderId");

                            b1.ToTable("Orders");

                            b1.WithOwner()
                                .HasForeignKey("OrderId");
                        });

                    b.OwnsOne("OrderManagement.Domain.Orders.ValueObjects.UserInternalId", "userId", b1 =>
                        {
                            b1.Property<string>("OrderId")
                                .HasColumnType("nvarchar(450)");

                            b1.Property<string>("id")
                                .HasColumnName("UserId")
                                .HasColumnType("nvarchar(max)");

                            b1.HasKey("OrderId");

                            b1.ToTable("Orders");

                            b1.WithOwner()
                                .HasForeignKey("OrderId");
                        });
                });
#pragma warning restore 612, 618
        }
    }
}
