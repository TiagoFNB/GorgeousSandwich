using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using OrderManagement.Infrastructure;
using OrderManagement.Infrastructure.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GraphQL.Server;
using GraphiQl;
using GraphQL.Types;
using OrderManagement.GraphQL;
using GraphQL.Server.Ui.Playground;
using OrderManagement.Services;
using OrderManagement.Domain.Shared;
using GraphQL.Client.Http;
using GraphQL.Client.Abstractions;
using GraphQL.Client.Serializer.Newtonsoft;
using Steeltoe.Discovery.Client;

namespace OrderManagement
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {

            services.AddTransient<IUnitOfWork, UnitOfWork>();
            services.AddControllers();
            services.AddDbContext<OrderDbContext>(options =>
               options.UseSqlServer(
                   Configuration.GetConnectionString("DefaultConnection"),
                          b => b.MigrationsAssembly(typeof(OrderDbContext).Assembly.FullName))
               .ReplaceService<IValueConverterSelector, StronglyEntityIdValueConverterSelector>());
            services.AddScoped<AppSchema>();
            services.AddGraphQL()
                .AddSystemTextJson()
                .AddGraphTypes(typeof(AppSchema), ServiceLifetime.Scoped);

            services.AddScoped<IDeliveryRepository, DeliveryRepository>();
            services.AddScoped<IOrderRepository, OrderRepository>();
            services.AddTransient<IOrderService, OrderService>();

            services.AddDiscoveryClient(Configuration);
           



        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            //app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });

            app.UseGraphQL<AppSchema>();
            app.UseGraphQLPlayground(options: new GraphQLPlaygroundOptions());

            app.UseDiscoveryClient();

        }
    }
}
