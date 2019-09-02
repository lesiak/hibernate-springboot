package com.example.mongowebspringboot.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(mongoHost + ":" + mongoPort), mongoDB);
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, Integer.parseInt(mongoPort));
    }

   // @Bean
   // public MongoTemplate mongoTemplate() {
     //   return new MongoTemplate(mongoDbFactory());
   // }

  //  @Bean
  //  public MappingMongoConverter mappingMongoConverter() {
  //      return new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
   // }

    //@Override
    //protected String getDatabaseName() {
      //  return mongoDB;
   // }
/*
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Stream.of("com.example").collect(Collectors.toList());
    }

 */
}
