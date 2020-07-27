package com.random.controllers;

import com.random.dbo.RandomNumber;
import com.random.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//общение с вью(json)
@RequestMapping("/random")//обращение к этому контроллеру
public class RandomNumberController {

    private RandomNumberService randomNumberService;

    public RandomNumberController(@Qualifier("randomNumberService") RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping
    public List<RandomNumber> getAll() {
        return randomNumberService.getAll();
    }

    @PostMapping("/add")
    public RandomNumber addRandomNumber(@RequestBody RandomNumber randomNumber) {
        return randomNumberService.addRandomNumber(randomNumber);
    }

    @PutMapping("/update/{id}")
    public void updateRandomNumber(@RequestBody RandomNumber randomNumber, @PathVariable Long id) {
        randomNumber.setId(id);
        randomNumberService.updateRandomNumber(randomNumber);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRandomNumber(@PathVariable Long id) {
        randomNumberService.deleteRandomNumber(id);
    }

}
