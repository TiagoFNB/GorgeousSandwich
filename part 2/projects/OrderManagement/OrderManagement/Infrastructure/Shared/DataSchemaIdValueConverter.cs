using System;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using OrderManagement.Domain.Shared;
using OrderManagement.Domain.Shared.DataSchema;

namespace OrderManagement.Infrastructure.Shared
{
    public class DataSchemaIdValueConverter<TTypedIdValue> : ValueConverter<TTypedIdValue, String>
        where TTypedIdValue : DataSchemaId
    {
        public DataSchemaIdValueConverter(ConverterMappingHints mappingHints = null) 
            : base(id => id.Value, value => Create(value), mappingHints)
        {
        }

        private static TTypedIdValue Create(String id) => Activator.CreateInstance(typeof(TTypedIdValue), id) as TTypedIdValue;
    }
}