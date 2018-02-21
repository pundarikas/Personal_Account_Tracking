package com.pat.pat.saving;

import org.springframework.data.annotation.Id;

public class Saving {

	@Id
	private String id;
	private Integer incomeTotal;
	private Integer expenseTotal;
	private Integer savingAmount;
	private Double limit;
	private String month;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIncomeTotal() {
		return incomeTotal;
	}
	public void setIncomeTotal(Integer incomeTotal) {
		this.incomeTotal = incomeTotal;
	}
	public Integer getExpenseTotal() {
		return expenseTotal;
	}
	public void setExpenseTotal(Integer expenseTotal) {
		this.expenseTotal = expenseTotal;
	}
	
	public Integer getSavingAmount() {
		return savingAmount;
	}
	public void setSavingAmount(Integer savingAmount) {
		this.savingAmount = savingAmount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "Saving [id=" + id + ", incomeTotal=" + incomeTotal
				+ ", expenseTotal=" + expenseTotal + ", savingAmount="
				+ savingAmount + ", limit=" + limit + ", month=" + month + "]";
	}
	
	
}
