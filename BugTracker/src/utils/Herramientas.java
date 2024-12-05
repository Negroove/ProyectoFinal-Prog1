package utils;

import java.io.IOException;
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
    public static int solicitarEntero(String mensaje) throws IOException {
        boolean esValido = false;
        int valor = 0;
        while (!esValido) {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    throw new IOException("Entrada de datos cancelada por el usuario.");
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
    public static String solicitarTexto(String mensaje) throws IOException {
        String texto = "";
        boolean esValido = false;

        while (!esValido) {
            texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null) {
                throw new IOException("Entrada de datos cancelada por el usuario.");
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

    // se declara parametro generico T para que solamente pueda ser usados en Enums
    public static <T extends Enum<T>> T mostrarOpcionesConEnum(String mensaje, Class<T> opcionesEnum) throws IOException {

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
                opciones[0]);

        // Si el usuario no selecciona nada, devolvemos null
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            throw new IOException("Entrada de datos cancelada por el usuario.");
        }

        // Devolver el valor correspondiente del enum
        return valoresEnum[seleccion];
    }

    public static LocalDate solicitarFecha(String mensaje) throws IOException {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;
        boolean esValido = false;

        while (!esValido) {
            try {
                String entrada = Herramientas.solicitarTexto(mensaje);
                if (entrada == null) {
                    throw new IOException();
                }
                if (entrada.trim().isEmpty()) { //
                    JOptionPane.showMessageDialog(null, "La fecha no puede estar vacía. Intente de nuevo.");
                }
                fecha = LocalDate.parse(entrada, formatoFecha);
                esValido = true; //  fecha valida, sale del bucle 
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Asegúrese de usar el formato dd/mm/yyyy.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fecha;
    }
}