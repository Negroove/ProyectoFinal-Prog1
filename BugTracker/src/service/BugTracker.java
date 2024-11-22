package service;

import javax.swing.JOptionPane;

import model.Bug;
import model.Bug.Severidad;
import model.Incidence.Estado;
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
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder listar luego.",
                    "Error", 0);
        } else {
            for (int i = 0; i < cantidadBugs; i++) {
                lista.append(bugs[i].GetDetalle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista);
        }
    }

    // #region Métodos buscadores
    // buscar bugs por ID
    public static void buscarBugPorID() {
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder buscar luego.",
                    "Error", 0);
        } else {
            int iDingresado = Herramientas.solicitarEntero("Ingresá el ID (Número entero)");
            int inicio = 0;
            int fin = cantidadBugs - 1; // Adjust to the number of registered bugs

            while (inicio <= fin) {
                int centro = (inicio + fin) / 2;

                if (iDingresado < bugs[centro].getNumeroId()) {
                    fin = centro - 1;
                } else if (iDingresado > bugs[centro].getNumeroId()) {
                    inicio = centro + 1;
                } else {
                    Herramientas.mostrarMensajes("Bug encontrado: \n" + "\n" + bugs[centro].GetDetalle(),
                            "Búsqueda por ID", 1);
                    return; // Exit the method once the bug is found
                }
            }
            Herramientas.mostrarMensajes("Bug no encontrado", "Búsqueda por ID", 0);
        }
    }

    // buscar bugs por título
    public static void buscarBugPorTitulo() {
        boolean encontrado = false;
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder buscar luego.",
                    "Error", 0);
        } else {
            String tituloBuscado = Herramientas.solicitarTexto("Ingresá el título del bug que buscas");
            StringBuilder titulosEncontrados = new StringBuilder("Coincidencias encontradas:\n" + "\n");
            for (int i = 0; i < cantidadBugs; i++) {
                if (bugs[i].getTitulo().contains(tituloBuscado.toLowerCase())) {
                    titulosEncontrados.append(bugs[i].GetDetalle()).append("\n");
                    encontrado = true;
                }
            }
            if (encontrado) {
                Herramientas.mostrarMensajes(titulosEncontrados.toString(), "Búsqueda por título", 1);
            } else {
                Herramientas.mostrarMensajes(
                        "No se ha encontrado ninguna coincidencia de título con la palabra: " + tituloBuscado,
                        "Búsqueda por título", 1);
            }
        }
    }

    // buscar bugs por estado
    public static void buscarBugPorEstado() {
        boolean encontrado = false;
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder buscar luego.",
                    "Error", 0);
        } else {
            StringBuilder estadosEncontrados = new StringBuilder("Coincidencias encontradas:\n" + "\n");
            Estado estadoBuscado = Herramientas.mostrarOpcionesConEnum(
                    "Seleccione el estado con el que desea filtrar: ",
                    Bug.Estado.class);
            for (int i = 0; i < cantidadBugs; i++) {
                if (bugs[i].getEstado() == estadoBuscado) {
                    estadosEncontrados.append(bugs[i].GetDetalle()).append("\n");
                    encontrado = true;
                }
            }
            if (encontrado) {
                Herramientas.mostrarMensajes(estadosEncontrados.toString(), "Búsqueda por estado", 1);
            } else {
                Herramientas.mostrarMensajes(
                        "No hay bugs registrados con estado " + estadoBuscado,
                        "Búsqueda por estado", 0);
            }
        }
    }

    // buscar bugs por severidad
    public static void buscarBugPorSeveridad() {
        boolean encontrado = false;
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder buscar luego.",
                    "Error", 0);
        } else {
            StringBuilder severidadEncontrados = new StringBuilder("Coincidencias encontradas:\n" + "\n");
            Severidad severidadBuscada = Herramientas.mostrarOpcionesConEnum(
                    "Seleccione la severidad con la que desea filtrar: ",
                    Bug.Severidad.class);
            for (int i = 0; i < cantidadBugs; i++) {
                if (bugs[i].getSeveridad() == severidadBuscada) {
                    severidadEncontrados.append(bugs[i].GetDetalle()).append("\n");
                    encontrado = true;
                }
            }
            if (encontrado) {
                Herramientas.mostrarMensajes(severidadEncontrados.toString(), "Búsqueda por severidad", 1);
            } else {
                Herramientas.mostrarMensajes(
                        "No hay bugs registrados con severidad " + severidadBuscada,
                        "Búsqueda por estado", 0);
            }
        }
    }
    // #endregion

    // ordenar bugs por prioridad o fecha de creacion
    // modificar bug, titulo, descripcion, prioridad o estado, solicitar ID del bug
    // a modificar
    // eliminar bug, solicitar ID del bug a eliminar
    // generar informe de bugs, mostrar cantidad de bugs, cantidad de bugs por
    // estado, cantidad de bugs por prioridad
}
