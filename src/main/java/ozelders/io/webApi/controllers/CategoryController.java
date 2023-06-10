package ozelders.io.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ozelders.io.business.abstracts.CategoryService;
import ozelders.io.business.requests.CreateCategoryRequest;
import ozelders.io.business.responses.GetAllCategoriesResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	
	private CategoryService categoryService;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);
	}
	
	@GetMapping()
	public List<GetAllCategoriesResponse> getAll() {
		return this.categoryService.getAll();
	}

}
