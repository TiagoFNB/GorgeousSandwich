using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class ResponsePromotionsType
    {

        public List<ResponsePromotionType> findBySandwichAndPeriod { get; set; }

    }

    public class ResponsePromotionType
    {

        public ResponsePromotionIdType id { get; set; }
        public string type { get; set; }
        public ResponsePromotionPercentageType percentage { get; set; }
        public ResponsePromotionPeriodType period { get; set; }
       

    }

    public class ResponsePromotionIdType
    {
        public string id { get; set; }
    }

    public class ResponsePromotionPercentageType
    {
        public double percentage { get; set; }
    }
    public class ResponsePromotionPeriodType
    {
        public ResponsePromotionPeriodBeginningType promotionPeriodBeginning { get; set; }
        public ResponsePromotionPeriodEndType promotionPeriodEnd { get; set; }
    }
    public class ResponsePromotionPeriodEndType
    {
        public string promotionPeriodEnd { get; set; }
    }
    public class ResponsePromotionPeriodBeginningType
    {
        public string promotionPeriodBeginning { get; set; }
    }
    
}
