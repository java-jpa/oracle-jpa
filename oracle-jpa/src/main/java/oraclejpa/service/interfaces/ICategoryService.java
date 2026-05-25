package oraclejpa.service.interfaces;

import oraclejpa.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryResponse> search(String keyword, Pageable pageable);
}
