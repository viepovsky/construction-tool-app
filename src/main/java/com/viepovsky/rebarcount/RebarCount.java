package com.viepovsky.rebarcount;

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
class RebarCount {
    private Map<Integer, Double> rebars = new HashMap<>();
}
