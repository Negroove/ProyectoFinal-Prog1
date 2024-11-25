package view;

import javax.swing.JOptionPane;

import service.BugTracker;

// Clase Principal
public class Main {
    public static void main(String[] args) {

        boolean continuar = true;

        while (continuar) {
            boolean seguir = true;
            String[] opciones = { "Crear Bug", "Listar bugs", "Modificar Bug", "Eliminar Bug", "Buscar Bug",
                    "Informes",
                    "Salir" };
            int selection = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?",
                    "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
                    opciones[0]);

            switch (selection) {
                case 0:
                    // crear algunos bugs
                    BugTracker.crearBug();
                    break;
                case 1:
                    // Listamos bugs
                    seguir = true;
                    while (seguir) {
                        String[] opcionesListar = { "Listar ordenados por fecha de creacion", "Listar ordenados por Id",
                                "Salir" };
                        int selectionListar = JOptionPane.showOptionDialog(null, "Qué tipo de búsqueda desea usar?",
                                "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                opcionesListar,
                                opcionesListar[0]);
                        switch (selectionListar) {
                            case 0:
                                BugTracker.listarBugsPorFechaAscendiente();
                                break;
                            case 1:
                                BugTracker.listarBugsPorId();
                            case 2:
                                seguir = false;
                                break;
                            default:
                                seguir = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    BugTracker.eliminarBug();
                    break;
                case 4:
                    seguir = true;
                    while (seguir) {
                        String[] opcionesBusqueda = { "Búsqueda por ID", "Búsqueda por título", "Búsqueda por estado",
                                "Búsqueda por severidad",
                                "Menú principal" };
                        int selectionBusqueda = JOptionPane.showOptionDialog(null, "Qué tipo de búsqueda desea usar?",
                                "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                opcionesBusqueda,
                                opcionesBusqueda[0]);

                        switch (selectionBusqueda) {
                            case 0:
                                BugTracker.buscarBugPorID();
                                break;
                            case 1:
                                BugTracker.buscarBugPorNombre();
                                break;
                            case 2:
                                BugTracker.buscarBugPorEstado();
                                break;
                            case 3:
                                BugTracker.buscarBugPorSeveridad();
                                break;
                            case 4:
                                seguir = false;
                                break;
                            default:
                                seguir = false;
                                break;
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }
}
