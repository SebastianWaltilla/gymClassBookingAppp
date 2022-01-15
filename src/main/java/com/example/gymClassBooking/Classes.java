package com.example.gymClassBooking;

import java.util.HashMap;

public class Classes {

    public static String getGymClass(String s) {

        HashMap<String, String> classes = new HashMap<>();
        classes.put("BODYPUMP", "16601,16809,16577");
        classes.put("FUNKTIONELL", "20875");
        classes.put("CYKEL", "16663,16665,16607");
        classes.put("UTOMHUS", "21156,19975,19388,21262,21440,21439,21442,21441,21687,21443");
        return classes.get(s);
    }
}
