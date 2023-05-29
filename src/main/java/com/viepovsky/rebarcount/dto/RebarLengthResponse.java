package com.viepovsky.rebarcount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RebarLengthResponse {
    private Map<Integer, Double> rebars = new HashMap<>();
}
