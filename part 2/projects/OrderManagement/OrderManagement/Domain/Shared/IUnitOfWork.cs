using System.Threading.Tasks;

namespace OrderManagement.Domain.Shared
{
    public interface IUnitOfWork
    {
        Task<int> CommitAsync();
    }
}