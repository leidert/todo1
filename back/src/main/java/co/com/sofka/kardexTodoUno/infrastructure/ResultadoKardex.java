package co.com.sofka.kardexTodoUno.infrastructure;

import co.com.sofka.kardexTodoUno.domain.kardex;

public class ResultadoKardex {
	
	public String kardexTotalTicket(kardex kardex) {
		
		int Value = Integer.parseInt(kardex.getValue());
		int TotalEntry = Integer.parseInt(kardex.getInputAmount());
		String result = String.valueOf(Value*TotalEntry);
		return result;
	}
}
