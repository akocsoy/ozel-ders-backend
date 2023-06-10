package ozelders.io.business.concretes;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import ozelders.io.business.abstracts.CategoryService;
import ozelders.io.business.requests.CreateCategoryRequest;
import ozelders.io.business.responses.GetAllCategoriesResponse;
import ozelders.io.core.utils.mappers.ModelMapperService;
import ozelders.io.dataAccess.abstracts.CategoryRepository;
import ozelders.io.entities.concretes.Category;

@Data
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
	
	private ModelMapperService modelMapperService;
	private CategoryRepository categoryRepository;
	
	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		
		
	}

	@Override
	public List<GetAllCategoriesResponse> getAll() {
		List<Category> categories = this.categoryRepository.findAll();
		List<GetAllCategoriesResponse> resp = categories.stream().map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());
		return resp;
	}

}
