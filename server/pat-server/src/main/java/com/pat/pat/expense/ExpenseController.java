package com.pat.pat.expense;

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

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping
	public List<Expense> getAll(){
		return this.expenseService.getAll();
	}
	
	@GetMapping("/{month}")
	public List<Expense> get(@PathVariable("month") String month){
		return this.expenseService.get(month);
	}
	
	@PostMapping
	public Expense save(@RequestBody Expense expense){
		return this.expenseService.saveOne(expense);
	}
	
	@PutMapping
	public Expense update(@RequestBody Expense expense){
		return this.expenseService.update(expense);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id){
		 this.expenseService.delete(id);
	}

}
