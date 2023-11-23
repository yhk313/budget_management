package wanted.budgetmanagement.app.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wanted.budgetmanagement.app.category.domain.Category;
import wanted.budgetmanagement.app.category.repository.CategoryRepository;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
}
