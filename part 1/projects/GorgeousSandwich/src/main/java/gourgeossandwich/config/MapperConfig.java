package gourgeossandwich.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.addMixIn(Object.class, IgnoreHibernatePropertiesInJackson.class);
        return mapper;
    }
}

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
abstract class IgnoreHibernatePropertiesInJackson {
}
