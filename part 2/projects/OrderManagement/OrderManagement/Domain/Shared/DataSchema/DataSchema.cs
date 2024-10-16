namespace OrderManagement.Domain.Shared.DataSchema
{
    /// <summary>
    /// Base class for entities.
    /// </summary>
    public abstract class DataSchema<TDataSchemaId>
    where TDataSchemaId : DataSchemaId
    {
         public TDataSchemaId Id { get;  protected set; }
    }
}