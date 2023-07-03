package com.academetrics.academetrics;

import java.util.HashMap;
import java.util.Map;

public class Globals {
    public static final Map<String, Double> gpaOfGrade = new HashMap<>();
    static {
        gpaOfGrade.put("A+", 4.0);
        gpaOfGrade.put("A", 4.0);
        gpaOfGrade.put("A-", 3.7);
        gpaOfGrade.put("B+", 3.3);
        gpaOfGrade.put("B", 3.0);
        gpaOfGrade.put("B-", 2.7);
        gpaOfGrade.put("C+", 2.3);
        gpaOfGrade.put("C", 2.0);
        gpaOfGrade.put("C-", 1.7);
        gpaOfGrade.put("D+", 1.3);
        gpaOfGrade.put("D", 1.8);
        gpaOfGrade.put("E", 0.0);
    }
}
