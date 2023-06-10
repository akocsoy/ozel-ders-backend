package ozelders.io.business.abstracts;

import java.util.List;

import ozelders.io.business.requests.CreateCategoryRequest;
import ozelders.io.business.responses.GetAllCategoriesResponse;

public interface CategoryService {
	
	void add(CreateCategoryRequest createCategoryRequest);
	List<GetAllCategoriesResponse> getAll();
}
