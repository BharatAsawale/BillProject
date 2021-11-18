package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepo extends MongoRepository<Bill, String> {
//    Optional<?> findAllByBillDate(String date);
    List<Bill> findAllByBillDate(String date);
    boolean existsByBillDate(String date);
}
