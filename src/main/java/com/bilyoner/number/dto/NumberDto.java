package com.bilyoner.number.dto;

import com.bilyoner.number.document.Number;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NumberDto {
    private Number number;
}
