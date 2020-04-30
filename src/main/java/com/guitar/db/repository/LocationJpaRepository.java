package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {
    List<Location> findByStateLike(String state);
    List<Location> findByStateNotLike(String state);
    List<Location> findByStateOrCountry(String state, String country);
    List<Location> findByStateAndCountry(String state, String country);
}
