package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ModelJpaRepository extends JpaRepository<Model, Long> {
    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal lowest, BigDecimal highest);

    @Query("SELECT m FROM Model m WHERE m.price >= :lowest AND m.price <= :highest AND m.woodType LIKE %:wood%")
    Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest, @Param("highest") BigDecimal highest,
                                             @Param("wood") String wood, Pageable page);
}
