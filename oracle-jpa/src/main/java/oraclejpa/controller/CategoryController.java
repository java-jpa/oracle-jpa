package oraclejpa.controller;

import lombok.RequiredArgsConstructor;
import oraclejpa.service.interfaces.ICategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("")
    Object search(@RequestParam("keyword") String keyword,
                  @RequestParam("page") Integer page,
                  @RequestParam("limit") Integer limit){
        Pageable pageable = PageRequest.of(page-1, limit);
        return categoryService.search(keyword, pageable);
    }
}
