using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using OrderManagement.Domain.Orders;

namespace OrderManagement.Infrastructure
{
    internal class OrderEntityTypeConfiguration : IEntityTypeConfiguration<Order>
    {
        public void Configure(EntityTypeBuilder<Order> builder)
        {
            //Defining Primary Key, must be String or an object EntityId

            builder.HasKey(u => u.Id);

            //builder.OwnsOne(u => u.Email, e =>
            //{
            //    e.HasIndex(e => e.Email).IsUnique();
            //});

            builder.OwnsOne(u => u.userId, n =>
            {
                n.Property(e => e.userId).HasColumnName("UserId");
            });

            
            builder.OwnsOne(u => u.price, n =>
            {
                n.Property(e => e.Price).HasColumnName("OrderPrice");
            });

            builder.HasMany(u => u.orderDeliveries).WithOne();

            //builder.OwnsOne(u => u.Type,
            //    n =>
            //    {
            //        n.Property(e => e.Type).HasColumnName("Type");
            //    });

            //builder.OwnsOne(u => u.Date, d => {
            //    d.Property(e => e.EntryDateOfService).HasColumnName("EntryDateOfService");
            //});
            //builder.OwnsMany(e => e.items, n =>
            //{
            //    n.ToTable("PassingTimes");
            //    n.Property(e => e.Time).HasColumnName("Time");

            //});


        }
    }
}
