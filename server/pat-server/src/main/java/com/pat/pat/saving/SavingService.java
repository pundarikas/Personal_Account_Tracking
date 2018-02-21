package com.pat.pat.saving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavingService {

	@Autowired
	SavingRepository savingRepository;
	
	public Saving getSaving(String month){
		return this.savingRepository.findByMonth(month);
		
	}
	
	public void setSaving(String month){
		Saving saving = this.savingRepository.findByMonth(month);
		Integer incomeTotal=saving.getIncomeTotal();
		Integer expenseTotal=saving.getExpenseTotal();
		Integer savingAmount =  incomeTotal-expenseTotal;
		Double limit =  incomeTotal* 0.25;
		saving.setSavingAmount(savingAmount);
		saving.setLimit(limit);
		System.out.println(saving.toString());
		this.savingRepository.save(saving);
		
	}
}
