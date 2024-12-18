package model;

import java.io.IOException;
import java.time.LocalDate;

// Modelo Incidencia 
public abstract class Incidence {
    public enum Estado {
        ABIERTA,
        EN_PROCESO,
        CERRADA
    }

    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    private int numeroId;
    private String nombre;
    private String descripcion;
    private Estado estado;
    private Prioridad prioridad;
    private LocalDate fechaCreacion;
    private LocalDate fechaFinalizacion;
    private static int cantidadIncidencias;

    // #region SETTERS Y GETTERS
    public int getNumeroId() {
        return numeroId;
    }

    public void setId() {
        this.numeroId = ++cantidadIncidencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    // #endregion

    public Incidence(String nombre, String descripcion, Estado estado, Prioridad prioridad, LocalDate fechaCreacion) {
        setId();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = null; // No definida inicialmente
    }

    public Incidence(){
        
    }

    public abstract String getDetalle();

    // Cargar incidencia con sus datos
    public abstract void cargarDatos() throws IOException;

}
