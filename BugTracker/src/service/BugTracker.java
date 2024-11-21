package service;

import model.Bug;

// Logica / Reglas de Negocio
// permitir al usuario crear un bug
public class BugTracker {
    public static Bug[] bugs = new Bug[100];
    public static int cantidadBugs = 0;

    public static Bug crearBug() {

        Bug bug = new Bug();
        bug.setId();
        bug.cargarDatos();
        bugs[cantidadBugs] = bug;
        cantidadBugs++;
        return bug;

    }

}
