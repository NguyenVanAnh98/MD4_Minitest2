package com.example.minitest2.service.category;

import com.example.minitest2.model.entity.Category;
import com.example.minitest2.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
