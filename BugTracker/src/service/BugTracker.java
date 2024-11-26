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
                lista.append(bugs[i].getDetalle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista);
        }
    }

    // #region Métodos buscadores
    // buscar bugs por ID
    public static Bug buscarBugPorID() {
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder buscar luego.",
                    "Error", 0);
            return null;
        }
        int iDingresado = Herramientas.solicitarEntero("Ingresá el ID (Número entero)");
        int inicio = 0;
        int fin = cantidadBugs - 1;

        while (inicio <= fin) {
            int centro = (inicio + fin) / 2;

            if (iDingresado < bugs[centro].getNumeroId()) {
                fin = centro - 1;
            } else if (iDingresado > bugs[centro].getNumeroId()) {
                inicio = centro + 1;
            } else {
                Herramientas.mostrarMensajes("Bug encontrado: \n" + "\n" + bugs[centro].getDetalle(),
                        "Búsqueda por ID", 1);
                return bugs[centro];
            }
        }
        Herramientas.mostrarMensajes("Bug no encontrado", "Búsqueda por ID", 0);
        return null;
    }

    // buscar bugs por título
    public static void buscarBugPorNombre() {
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados.", "Error", 0);
            return;
        }

        String nombreBuscado = Herramientas.solicitarTexto("Ingresá el nombre del bug que buscas").toLowerCase();
        StringBuilder nombresEncontrados = new StringBuilder("Coincidencias encontradas:\n");

        boolean encontrado = false;
        for (int i = 0; i < cantidadBugs; i++) {
            if (bugs[i].getNombre().toLowerCase().contains(nombreBuscado)) {
                nombresEncontrados.append(bugs[i].getDetalle()).append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            Herramientas.mostrarMensajes(nombresEncontrados.toString(), "Búsqueda por título", 1);
        } else {
            Herramientas.mostrarMensajes("No se ha encontrado ninguna coincidencia con: " + nombreBuscado,
                    "Búsqueda por título", 0);
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
                    estadosEncontrados.append(bugs[i].getDetalle()).append("\n");
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
                    severidadEncontrados.append(bugs[i].getDetalle()).append("\n");
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

    // #region Métodos Ordenadores
    // Listar bugs ordenados por fecha de creacion
    public static void listarBugsPorFechaAscendiente() {
        StringBuilder sb = new StringBuilder("Bugs ordenados por fecha: \n");
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados.", "Error", 0);
            return;
        }

        // Bubble sort basado en fecha de creación
        for (int i = 0; i < cantidadBugs - 1; i++) {
            for (int j = 0; j < cantidadBugs - 1 - i; j++) {
                if (bugs[j].getFechaCreacion().isAfter(bugs[j + 1].getFechaCreacion())) {
                    Bug temp = bugs[j];
                    bugs[j] = bugs[j + 1];
                    bugs[j + 1] = temp;
                }
            }
        }

        // Construir la lista de bugs ordenados
        for (int i = 0; i < cantidadBugs; i++) {
            sb.append(bugs[i].getDetalle()).append("\n");
        }

        Herramientas.mostrarMensajes(sb.toString(), "Bugs ordenados por fecha", 1);
    }

    public static void listarBugsPorId() {
        StringBuilder sb = new StringBuilder("Bugs ordenados por ID: \n");
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados.", "Error", 0);
            return;
        }

        for (int i = 0; i < cantidadBugs - 1; i++) {
            for (int j = 0; j < cantidadBugs - 1 - i; j++) {
                if (bugs[j].getNumeroId() > bugs[j + 1].getNumeroId()) {
                    Bug temp = bugs[j];
                    bugs[j] = bugs[j + 1];
                    bugs[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < cantidadBugs; i++) {
            sb.append(bugs[i].getDetalle()).append("\n");
        }

        Herramientas.mostrarMensajes(sb.toString(), "Bugs ordenados por ID", 1);
    }
    // #endregion

    // modificar bug, nombre, descripcion, prioridad o estado, solicitar ID del bug
    // a modificar

    public static Bug modificarBug() {
        if (cantidadBugs == 0) {
            Herramientas.mostrarMensajes("No hay bugs registrados, asegurate de registrar para poder modificar luego.",
                    "Error", 0);
            return null;
        }
        int iDingresado = Herramientas.solicitarEntero("Ingresá el ID del bug que desea modificar (Número entero)");
        int inicio = 0;
        int fin = cantidadBugs - 1;
        boolean seguir = true;

        while (inicio <= fin) {
            int centro = (inicio + fin) / 2;

            if (iDingresado < bugs[centro].getNumeroId()) {
                fin = centro - 1;
            } else if (iDingresado > bugs[centro].getNumeroId()) {
                inicio = centro + 1;
            } else {
                /*
                 * Herramientas.mostrarMensajes("Bug encontrado: \n" + "\n" +
                 * bugs[centro].getDetalle(),
                 * "Búsqueda por ID", 1);
                 */
                // Modificar bug
                while (seguir) {
                    String[] opcionesModificar = { "Modificar nombre", "Modificar descripción", "Modificar prioridad",
                            "Modificar estado", "Menú principal" };
                    int selectionModificar = JOptionPane.showOptionDialog(null,
                            "¿Qué desea modificar?\n\n" + bugs[centro].getDetalle(),
                            "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            opcionesModificar,
                            opcionesModificar[0]);
                    switch (selectionModificar) {
                        case 0:
                            String nuevoNombre = Herramientas.solicitarTexto("Ingresá el nuevo nombre del bug");
                            bugs[centro].setNombre(nuevoNombre);
                            Herramientas.mostrarMensajes("Nombre modificado con éxito.\n\n" + bugs[centro].getDetalle(),
                                    "Modificación de Bug", 1);
                            return bugs[centro];

                        case 1:
                            String nuevaDescripcion = Herramientas
                                    .solicitarTexto("Ingresá la nueva descripción del bug");
                            bugs[centro].setDescripcion(nuevaDescripcion);
                            Herramientas.mostrarMensajes(
                                    "Descripción modificada con éxito.\n\n" + bugs[centro].getDetalle(),
                                    "Modificación de Bug", 1);
                            return bugs[centro];
                        case 2:
                            Bug.Prioridad nuevaPrioridad = Herramientas.mostrarOpcionesConEnum(
                                    "Seleccione la nueva prioridad del bug:",
                                    Bug.Prioridad.class);
                            bugs[centro].setPrioridad(nuevaPrioridad);
                            Herramientas.mostrarMensajes(
                                    "Prioridad modificada con éxito.\n\n" + bugs[centro].getDetalle(),
                                    "Modificación de Bug", 1);
                            return bugs[centro];
                        case 3:
                            Bug.Estado nuevoEstado = Herramientas.mostrarOpcionesConEnum(
                                    "Seleccione el nuevo estado del bug:",
                                    Bug.Estado.class);
                            bugs[centro].setEstado(nuevoEstado);
                            Herramientas.mostrarMensajes("Estado modificado con éxito.\n\n" + bugs[centro].getDetalle(),
                                    "Modificación de Bug", 1);
                            return bugs[centro];
                        case 4:
                            seguir = false;
                            break;
                        default:
                            seguir = false;
                            break;
                    }
                }
                return null;
            }
        }
        Herramientas.mostrarMensajes("Bug no encontrado", "Búsqueda por ID", 0);
        return null;
    }

    // eliminar bug
    public static void eliminarBug() {
        Bug eliminar = buscarBugPorID();
        if (eliminar == null) {
            // buscarBugPorID() ya proporciona advertencia en caso de no existir registros.
            return;
        }

        // encontramos el indice que queremos eliminar
        int index = -1;
        for (int i = 0; i < cantidadBugs; i++) {
            if (bugs[i] == eliminar) {
                index = i;
                break;
            }
        }

        // validamos si el bug fué encontrado
        if (index == -1) {
            Herramientas.mostrarMensajes("Bug no encontrado.", "Error al eliminar", 0);
            return;
        }

        // movemos los espacios hacia la izquierda ya que si lo dejo en null me queda un
        // espacio vacio
        for (int i = index; i < cantidadBugs - 1; i++) {
            bugs[i] = bugs[i + 1];
        }
        bugs[cantidadBugs - 1] = null; // Borrar el último elemento
        cantidadBugs--;

        Herramientas.mostrarMensajes("Bug eliminado con éxito.", "Eliminación de Bug", 1);
    }
    // generar informe de bugs, mostrar cantidad de bugs, cantidad de bugs por
    // estado, cantidad de bugs por prioridad
}
