package com.example.minitest2.service.category;

import com.example.minitest2.model.entity.Category;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    void save (Category category);
    Category findById(Long id);
    void remove  (Long id);
}
