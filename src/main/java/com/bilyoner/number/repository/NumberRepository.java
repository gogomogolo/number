package com.bilyoner.number.repository;

import com.bilyoner.number.document.Number;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NumberRepository extends MongoRepository<Number, Integer> {
    List<Number> findAllByOrderByNumberAsc();
    List<Number> findAllByOrderByNumberDesc();
    Optional<Number> findTopByOrderByNumberAsc();
    Optional<Number> findTopByOrderByNumberDesc();
}
