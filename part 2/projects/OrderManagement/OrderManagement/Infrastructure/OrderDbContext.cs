
using Microsoft.EntityFrameworkCore;

using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Orders;

namespace OrderManagement.Infrastructure
{
    public class OrderDbContext : DbContext
    {
      
        public DbSet<Order> Orders { get; set; }

        public DbSet<Delivery> Deliveries { get; set; }


        public OrderDbContext(DbContextOptions options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

            modelBuilder.ApplyConfiguration(new DeliveryEntityTypeConfiguration());
            modelBuilder.ApplyConfiguration(new OrderEntityTypeConfiguration());
 
        }
    }
}