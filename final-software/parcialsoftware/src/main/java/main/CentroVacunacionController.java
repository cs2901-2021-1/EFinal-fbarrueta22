package main;

import java.util.HashMap;

public class CentroVacunacionController {
    HashMap<Integer, CentroVacunacion> centrosDeVacunacion;
    private int idCont = 1;
    private float total =  22935533;
    private static CentroVacunacionController instance = null;
    private int contVacunasParciales;
    private int contVacunasCompletas;

    public static CentroVacunacionController getInstance() {
        if (instance == null)
            instance = new CentroVacunacionController();
        return instance;
    }

    private CentroVacunacionController() {
        centrosDeVacunacion = new HashMap<>();
        contVacunasParciales = 0;
        contVacunasCompletas = 0;
    }

    public void addNuevoCentro(String distrito, int vacunasParciales, int vacunasCompletas) {
        centrosDeVacunacion.put(idCont++, new CentroVacunacion(distrito,vacunasParciales,vacunasCompletas));
    }

    public CentroVacunacion getCentroById(int id) {
        if (!centrosDeVacunacion.containsKey(id)) return null;
        return centrosDeVacunacion.get(id);
    }

    public int getTotalCentros() {
        return idCont;
    }

    public int getVacunasParciales() {
        for (CentroVacunacion centro : centrosDeVacunacion.values()) {
            if (!centro.getisBaja()) {
                contVacunasParciales += centro.getVacunasParciales();
            }
        }
        return contVacunasParciales;
    }

    public int getVacunasCompletas() {
        for (CentroVacunacion centro : centrosDeVacunacion.values()) {
            if (!centro.getisBaja()) {
                contVacunasCompletas += centro.getVacunasCompletas();
            }
        }
        return contVacunasCompletas;
    }

    public float getAvance() {
        return Math.round((100.0f*100.0f*getVacunasParciales()+getVacunasCompletas())/total)/100.0f;
    }

    public float getCobertura() {
        return Math.round(100.0f*100.0f*getVacunasCompletas()/total)/100.0f;
    }
}