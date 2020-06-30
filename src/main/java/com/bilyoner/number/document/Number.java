package com.bilyoner.number.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "numbers")
public class Number {
    @Id
    private Integer number;
    private Date date;
}