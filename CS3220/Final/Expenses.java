package Expenses;

public class Expenses {
	
	int id;
	String month;
	double amount;
	String tags;
	
	
	
	public Expenses(int id, String month, double amount, String tags) {
		super();
		this.id = id;
		this.month = month;
		this.amount = amount;
		this.tags = tags;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getTags() {
		return tags;
	}



	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	
	
	
	
	

}
