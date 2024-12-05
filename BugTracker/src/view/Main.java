package view;

import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Bug;
import service.BugTracker;

// Clase Principal
public class Main {

    // Método para crear bugs de ejemplo al inicio
    private static void inicializarBugsEjemplo() {
        // Crear algunos bugs de prueba con todos los parámetros del constructor
        Bug bug1 = new Bug("Lucas", "Descripción del bug 1", Bug.Estado.ABIERTA, Bug.Prioridad.MEDIA, LocalDate.now(),
                Bug.Severidad.BAJA, "Modulo de inicio");
        Bug bug2 = new Bug("Carlos", "Descripción del bug 2", Bug.Estado.EN_PROCESO, Bug.Prioridad.ALTA, LocalDate.now(),
                Bug.Severidad.ALTA, "Modulo de autenticación");
        Bug bug3 = new Bug("David", "Descripción del bug 3", Bug.Estado.CERRADA, Bug.Prioridad.BAJA, LocalDate.now(),
                Bug.Severidad.MEDIA, "Modulo de base de datos");

        // Asignar los bugs al arreglo en BugTracker
        BugTracker.bugs[0] = bug1;
        BugTracker.bugs[1] = bug2;
        BugTracker.bugs[2] = bug3;
        BugTracker.cantidadBugs = 3;
    }

    public static void main(String[] args) throws IOException {
        inicializarBugsEjemplo();

        boolean continuar = true;

        while (continuar) {
            boolean seguir = true;
            String[] opciones = {"Crear Bug", "Listar bugs", "Modificar Bug", "Eliminar Bug", "Buscar Bug",
                "Informes",
                "Salir"};
            int selection = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?",
                    "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
                    opciones[0]);
            try {
                switch (selection) {
                    case 0 -> // crear algunos bugs
                        BugTracker.crearBug();
                    // mostrar inmediatamente el bug creado
                    case 1 -> {
                        // Listamos bugs
                        seguir = true;
                        while (seguir) {
                            String[] opcionesListar = {"Listar ordenados por fecha de creación", "Listar ordenados por ID",
                                "Menú Principal"};
                            int selectionListar = JOptionPane.showOptionDialog(null, "¿Como desea listar los registros?",
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
                    }
                    case 2 ->
                        BugTracker.modificarBug();
                    case 3 ->
                        BugTracker.eliminarBug();
                    case 4 -> {
                        seguir = true;
                        while (seguir) {
                            String[] opcionesBusqueda = {"Búsqueda por ID", "Búsqueda por responsable", "Búsqueda por estado",
                                "Búsqueda por severidad",
                                "Menú principal"};
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
                    }
                    case 5 -> {
                        seguir = true;
                        while (seguir) {
                            String[] opcioneInforme = {"Informe por estado", "Informe por responsables", "Informe por severidad",
                                "Menú principal"};
                            int seleccionInforme = JOptionPane.showOptionDialog(null, "Qué tipo de informe desea generar?",
                                    "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                    opcioneInforme,
                                    opcioneInforme[0]);

                            switch (seleccionInforme) {
                                case 0:
                                    BugTracker.generarInformePorEstado();
                                    break;
                                case 1:
                                    BugTracker.generarInformePorNombre();
                                    break;
                                case 2:
                                    BugTracker.generarInformePorSeveridad();
                                    break;
                                case 3:
                                    seguir = false;
                                    break;
                                default:
                                    seguir = false;
                                    break;
                            }
                        }
                    }
                    case 6 -> {
                        JOptionPane.showMessageDialog(null, "Saliendo del programa");
                        continuar = false;
                    }
                    default ->
                        continuar = false;
                }
            } catch (IOException e) {

            }
        }
    }
}
