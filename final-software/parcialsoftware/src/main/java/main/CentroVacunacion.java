package main;

import java.util.ArrayList;
import java.util.List;

public class CentroVacunacion {
    private boolean isBaja;
    private List<String> personasVacunadas;
    private String distrit;
    private int vacunasParciales;
    private int vacunasCompletas;

    public CentroVacunacion(String distrito) {
        isBaja = false;
        personasVacunadas = new ArrayList<>();
        this.distrit = distrito;
    }

    public void darDeBaja() {
        isBaja = true;
    }

    public void darDeAlta() {
        isBaja = false;
    }

    public boolean getisBaja() {
        return isBaja;
    }

    public int getVacunasParciales() {
        return vacunasParciales;
    }

    public int getVacunasCompletas() {
        return vacunasCompletas;
    }
}
