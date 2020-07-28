package com.random.repositories;

import com.random.dbo.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {

    List<RandomNumber> findAllByOrderByCreateDateDesc();

}
