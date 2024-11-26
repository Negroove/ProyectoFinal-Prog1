package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utils.Herramientas;

// Modelo Bug hereda de Incidencia
public class Bug extends Incidence {

    public enum Severidad {
        CRITICA, ALTA, MEDIA, BAJA
    }

    private Severidad severidad;
    private String moduloAfectado;
    private static int cantidadBug;

    // #region SETTERS Y GETTERS
    public Severidad getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public String getModuloAfectado() {
        return moduloAfectado;
    }

    public void setModuloAfectado(String moduloAfectado) {
        this.moduloAfectado = moduloAfectado;
    }

    public static int getCantidadBug() {
        return cantidadBug;
    }

    public static void setCantidadBug(int cantidadBug) {
        Bug.cantidadBug = cantidadBug;
    }

    // #endregion

    public Bug(int numeroId, String nombre, String descripcion, Estado estado, Prioridad prioridad,
            LocalDate fechaCreacion,
            LocalDate fechaFinalizacion, Severidad severidad, String moduloAfectado) {
        super(numeroId, nombre, descripcion, estado, prioridad, fechaCreacion, fechaFinalizacion);
        this.severidad = severidad;
        this.moduloAfectado = moduloAfectado;
        cantidadBug++;
    }

    public Bug() {
        cantidadBug++;
    }

    @Override
    public String getDetalle() {
        return "Bug ID: " + getNumeroId() + "\n" + "Nombre: " + getNombre() + "\n" + "Descripción: " + getDescripcion()
                + "\n" + "Estado: " + getEstado() + "\n" + "Prioridad: " + getPrioridad() + "\n" + "Fecha Creación: "
                + getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n"
                + "Fecha Finalización: pendiente"
                /* + getFechaFinalizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) */ + "\n" + "Severidad: "
                + getSeveridad() + "\n" + "Módulo Afectado: " + getModuloAfectado() + "\n";
    }

    @Override
    public void cargarDatos() {
        StringBuilder mensaje = new StringBuilder("Ingresá los datos del bug:\n\n");

        setNombre(Herramientas.solicitarTexto(mensaje.toString() + "\nNombre del responsable:"));
        mensaje.append("Nombre del responsable: ").append(getNombre()).append("\n");

        setSeveridad(Herramientas.mostrarOpcionesConEnum(mensaje.toString() + "\nSeleccione la severidad del bug:",
                Bug.Severidad.class));
        mensaje.append("Severidad: ").append(getSeveridad()).append("\n");

        setModuloAfectado(Herramientas.solicitarTexto(mensaje.toString() + "\nIngresá el módulo afectado:"));
        mensaje.append("Módulo afectado: ").append(getModuloAfectado()).append("\n");

        setDescripcion(Herramientas.solicitarTexto(mensaje.toString() + "\nIngresá la descripción del bug:"));
        mensaje.append("Descripción: ").append(getDescripcion()).append("\n");

        setEstado(Herramientas.mostrarOpcionesConEnum(mensaje.toString() + "\nSeleccioná el estado del bug:",
                Bug.Estado.class));
        mensaje.append("Estado: ").append(getEstado()).append("\n");

        setFechaCreacion(
                Herramientas.solicitarFecha(mensaje.toString() + "\nIngresá la fecha de creación (dd/MM/yyyy):"));
        mensaje.append("Fecha de creación: ")
                .append(getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

        setPrioridad(Herramientas.mostrarOpcionesConEnum(mensaje.toString() + "\nSeleccioná la prioridad del bug:",
                Bug.Prioridad.class));
        mensaje.append("Prioridad: ").append(getPrioridad()).append("\n");
    }

    @Override
    // Modificar incidencia por ID
    public void modificarDatos(int numeroId) {

    }

    @Override
    // Eliminar incidencia POR ID
    public void eliminarDatos(int numeroId) {

    }

    @Override
    // Mostrar datos de incidencia por ID
    public void mostrarDatos(int numeroId) {

    };

}
