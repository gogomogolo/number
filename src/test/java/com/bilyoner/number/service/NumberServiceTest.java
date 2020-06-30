package com.bilyoner.number.service;

import com.bilyoner.number.document.Number;
import com.bilyoner.number.dto.NumberDto;
import com.bilyoner.number.repository.NumberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private NumberService numberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        numberService = new NumberService(numberRepository);
    }

    @Test
    void shouldGetNumber() {
        // GIVEN
        final Date EXPECTED_DATE = new Date();
        final Integer EXPECTED_NUMBER = Integer.valueOf(10);
        Number document = Number
                .builder()
                .number(EXPECTED_NUMBER)
                .date(EXPECTED_DATE)
                .build();
        when(numberRepository.findById(EXPECTED_NUMBER)).thenReturn(Optional.of(document));

        // WHEN
        NumberDto numberDto = numberService.getNumberById(EXPECTED_NUMBER);

        // THEN
        verify(numberRepository, times(1)).findById(EXPECTED_NUMBER);
        assertNotNull(numberDto);
        assertEquals(numberDto.getNumber().getNumber(), EXPECTED_NUMBER);
        assertEquals(numberDto.getNumber().getDate(), EXPECTED_DATE);
    }
}