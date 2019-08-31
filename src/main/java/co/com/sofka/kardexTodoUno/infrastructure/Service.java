package co.com.sofka.kardexTodoUno.infrastructure;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTodoUno.domain.Repository;
import co.com.sofka.kardexTodoUno.domain.User;

public class Service implements Repository {
	
	public static final String DB_NAME = "kardex";
    public static final String COLL_NAME = "user";

    protected MongoDatabase db;
    protected MongoCollection<Document> collection;
    
    @InjectParam
    MongoClient mongoClient;
    
    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collection = this.db.getCollection(COLL_NAME);
    }
    
    
	
	public String getAllproduct() {
		return "mostrando productos desde service";
	}
	
	public String getAllUser() {
		return "mostrando User desde service";
	}
	
	public String getAllKardex() {
		return "mostrando Kardex desde service";
	}
	
	
	public List<User> findAll() {
		List<User> userArray = new ArrayList<User>();
		MongoCursor<Document> cursor = this.collection.find().iterator();
		
		
		while (cursor.hasNext()) {
			Document UserBson = cursor.next();
			
			String objectId = UserBson.getObjectId("_id").toString();
			User user = new User();
			
			user.setId(objectId);
			user.setName(UserBson.getString("Name"));
			user.setNit(UserBson.getString("Nit"));
			
			userArray.add(user);
			
		}
		
		return  userArray;
	}

}
