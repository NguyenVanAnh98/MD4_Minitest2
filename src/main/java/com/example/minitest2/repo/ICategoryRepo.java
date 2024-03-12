package com.example.minitest2.repo;

import com.example.minitest2.model.dto.TotalAmount;
import com.example.minitest2.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {
    @Query(nativeQuery = true, value = "select c.name as nameCategory, sum(t.amount) as totalAmount from category c left join task t on c.id = t.category_id group by c.id;")
    Iterable<TotalAmount> getTotalAmount();



//    Category findCategoryByDescription(String description);

}
