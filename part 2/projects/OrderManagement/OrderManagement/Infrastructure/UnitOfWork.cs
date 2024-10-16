using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using OrderManagement.Domain.Shared;

namespace OrderManagement.Infrastructure
{
    public class UnitOfWork : IUnitOfWork
    {
        private readonly OrderDbContext _context;

        public UnitOfWork(OrderDbContext context)
        {
            this._context = context;
            context.Database.Migrate();
        }

        public async Task<int> CommitAsync()
        {
            return await this._context.SaveChangesAsync();
        }
    }
}