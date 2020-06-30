package com.bilyoner.number.controller;

import com.bilyoner.number.document.Number;
import com.bilyoner.number.dto.NumberDto;
import com.bilyoner.number.dto.NumbersDto;
import com.bilyoner.number.service.NumberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
@SessionScope
@RestController
@RequestMapping("/numbers")
public class NumberController {
    private final NumberService numberService;

    @GetMapping("/{number}")
    ResponseEntity<NumberDto> getNumber(@PathVariable Integer number){
        NumberDto numberDto = numberService.getNumberById(number);
        return ResponseEntity.ok().body(numberDto);
    }

    @GetMapping
    ResponseEntity<NumbersDto> getNumber(@RequestParam(required = false, defaultValue = "asc") String order){
        NumbersDto numbersDto = numberService.getNumbersWithAnOrder(order);
        return ResponseEntity.ok().body(numbersDto);
    }

    @GetMapping("/min")
    ResponseEntity<NumberDto> getMinNumber(){
        NumberDto numberDto = numberService.getMinNumber();
        return ResponseEntity.ok().body(numberDto);
    }

    @GetMapping("/max")
    ResponseEntity<NumberDto> getMaxNumber(){
        NumberDto numberDto = numberService.getMaxNumber();
        return ResponseEntity.ok().body(numberDto);
    }

    @PostMapping("/{number}")
    ResponseEntity<Number> insertNumber(@PathVariable Integer number){
        Number insertedNumber = numberService.insertNumber(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedNumber);
    }

    @DeleteMapping("/{number}")
    ResponseEntity<String> deleteNumber(@PathVariable Integer number){
        numberService.deleteNumber(number);
        return ResponseEntity.ok().body("DELETED");
    }
}
