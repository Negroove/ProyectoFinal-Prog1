package service;

import javax.swing.JOptionPane;

import model.Bug;
import utils.Herramientas;

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
    // buscar bugs por nombre 

    public static void buscarBugsPorTitulo(){
        boolean encontrado = false ;
        if (bugs.length == 0){
            Herramientas.mostrarMensajes("No hay incidencias o bugs cargados","Error",0);
        }else{
            String nombreBug = Herramientas.solicitarTexto("Ingrese el nombre del bug a buscar");
            StringBuilder bugEncontrado = new StringBuilder("Bug encontrados:\n");

            for (int i = 0; i < bugs.length; i++) {
                if (bugs[i] != null && bugs[i].getTitulo().contains(nombreBug.toLowerCase())) {
                    bugEncontrado.append(bugs[i].GetDetalle()).append("\n");
                    encontrado = true;
                }
            }
            if (encontrado) {
                Herramientas.mostrarMensajes(bugEncontrado.toString(), "Bugs encontrados", 1);
            }
            else{
                Herramientas.mostrarMensajes("No se ha encontrado el bug con el titulo: " + nombreBug, "Error al buscar", 0);
            }
        }
    }
    // ordenar bugs por prioridad o fecha de creacion
    // modificar bug, titulo, descripcion, prioridad o estado, solicitar ID del bug
    // a modificar
    // eliminar bug, solicitar ID del bug a eliminar
    // generar informe de bugs, mostrar cantidad de bugs, cantidad de bugs por
    // estado, cantidad de bugs por prioridad
}
