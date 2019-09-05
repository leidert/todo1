package co.com.sofka.kardexTodoUno.infrastructure;

import java.text.SimpleDateFormat;
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
import com.mongodb.client.result.DeleteResult;
import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.Repository;
import co.com.sofka.kardexTodoUno.domain.User;
import co.com.sofka.kardexTodoUno.domain.kardex;
import java.util.Date;

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
    
    ResultOperactionService resultOperactionService = new ResultOperactionService();
    
    @InjectParam
    MongoClient mongoClient;
    
    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collectionUser = this.db.getCollection(COLL_NAME_USER);
        this.collectionProduct = this.db.getCollection(COLL_NAME_PRODUCT);
        this.collectionKardex = this.db.getCollection(COLL_NAME_KARDEX); 
    }
    
	
	public List<User> findAllUser() {
		
		List<User> userArray = new ArrayList<User>();
		MongoCursor<Document> cursor = this.collectionUser.find().iterator();
		
		while (cursor.hasNext()) {
			Document UserBson = cursor.next();

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
			product.setStok(ProductBson.getString("stock"));
			product.setPrice(ProductBson.getString("price"));
			
			productArray.add(product);
		}
		return  productArray;
	}
	
	public String EntryProduct(Product product) {
		Product resul = this.findByIdProduct(product.getDetail());
				
				if (product.getDetail().equals(resul.getDetail())) {
					increaseProduct( resul, product);
					createKardexProducto(product);
				        return "update";
				}else {
						createProduct(product);
						createKardexProducto(product);
						return product.getId();	
					}
		}
	
	public void increaseProduct(Product resul, Product product) {
		
		int oldStock = Integer.parseInt(product.getStok());
		int newStock = Integer.parseInt(resul.getStok());
		
		String stock = String.valueOf(newStock+oldStock);
		Document doc = new Document();
		
		doc.append("stock", stock);
		
		this.collectionProduct.findOneAndUpdate(eq("id", resul.getId()), new Document("$set", doc));
	}
	
	public void createProduct(Product product) {
		
		Document doc = new Document();
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("detail", product.getDetail());
		doc.append("stock", product.getStok());
		doc.append("price", product.getPrice());
		
		this.collectionProduct.insertOne(doc);
		
	}

	public void updateProduct(String id, Product product) {
		Document doc = new Document();
		doc.append("id", product.getId());
		doc.append("detail", product.getDetail());
		doc.append("stock", product.getStok());
		doc.append("price", product.getPrice());
		
		this.collectionProduct.findOneAndUpdate(eq("id", id), new Document("$set", doc));
	}


	public Product findByIdProduct(String name) throws NullPointerException  {
	
		Product product = new Product();
		try {
			Document ProductBson = this.collectionProduct.find(eq("detail", name)).first();
			String _id = ProductBson.getString("id");
			String detail = ProductBson.getString("detail");
			
			product.setId(_id);
			product.setDetail(detail);
			product.setStok(ProductBson.getString("stock"));
			product.setPrice(ProductBson.getString("price"));
			
		} catch (NullPointerException e) {
			System.out.println("Caught Null Pointer Exception" + e);
		}
		
		return product;
	}
	
	public DeleteResult removeProduct(String id) {
		DeleteResult deleteResult = this.collectionProduct.deleteOne(eq("id", id));
		 
		 return deleteResult;
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
	
	public void createKardexProducto(Product product) {
		Document doc = new Document();
		ResultOperactionService resultadoKardex = new ResultOperactionService();
		Date fecha = new Date();
		
		String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat formaDate = new SimpleDateFormat(strDateFormat);
		
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("AmountOutput", "0");
		doc.append("TotalOutput", "0");
		doc.append("InputAmount", product.getStok().toString());
		doc.append("BalanceAmoun", "0");
		doc.append("TotalEntry", resultadoKardex.kardexTotalTicket(product));
		doc.append("Detail", product.getDetail());
		doc.append("Value", product.getPrice());
		doc.append("TotalBalance", "0");
		doc.append("Date",  formaDate.format(fecha));
		this.collectionKardex.insertOne(doc);
			
	}

	
	public void createKardex(kardex kardex) {
		Document doc = new Document();
		ResultOperactionService resultadoKardex = new ResultOperactionService();
		Date fecha = new Date();
		
		String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat formaDate = new SimpleDateFormat(strDateFormat);
		
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
		doc.append("Date",  formaDate.format(fecha));
		this.collectionKardex.insertOne(doc);
			
	}
	
	public String EntryKardex(kardex kardex) {
		
		String resul = this.findByNameKardex(kardex.getDetail()).getDetail();
		if (kardex.getDetail().equals(resul)) {
			updateKardex(kardex.getDetail(), kardex);
			return "update";
		}else {
			createKardex(kardex);
			return "create";
		}
	}
	

	public kardex findByNameKardex(String name) {
		kardex kardex = new kardex();
		
		try {
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
			
		} catch (NullPointerException e) {
			System.out.println("Caught Null Pointer Exception" + e);
		}
		
		return kardex;
	}

	public Document updateKardex(String Detail, kardex kardex) {
		
		Document doc = new Document();
		
		doc.append("AmountOutput", kardex.getAmountOutput());
		doc.append("TotalOutput", kardex.getTotalOutput());
		doc.append("InputAmount", kardex.getInputAmount());
		doc.append("BalanceAmoun", kardex.getBalanceAmount());
		doc.append("TotalEntry", "0");
		doc.append("Detail", kardex.getDetail());
		doc.append("Value", kardex.getValue());
		doc.append("TotalBalance", kardex.getTotalBalance());
		//doc.append("Date", kardex.getDate());
		Document result = this.collectionKardex.findOneAndUpdate(eq("Detail", Detail), new Document("$set", doc));
		return result;
	}
	
}
