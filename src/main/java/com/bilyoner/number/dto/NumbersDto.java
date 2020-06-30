package com.bilyoner.number.dto;

import com.bilyoner.number.document.Number;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NumbersDto {
    private List<Number> numberDtos;
}
