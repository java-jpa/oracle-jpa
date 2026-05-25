package oraclejpa.service.impl;

import lombok.RequiredArgsConstructor;
import oraclejpa.dto.response.CategoryResponse;
import oraclejpa.repository.ICategoryRepository;
import oraclejpa.service.interfaces.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public Page<CategoryResponse> search(String keyword, Pageable pageable) {
        return categoryRepository.search(keyword, pageable);
    }
}
