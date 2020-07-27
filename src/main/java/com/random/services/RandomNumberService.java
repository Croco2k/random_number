package com.random.services;

import com.random.dbo.RandomNumber;
import com.random.repositories.RandomNumberRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service//Чтобы спринг создал bean
public class RandomNumberService {

    private final RandomNumberRepository randomNumberRepository;

    //@Qualifier() - для того, чтобы можно было заинджектить определенный bean
    //@Autowired присутствует в неявном виде
    public RandomNumberService(@Qualifier("randomNumberRepository") RandomNumberRepository randomNumberRepository) {
        this.randomNumberRepository = randomNumberRepository;
    }

    public List<RandomNumber> getAll() {
        return randomNumberRepository.findAll()
                .stream()
                .sorted((o1, o2) -> (int) (o2.getCreateDate().getTime() - o1.getCreateDate().getTime()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public RandomNumber addRandomNumber(RandomNumber randomNumber) {
        randomNumberRepository.save(randomNumber);
        return randomNumber;
    }

    public void updateRandomNumber(RandomNumber randomNumber) {
        randomNumberRepository.save(randomNumber);
    }

    public void deleteRandomNumber(@NotNull Long id) {
        randomNumberRepository.deleteById(id);
    }
}
