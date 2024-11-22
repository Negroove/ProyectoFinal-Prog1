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

    public Bug(int numeroId, String titulo, String descripcion, Estado estado, Prioridad prioridad,
            LocalDate fechaCreacion,
            LocalDate fechaFinalizacion, Severidad severidad, String moduloAfectado) {
        super(numeroId, titulo, descripcion, estado, prioridad, fechaCreacion, fechaFinalizacion);
        this.severidad = severidad;
        this.moduloAfectado = moduloAfectado;
        cantidadBug++;
    }

    public Bug() {
        cantidadBug++;
    }

    @Override
    public String GetDetalle() {
        return "Bug ID: " + getNumeroId() + "\n" + "Titulo: " + getTitulo() + "\n" + "Descripción: " + getDescripcion()
                + "\n" + "Estado: " + getEstado() + "\n" + "Prioridad: " + getPrioridad() + "\n" + "Fecha Creación: "
                + getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n"
                + "Fecha Finalización: pendiente"
                /* + getFechaFinalizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) */ + "\n" + "Severidad: "
                + getSeveridad() + "\n" + "Módulo Afectado: " + getModuloAfectado() + "\n";
    }

    @Override
    public void cargarDatos() {
        setTitulo(Herramientas.solicitarTexto("Ingrese el titulo del bug: "));
        setSeveridad(Herramientas.mostrarOpcionesConEnum(
                "Seleccione la severidad del bug",
                Bug.Severidad.class));

        setModuloAfectado(Herramientas.solicitarTexto("Ingrese el módulo afectado: "));
        setDescripcion(Herramientas.solicitarTexto("Ingrese la descripción del bug: "));
        setEstado(Herramientas.mostrarOpcionesConEnum("Seleccione Estado",
                Bug.Estado.class));
        setFechaCreacion(Herramientas.solicitarFecha());
        setPriodidad(Herramientas.mostrarOpcionesConEnum("Seleccione la priodad", Bug.Prioridad.class));
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
