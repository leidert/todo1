package co.com.sofka.kardexTodoUno.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class kardex {
	
	@XmlElement(name = "_id")
	private String id;
	private String Date;
	private String Detail;
	private String Value;
	private String InputAmount;
	private String TotalEntry;
	private String AmountOutput;
	private String TotalOutput;
	private String BalanceAmount;
	private String TotalBalance;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
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
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getInputAmount() {
		return InputAmount;
	}
	public void setInputAmount(String inputAmount) {
		InputAmount = inputAmount;
	}
	public String getTotalEntry() {
		return TotalEntry;
	}
	public void setTotalEntry(String totalEntry) {
		TotalEntry = totalEntry;
	}
	public String getAmountOutput() {
		return AmountOutput;
	}
	public void setAmountOutput(String amountOutput) {
		AmountOutput = amountOutput;
	}
	public String getTotalOutput() {
		return TotalOutput;
	}
	public void setTotalOutput(String totalOutput) {
		TotalOutput = totalOutput;
	}
	public String getBalanceAmount() {
		return BalanceAmount;
	}
	public void setBalanceAmount(String balanceAmount) {
		BalanceAmount = balanceAmount;
	}
	public String getTotalBalance() {
		return TotalBalance;
	}
	public void setTotalBalance(String totalBalance) {
		this.TotalBalance = totalBalance;
	}
	@Override
	public String toString() {
		return "kardex [Date=" + Date + ", Detail=" + Detail + ", Value=" + Value + ", InputAmount=" + InputAmount
				+ ", TotalEntry=" + TotalEntry + ", AmountOutput=" + AmountOutput + ", TotalOutput=" + TotalOutput
				+ ", BalanceAmount=" + BalanceAmount + ", totalBalance=" + TotalBalance + "]";
	}

	
}
