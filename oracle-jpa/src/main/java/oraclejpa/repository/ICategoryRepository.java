package oraclejpa.repository;

import oraclejpa.dto.response.CategoryResponse;
import oraclejpa.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
        select new oraclejpa.dto.response.CategoryResponse(e.id, e.name, e.description) 
        from Category e 
        where ?1 is null or e.name like concat('%', ?1, '%') 
           or e.description like concat('%', ?1, '%')
    """)
    Page<CategoryResponse> search(String keyword, Pageable pageable);
}
