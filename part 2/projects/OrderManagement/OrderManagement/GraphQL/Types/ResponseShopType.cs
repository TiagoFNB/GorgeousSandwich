using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class ResponseShopType
    {

        public GetShopById getShopById { get; set; }

    }
    public class GetShopById
    {

        public ResponseShopIdType id { get; set; }
        public ResponseShopPropertiesType shopProperties { get; set; }
        public List<ResponseShopDailyScheduleType> dailySchedules { get; set; }
    }
    public class ResponseShopIdType
    {
        public string id { get; set; }
    }
    public class ResponseShopPropertiesType
    {
        public ResponseShopMaxNumType maximumNumberDeliveries { get; set; }
        public ResponseShopMinAccType minimumAcceptableAdvance { get; set; }
        public ResponseShopPeriodType period { get; set; }
    }
    public class ResponseShopMaxNumType
    {
        public string maximumNumberDeliveries { get; set; }
    }
    public class ResponseShopMinAccType
    {
        public string minimumAcceptableAdvance { get; set; }
    }
    public class ResponseShopPeriodType
    {
        public string period { get; set; }
    }

    public class ResponseShopDailyScheduleType
    {
        public ResponseShopOpeningHoursType openingHours { get; set; }
        public ResponseShopClosingType closingHours { get; set; }
        public string day { get; set; }
    }
    public class ResponseShopOpeningHoursType
    {
        public string openingHours { get; set; }
    }
    public class ResponseShopClosingType
    {
        public string closingHours { get; set; }
    }
    public class ResponseShopDayType
    {
        public string day { get; set; }
    }
}
