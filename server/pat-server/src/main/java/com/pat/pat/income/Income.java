package com.pat.pat.income;

import org.springframework.data.annotation.Id;

public class Income {

	@Id
	private String id;
	private String month;
	private String source;
	private Integer amount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Income [id=" + id + ", month=" + month + ", source=" + source
				+ ", amount=" + amount + "]";
	}
	
	
}
