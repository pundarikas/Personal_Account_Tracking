package com.pat.pat.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pat.pat.expense.Expense;

@RestController
@RequestMapping("/income")
public class IncomeController {

	
	@Autowired
	IncomeService incomeService;
	
	@GetMapping
	public List<Income> getAll(){
		return this.incomeService.getAll();
	}
	
	@GetMapping("/{month}")
	public List<Income> get(@PathVariable("month") String month){
		return this.incomeService.get(month);
	}
	
	@PostMapping
	public Income save(@RequestBody Income income){
		System.out.println("called");
		return this.incomeService.saveOne(income);
	}

	@PutMapping
	public Income update(@RequestBody Income income){
		System.out.println(income.toString());
		return this.incomeService.update(income);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id){
		 this.incomeService.delete(id);
	}

}
