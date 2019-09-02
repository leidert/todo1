package co.com.sofka.kardexTodoUno.domain;

import java.net.UnknownHostException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoTemplateProducer {

//	@Produces
//    @ApplicationScoped
//    public MongoOperations createMongoTemplate() throws UnknownHostException, MongoException {
//
//        MongoDbFactory factory = new SimpleMongoDbFactory(new MongoClient(), "dev");
//        return new MongoTemplateProducer(factory);
//    }
//	
}
