package com.viepovsky.rebarcount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RebarCount {
    private HashMap<Integer, String> rebars;
}
