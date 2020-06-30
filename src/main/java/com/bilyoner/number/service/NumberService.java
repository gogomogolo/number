package com.bilyoner.number.service;

import com.bilyoner.number.common.NumericOrderType;
import com.bilyoner.number.document.Number;
import com.bilyoner.number.dto.NumberDto;
import com.bilyoner.number.dto.NumbersDto;
import com.bilyoner.number.exception.NumberAlreadyExistException;
import com.bilyoner.number.exception.NumberDoesNotExistException;
import com.bilyoner.number.exception.NumericOrderDoesNotExistException;
import com.bilyoner.number.exception.ResourceDoesNotExistException;
import com.bilyoner.number.repository.NumberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NumberService {
    private final NumberRepository numberRepository;

    public NumberDto getNumberById(Integer number) {
        Optional<Number> document = numberRepository.findById(number);
        ifNotExistThrow(document);
        return NumberDto
                .builder()
                .number(document.get())
                .build();
    }

    public NumbersDto getNumbersWithAnOrder(String order) {
        NumbersDto numbersDto;

        if (NumericOrderType.ASC.name().equals(order.toUpperCase())){
            List<Number> numbers = numberRepository.findAllByOrderByNumberAsc();
            ifEmptyListThrow(numbers);
            numbersDto = NumbersDto
                    .builder()
                    .numberDtos(numbers)
                    .build();
        } else if (NumericOrderType.DESC.name().equals(order.toUpperCase())) {
            List<Number> numbers = numberRepository.findAllByOrderByNumberDesc();
            ifEmptyListThrow(numbers);
            numbersDto = NumbersDto
                    .builder()
                    .numberDtos(numbers)
                    .build();
        } else {
            throw new NumericOrderDoesNotExistException("Given order does not equal to asc or desc");
        }

        return numbersDto;
    }

    public NumberDto getMinNumber() {
        Optional<Number> document = numberRepository.findTopByOrderByNumberAsc();
        ifNotExistThrow(document);
        return NumberDto
                .builder()
                .number(document.get())
                .build();
    }

    public NumberDto getMaxNumber() {
        Optional<Number> document = numberRepository.findTopByOrderByNumberDesc();
        ifNotExistThrow(document);
        return NumberDto
                .builder()
                .number(document.get())
                .build();
    }

    public Number insertNumber(Integer number) {
        ifExistThrow(numberRepository.findById(number));
        Date date = new Date();
        Number document = Number
                .builder()
                .date(date)
                .number(number)
                .build();
        Number insertedNumber = numberRepository.save(document);
        return insertedNumber;
    }

    public void deleteNumber(Integer number) {
        getNumberById(number);
        numberRepository.deleteById(number);
    }

    private void ifExistThrow(Optional resource){
        if (resource.isPresent()){
            throw new NumberAlreadyExistException("Given number already exist!!!");
        }
    }

    private void ifNotExistThrow(Optional resource){
        if (!resource.isPresent()){
            throw new NumberDoesNotExistException("Number does not found");
        }
    }

    private void ifEmptyListThrow(List<Number> resource){
        if (resource.size() == 0){
            throw new ResourceDoesNotExistException("Resource does not found");
        }
    }
}
