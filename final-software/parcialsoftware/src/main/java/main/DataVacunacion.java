package main;

import java.util.HashMap;

public class DataVacunacion {
    private HashMap<String, Integer> vacunadosEdad;
    private int total;
    private static DataVacunacion instance = null;

    public static DataVacunacion getInstance()
    {
        if (instance == null)
            instance = new DataVacunacion();
        return instance;
    }

    private DataVacunacion() {
        vacunadosEdad = new HashMap<>();
        vacunadosEdad.put("18 a 39", 6303670+5031117);
        vacunadosEdad.put("40 a 49", 4183174);
        vacunadosEdad.put("50 a 59", 3277134);
        vacunadosEdad.put("60 a 69", 2221241);
        vacunadosEdad.put("70 a 79", 1271842);
        vacunadosEdad.put("80 a mas", 647355);
        total = 0;
        for (Integer value : vacunadosEdad.values()) {
            total += value;
        }
    }

    public float getPorcentaje(String rangoEdad) {
        if (!vacunadosEdad.containsKey(rangoEdad))
            return -1.0f;
        return Math.round(100.0f*100.0f*vacunadosEdad.get(rangoEdad)/total)/100.0f;
    }
}
