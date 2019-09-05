package co.com.sofka.kardexTodoUno.infrastructure;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.kardex;

public class ResultOperactionService {
	
	public String kardexTotalTicket(Product product) {
		
		int Value = Integer.parseInt(product.getPrice());
		int TotalEntry = Integer.parseInt(product.getStok());
		String result = String.valueOf(Value*TotalEntry);
		return result;
	}

	public String addStock(Product product, String stok) {
		
		int oldStockt = Integer.parseInt(product.getStok());
		int newStock = Integer.parseInt(stok);
		int result = oldStockt + newStock;
		String parse = Integer.toString(result);
		
		return parse;
	}
}
