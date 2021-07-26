package main;

import java.util.HashMap;

public class CentroVacunacionManager {
    HashMap<Integer, CentroVacunacion> centrosDeVacunacion;
    private int idCont = 1;
    private static CentroVacunacionManager instance = null;

    public static CentroVacunacionManager getInstance()
    {
        if (instance == null)
            instance = new CentroVacunacionManager();
        return instance;
    }

    private CentroVacunacionManager() {
        centrosDeVacunacion = new HashMap<>();
    }

    public void addNuevoCentro(String distrito) {
        centrosDeVacunacion.put(idCont++, new CentroVacunacion(distrito));
    }

    public CentroVacunacion getCentroById(int id) {
        if (!centrosDeVacunacion.containsKey(id)) return null;
        return centrosDeVacunacion.get(id);
    }

    public int getCont() {
        return idCont;
    }

    public int getVacunasParciales() {
        int cont = 0;
        for (CentroVacunacion centro : centrosDeVacunacion.values()) {
            if (!centro.getisBaja()) {
                cont += centro.getVacunasParciales();
            }
        }
        return cont;
    }

    public int getVacunasCompletas() {
        int cont = 0;
        for (CentroVacunacion centro : centrosDeVacunacion.values()) {
            if (!centro.getisBaja()) {
                cont += centro.getVacunasCompletas();
            }
        }
        return cont;
    }
}