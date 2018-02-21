package com.pat.pat.saving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saving")
public class SavingController {

	@Autowired
	SavingService savingService;
	
	@GetMapping("/{month}")
	public Saving getSaving(@PathVariable("month") String month) {
		return this.savingService.getSaving(month);
	}
	
	/*@PostMapping("/{month}")
	public Integer save(@PathVariable("month") String month) {
		return this.savingService.getSaving(month);
	}*/
}
