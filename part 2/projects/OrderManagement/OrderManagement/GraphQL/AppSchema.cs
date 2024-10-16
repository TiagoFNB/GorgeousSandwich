using GraphQL.Types;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL
{
    public class AppSchema : Schema
    {
        public AppSchema(IServiceProvider provider)
            : base(provider)
        {
            Query = provider.GetRequiredService<AppQuery>();
            Mutation = provider.GetRequiredService<AppMutation>();
        }
    }
}
