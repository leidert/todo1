package co.com.sofka.kardexTodoUno.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

import com.mongodb.MongoClient;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class MongoConnection {
	
	@Produces
    @ApplicationScoped
	public MongoClient mongoClient() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        return mongo;
    }
}
