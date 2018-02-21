package com.pat.pat.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pat.pat.expense.Expense;
import com.pat.pat.saving.Saving;
import com.pat.pat.saving.SavingRepository;
import com.pat.pat.saving.SavingService;

@Component
public class IncomeService {

	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired 
	SavingRepository savingRepository;
	
	@Autowired
	SavingService savingService;
	
	public List<Income> getAll(){
		return this.incomeRepository.findAll();
	}
	
	public List<Income> get(String month){
		return this.incomeRepository.findByMonth(month);
	}
	
	public Income saveOne(Income income){
		
		try{
			Saving existingSaving = this.savingRepository.findByMonth(income.getMonth());
			if (existingSaving != null) {
				existingSaving.setIncomeTotal(existingSaving.getIncomeTotal() + income.getAmount());
				this.savingRepository.save(existingSaving);
			}
		else{
			Saving newSaving=new Saving();
			 newSaving.setIncomeTotal(income.getAmount());
			 newSaving.setExpenseTotal(0);
			 newSaving.setMonth(income.getMonth());
			 this.savingRepository.save(newSaving);
			}
			this.savingService.setSaving(income.getMonth());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.incomeRepository.save(income);
	}
	
	public Income update(Income income) {

		Income existing = this.incomeRepository.findOne(income.getId());
		Saving existingSaving = this.savingRepository.findByMonth(income.getMonth());

		Integer newIncomeTotal = existingSaving.getIncomeTotal()
				- existing.getAmount() + income.getAmount();
		existingSaving.setExpenseTotal(newIncomeTotal);
		this.savingRepository.save(existingSaving);

		this.savingService.setSaving(income.getMonth());

		existing.setAmount(income.getAmount());
		existing.setSource(income.getSource());
		return this.incomeRepository.save(existing);

	}

	public void delete(String id) {
		this.incomeRepository.delete(id);
	}
}
