package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class Herramientas {

    // Solicitar número decimal
    public static double solicitarDouble(String mensaje) {
        boolean esValido = false;
        double valor = 0;
        while (!esValido) {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0); // Finaliza el programa si se cancela
                }
                valor = Double.parseDouble(entrada);
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0. Intente de nuevo.");
                } else {
                    esValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Intente de nuevo.");
            }
        }
        return valor;
    }

    // Solicitar numero entero
    public static int solicitarEntero(String mensaje) {
        boolean esValido = false;
        int valor = 0;
        while (!esValido) {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);

                }
                valor = Integer.parseInt(entrada);
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0. Intente de nuevo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    esValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido. Intente de nuevo.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return valor;
    }

    // Solcitiar Texto
    public static String solicitarTexto(String mensaje) {
        String texto = "";
        boolean esValido = false;

        while (!esValido) {
            texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Saliendo",
                        JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
            if (texto.trim().isEmpty()) { //
                JOptionPane.showMessageDialog(null, "El texto no puede estar vacío. Intente de nuevo.");
            } else {
                esValido = true;
            }
        }
        return texto;
    }

    // Mostrar mensajes
    public static void mostrarMensajes(String cMensaje, String cnombre, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cnombre, nIcono);

    }

    public static <T extends Enum<T>> T mostrarOpcionesConEnum(String mensaje, Class<T> opcionesEnum) {

        // Convertir los valores del enum en un arreglo de strings
        
        T[] valoresEnum = opcionesEnum.getEnumConstants();
        String[] opciones = new String[valoresEnum.length];

        for (int i = 0; i < valoresEnum.length; i++) {
            opciones[i] = valoresEnum[i].name();
        }

        // Mostrar el diálogo de opciones
        int seleccion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Seleccione una opción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Si el usuario no selecciona nada, devolvemos null
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return null;
        }

        // Devolver el valor correspondiente del enum
        return valoresEnum[seleccion];
    }

    public static LocalDate solicitarFecha() {
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate fecha = null;
    boolean esValido = false;

    while (!esValido) {
        try {
            String entrada =  Herramientas.solicitarTexto("Ingrese la fecha en formato dd/MM/yyyy");
            if (entrada == null || entrada.trim().isEmpty()) {
                Herramientas.mostrarMensajes("Operacion Cancelada", "Saliendo", 1);
                System.exit(0);
            }
            fecha = LocalDate.parse(entrada, formatoFecha);
            esValido = true; // Fecha válida, salir del bucle
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida. Asegúrese de usar el formato dd/MM/yyyy.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    return fecha;
}
}