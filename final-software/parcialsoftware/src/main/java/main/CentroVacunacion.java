package main;

import java.util.ArrayList;
import java.util.List;

public class CentroVacunacion {
    private boolean isBaja;
    private String distrit;
    private int vacunasParciales;
    private int vacunasCompletas;

    public CentroVacunacion(String distrito, int vacunasParciales, int vacunasCompletas) {
        isBaja = false;
        this.distrit = distrito;
        this.vacunasParciales = vacunasParciales;
        this.vacunasCompletas = vacunasCompletas;
    }

    public void darBaja() {
        isBaja = true;
    }

    public void darAlta() {
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
