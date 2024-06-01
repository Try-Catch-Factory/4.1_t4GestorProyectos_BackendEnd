package project_management.security.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    private Date fechaInicio;

    private Date fechaFinPrevista;

    private String prioridad;

    // Constructor vacío
    public Tarea() {
    }

    // Constructor con parámetros
    public Tarea(String nombre, String descripcion, EstadoTarea estado, Date fechaInicio, Date fechaFinPrevista, String prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFinPrevista = fechaFinPrevista;
        this.prioridad = prioridad;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinPrevista() {
        return fechaFinPrevista;
    }

    public void setFechaFinPrevista(Date fechaFinPrevista) {
        this.fechaFinPrevista = fechaFinPrevista;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}

enum EstadoTarea {
    PENDIENTE, EN_PROGRESO, COMPLETADA
}
