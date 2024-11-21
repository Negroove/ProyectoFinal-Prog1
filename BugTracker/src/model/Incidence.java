package model;

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
    private String titulo;
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
        this.numeroId = cantidadIncidencias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public void setPriodidad(Prioridad prioridad) {
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

    public Incidence(int numeroId, String titulo, String descripcion, Estado estado, Prioridad prioridad,
            LocalDate fechaCreacion,
            LocalDate fechaFinalizacion) {
        this.numeroId = numeroId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = fechaFinalizacion;
        cantidadIncidencias++;
        setId();
    }

    public Incidence() {
        cantidadIncidencias++;
    }

    public abstract String GetDetalle();

    // Cargar incidencia con sus datos
    public abstract void cargarDatos();

    // Modificar incidencia por ID
    public abstract void modificarDatos(int numeroId);

    // Eliminar incidencia POR ID
    public abstract void eliminarDatos(int numeroId);

    // Mostrar datos de incidencia por ID
    public abstract void mostrarDatos(int numeroId);

}
