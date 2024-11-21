package service;

import javax.swing.JOptionPane;

import model.Bug;

// Logica / Reglas de Negocio

public class BugTracker {
    public static Bug[] bugs = new Bug[100];
    public static int cantidadBugs = 0;

    // crear bug
    public static Bug crearBug() {

        Bug bug = new Bug();
        bug.setId();
        bug.cargarDatos();
        bugs[cantidadBugs] = bug;
        cantidadBugs++;
        return bug;

    }

    // listar bugs mostrando una lista general con los datos de cada uno
    public static void listarBugs() {
        StringBuilder lista = new StringBuilder("Lista de bugs: \n" + "\n");
        for (int i = 0; i < cantidadBugs; i++) {
            lista.append(bugs[i].GetDetalle()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    // buscar bugs por ID o por estado
    // ordenar bugs por prioridad o fecha de creacion
    // modificar bug, titulo, descripcion, prioridad o estado, solicitar ID del bug
    // a modificar
    // eliminar bug, solicitar ID del bug a eliminar
    // generar informe de bugs, mostrar cantidad de bugs, cantidad de bugs por
    // estado, cantidad de bugs por prioridad
}
