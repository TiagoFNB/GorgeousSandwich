﻿using GraphQL.Types;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Queries
{
    public class DeliveryQuery : ObjectGraphType
    {
        //public DeliveryQuery(DeliveryService authorService)
        //{
        //    int id = 0;
        //    Field<ListGraphType<AuthorType>>(
        //    name: "authors", resolve: context =>
        //    {
        //        return authorService.GetAllAuthors();
        //    });
        //    Field<AuthorType>(
        //        name: "author",
        //        arguments: new QueryArguments(new
        //        QueryArgument<IntGraphType>
        //        { Name = "id" }),
        //        resolve: context =>
        //        {
        //            id = context.GetArgument<int>("id");
        //            return authorService.GetAuthorById(id);
        //        }
        //    );
        //    Field<ListGraphType<BlogPostType>>(
        //        name: "blogs",
        //        arguments: new QueryArguments(new
        //        QueryArgument<IntGraphType>
        //        { Name = "id" }),
        //        resolve: context =>
        //        {
        //            return authorService.GetPostsByAuthor(id);
        //        }
        //    );
        //}
    }
}
