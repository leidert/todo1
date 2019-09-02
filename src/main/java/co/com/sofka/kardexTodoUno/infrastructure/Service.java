package co.com.sofka.kardexTodoUno.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.Repository;
import co.com.sofka.kardexTodoUno.domain.User;
import co.com.sofka.kardexTodoUno.domain.kardex;

import static com.mongodb.client.model.Filters.eq;

@org.springframework.stereotype.Service("userService")
@Transactional
public class Service implements Repository {
	
	public static final String DB_NAME = "kardex";
    public static final String COLL_NAME_USER = "user";
    public static final String COLL_NAME_PRODUCT = "product";
    public static final String COLL_NAME_KARDEX = "kardex";

    protected MongoDatabase db;
    protected MongoCollection<Document> collectionUser;
    protected MongoCollection<Document> collectionProduct;
    protected MongoCollection<Document> collectionKardex;
    
    @InjectParam
    MongoClient mongoClient;
    
    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collectionUser = this.db.getCollection(COLL_NAME_USER);
        this.collectionProduct = this.db.getCollection(COLL_NAME_PRODUCT);
        this.collectionKardex = this.db.getCollection(COLL_NAME_KARDEX);
    }
    
	
	public List<User> findAll() {
		
		List<User> userArray = new ArrayList<User>();
		MongoCursor<Document> cursor = this.collectionUser.find().iterator();
		
		while (cursor.hasNext()) {
			Document UserBson = cursor.next();
			
			//String objectId = UserBson.getObjectId("_id").toString();
			User user = new User();
			
			user.setId(UserBson.getString("id"));
			user.setName(UserBson.getString("Name"));
			user.setNit(UserBson.getString("Nit"));

			userArray.add(user);
		}
		return  userArray;
	}

	public void CreateUser(User user) {
		Document doc = new Document();
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("Name", user.getName());
		doc.append("Nit", user.getNit());
		
		this.collectionUser.insertOne(doc);
	}

	public void updateUser(String id, User user) {
		Document doc = new Document();
		doc.append("id", user.getId()).append("Name", user.getName()).append("Nit", user.getNit());
		this.collectionUser.findOneAndUpdate(eq("id", id), new Document("$set", doc));
	}
	
	public User findByIdUser(String id) {
		User user = new User();
		Document UserBson = this.collectionUser.find(eq("id", id)).first();
		
		user.setId(UserBson.getString("id"));
		user.setName(UserBson.getString("Name"));
		user.setNit(UserBson.getString("Nit"));
		
		return user;
	}
	

	public List<Product> getAllproduct() {
		
		List<Product> productArray = new ArrayList<Product>();
		MongoCursor<Document> cursor = this.collectionProduct.find().iterator();
		
		while (cursor.hasNext()) {
			
			Document ProductBson = cursor.next();
			Product product = new Product();
		
			product.setId(ProductBson.getString("id"));
			product.setDetail(ProductBson.getString("detail"));
			
			productArray.add(product);
		}
		return  productArray;
	}

	public void createProduct(Product product) {
		Document doc = new Document();
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("detail", product.getDetail());
		
		this.collectionProduct.insertOne(doc);
		
	}

	public void updateProduct(String id, Product product) {
		Document doc = new Document();
		doc.append("id", product.getId()).append("detail", product.getDetail());
		this.collectionProduct.findOneAndUpdate(eq("id", id), new Document("$set", doc));
	}


	public Product findByIdProduct(String id) {
		Product product = new Product();
		Document ProductBson = this.collectionProduct.find(eq("id", id)).first();
		
		product.setId(ProductBson.getString("id"));
		product.setDetail(ProductBson.getString("detail"));
		
		return product;
	}

	public List<kardex> getAllKardex() {
		List<kardex> kardexArray = new ArrayList<kardex>();
		MongoCursor<Document> cursor = this.collectionKardex.find().iterator();
		
		while (cursor.hasNext()) {
			
			Document kardexBson = cursor.next();
			kardex kardex = new kardex();
		
			kardex.setId(kardexBson.getString("id"));
			kardex.setAmountOutput(kardexBson.getString("AmountOutput"));
			kardex.setTotalOutput(kardexBson.getString("TotalOutput"));
			kardex.setInputAmount(kardexBson.getString("InputAmount"));
			kardex.setBalanceAmount(kardexBson.getString("BalanceAmount"));
			kardex.setTotalEntry(kardexBson.getString("TotalEntry"));
			kardex.setDetail(kardexBson.getString("Detail"));
			kardex.setValue(kardexBson.getString("Value"));
			kardex.setTotalBalance(kardexBson.getString("TotalBalance"));
			kardex.setDate(kardexBson.getString("Date"));
			
			kardexArray.add(kardex);
		}
		return  kardexArray;
	}
	

	public void createKardex(kardex kardex) {
		Document doc = new Document();
		ResultadoKardex resultadoKardex = new ResultadoKardex();
		
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("AmountOutput", kardex.getAmountOutput());
		doc.append("TotalOutput", kardex.getTotalOutput());
		doc.append("InputAmount", kardex.getInputAmount());
		doc.append("BalanceAmoun", kardex.getBalanceAmount());
		doc.append("TotalEntry", resultadoKardex.kardexTotalTicket(kardex));
		doc.append("Detail", kardex.getDetail());
		doc.append("Value", kardex.getValue());
		doc.append("TotalBalance", kardex.getTotalBalance());
		doc.append("Date", kardex.getDate());
		this.collectionKardex.insertOne(doc);
			
	}

	public kardex findByNameKardex(String name) {
		kardex kardex = new kardex();
		Document kardexBson = this.collectionKardex.find(eq("Detail", name)).first();
		
		kardex.setId(kardexBson.getString("id"));
		kardex.setAmountOutput(kardexBson.getString("AmountOutput"));
		kardex.setTotalOutput(kardexBson.getString("TotalOutput"));
		kardex.setInputAmount(kardexBson.getString("InputAmount"));
		kardex.setBalanceAmount(kardexBson.getString("BalanceAmount"));
		kardex.setTotalEntry(kardexBson.getString("TotalEntry"));
		kardex.setDetail(kardexBson.getString("Detail"));
		kardex.setValue(kardexBson.getString("Value"));
		kardex.setTotalBalance(kardexBson.getString("TotalBalance"));
		kardex.setDate(kardexBson.getString("Date"));
		
		return kardex;
		
	}

	public Document updateKardex(String Detail, kardex kardex) {
		ResultadoKardex resultadoKardex = new ResultadoKardex();
		Document doc = new Document();
		
		doc.append("AmountOutput", kardex.getAmountOutput());
		doc.append("TotalOutput", kardex.getTotalOutput());
		doc.append("InputAmount", kardex.getInputAmount());
		doc.append("BalanceAmoun", kardex.getBalanceAmount());
		doc.append("TotalEntry", resultadoKardex.kardexTotalTicket(kardex));
		doc.append("Detail", kardex.getDetail());
		doc.append("Value", kardex.getValue());
		doc.append("TotalBalance", kardex.getTotalBalance());
		doc.append("Date", kardex.getDate());
		Document result = this.collectionKardex.findOneAndUpdate(eq("Detail", Detail), new Document("$set", doc));
		return result;
	}
	
}
