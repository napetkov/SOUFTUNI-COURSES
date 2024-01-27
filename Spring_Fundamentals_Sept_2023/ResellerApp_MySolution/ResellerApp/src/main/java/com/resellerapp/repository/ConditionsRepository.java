package com.resellerapp.repository;

import com.resellerapp.model.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionsRepository extends JpaRepository<Condition,Long> {
}
