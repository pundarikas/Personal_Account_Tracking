package com.pat.pat.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pat.pat.saving.Saving;
import com.pat.pat.saving.SavingRepository;
import com.pat.pat.saving.SavingService;

@Component
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	SavingRepository savingRepository;
	
	@Autowired
	SavingService savingService;	
	
	
	public List<Expense> getAll(){
		return this.expenseRepository.findAll();
	}
	
	public List<Expense> get(String month){
		return this.expenseRepository.findByMonth(month);
	}
	
	public Expense saveOne(Expense expense){
		
		try{
			Saving existingSaving = this.savingRepository.findByMonth(expense.getMonth());
			if (existingSaving != null) {
				existingSaving.setExpenseTotal(existingSaving.getExpenseTotal() + expense.getAmount());
				this.savingRepository.save(existingSaving);
			}
		else{
			Saving newSaving=new Saving();
			 newSaving.setExpenseTotal(expense.getAmount());
			 newSaving.setIncomeTotal(0);
			 newSaving.setMonth(expense.getMonth());
			 this.savingRepository.save(newSaving);
			}
			this.savingService.setSaving(expense.getMonth());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.expenseRepository.save(expense);
	}
	
	public Expense update(Expense expense) {

		Expense existing = this.expenseRepository.findOne(expense.getId());
		Saving existingSaving = this.savingRepository.findByMonth(expense.getMonth());

		Integer newExpenseTotal = existingSaving.getExpenseTotal()
				- existing.getAmount() + expense.getAmount();
		existingSaving.setExpenseTotal(newExpenseTotal);
		this.savingRepository.save(existingSaving);

		this.savingService.setSaving(expense.getMonth());

		existing.setAmount(expense.getAmount());
		existing.setPurpose(expense.getPurpose());
		return this.expenseRepository.save(existing);

	}
	

	public void delete(String id) {
		this.expenseRepository.delete(id);
	}
}
