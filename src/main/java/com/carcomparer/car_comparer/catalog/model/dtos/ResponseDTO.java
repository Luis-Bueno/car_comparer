package com.carcomparer.car_comparer.catalog.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class ResponseDTO<T> {

    private String message;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private T data;

}
