package view;

import javax.swing.JOptionPane;

import service.BugTracker;
import model.Bug;

// Clase Principal
public class Main {
    public static void main(String[] args) {
        // crear algunos bugs
        BugTracker.crearBug();
        // mostrar cantidad de bugs
        JOptionPane.showMessageDialog(null, "Cantidad de bugs: " + Bug.getCantidadBug());
        // mostrar datos de los bugs
        for (int i = 0; i < BugTracker.cantidadBugs; i++) {
            JOptionPane.showMessageDialog(null, BugTracker.bugs[i].GetDetalle());
        }

    }
}
