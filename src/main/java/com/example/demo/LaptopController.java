package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
	@Autowired
	private LaptopRepository LaptopRepo;
	
	@RequestMapping(value = "/laptop", method = RequestMethod.GET)
	public List<Laptop> laptopList() {
		return LaptopRepo.findAll();
	}
	@PostMapping("/laptop")
	public Laptop laptopPost(@RequestBody Laptop laptop) {
		return LaptopRepo.save(laptop);
	}
//	@GetMapping("/laptop")
//	public Optional<Laptop> lapGet(@RequestParam Long id) {		
//		return LaptopRepo.findById(id);
//	}
	@DeleteMapping("/laptop")
	public String laptopDelete(@RequestParam Long id) {	
		LaptopRepo.deleteById(id);
		return "Record No. "+id+" has been Deleted";
	}
	@PutMapping("/laptop")
	public Laptop greetingPut(@RequestBody Laptop laptop) {
		return LaptopRepo.save(laptop);
	}
}