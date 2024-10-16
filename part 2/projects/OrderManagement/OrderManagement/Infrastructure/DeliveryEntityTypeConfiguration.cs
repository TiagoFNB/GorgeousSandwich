using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using OrderManagement.Domain.Deliveries;

namespace OrderManagement.Infrastructure
{
    internal class DeliveryEntityTypeConfiguration : IEntityTypeConfiguration<Delivery>
    {
        public void Configure(EntityTypeBuilder<Delivery> builder)
        {
            //Defining Primary Key, must be String or an object EntityId

            builder.HasKey(u => u.Id);

            //builder.OwnsOne(u => u.Email, e =>
            //{
            //    e.HasIndex(e => e.Email).IsUnique();
            //});

            builder.OwnsOne(u => u.shopId, n =>
            {
                n.Property(e => e.shopId).HasColumnName("ShopId");
            });

            builder.Property(u => u.status).HasColumnName("DeliveryStatus");
            builder.OwnsOne(u => u.day, n =>
            {
                n.Property(e => e.deliveryDate).HasColumnName("DeliveryDate");
            });

            builder.OwnsMany(i => i.items, n=>
            {
                n.ToTable("OrderSandwiches");
                n.OwnsOne(u => u.sandwichId,
                    n2 =>
                    {
                        n2.Property(e => e.id).HasColumnName("sandwichId");
                    });
                n.OwnsOne(u => u.quantity,
                   n2 =>
                   {
                       n2.Property(e => e.Quantity).HasColumnName("quantity");
                   });
               
            }
            );

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
