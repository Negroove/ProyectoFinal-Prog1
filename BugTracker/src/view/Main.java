package view;

import javax.swing.JOptionPane;

import service.BugTracker;
import model.Bug;

// Clase Principal
public class Main {
    public static void main(String[] args) {

        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"Crear Bug", "Listar Bug", "Modificar Bug", "Eliminar Bug", "Buscar Bug", "Informes", "Salir"};
            int selection = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?",
                    "BugTracker", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
                    opciones[0]);

            switch (selection) {
                case 0:
                    // crear algunos bugs
                    BugTracker.crearBug();
                    break;
                case 1:
                    BugTracker.listarBugs();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

            }
        }
    }
}
