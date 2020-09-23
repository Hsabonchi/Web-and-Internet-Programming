package Final.model;

import java.util.List;

public class Expense {
	int id;
	String month;
	float amount;
	List<String> tags;
	
	public Expense(int id, String month, float amount, List<String> tags) {
		this.id = id;
		this.month = month;
		this.amount = amount;
		this.tags = tags;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
