package co.com.sofka.kardexTodoUno.domain;

public class kardex {
	
	private String Date;
	private String Detail;
	private int Value;
	private int InputAmount;
	private int TotalEntry;
	private int AmountOutput;
	private int TotalOutput;
	private int BalanceAmount;
	private int totalBalance;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public int getInputAmount() {
		return InputAmount;
	}
	public void setInputAmount(int inputAmount) {
		InputAmount = inputAmount;
	}
	public int getTotalEntry() {
		return TotalEntry;
	}
	public void setTotalEntry(int totalEntry) {
		TotalEntry = totalEntry;
	}
	public int getAmountOutput() {
		return AmountOutput;
	}
	public void setAmountOutput(int amountOutput) {
		AmountOutput = amountOutput;
	}
	public int getTotalOutput() {
		return TotalOutput;
	}
	public void setTotalOutput(int totalOutput) {
		TotalOutput = totalOutput;
	}
	public int getBalanceAmount() {
		return BalanceAmount;
	}
	public void setBalanceAmount(int balanceAmount) {
		BalanceAmount = balanceAmount;
	}
	public int getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}
	@Override
	public String toString() {
		return "kardex [Date=" + Date + ", Detail=" + Detail + ", Value=" + Value + ", InputAmount=" + InputAmount
				+ ", TotalEntry=" + TotalEntry + ", AmountOutput=" + AmountOutput + ", TotalOutput=" + TotalOutput
				+ ", BalanceAmount=" + BalanceAmount + ", totalBalance=" + totalBalance + "]";
	}

	
}
