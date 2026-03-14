package cesde.migaja.migajaApp.Models;

import cesde.migaja.migajaApp.Models.utlis.Color;
import cesde.migaja.migajaApp.Models.utlis.Icono;
import cesde.migaja.migajaApp.Models.utlis.Prioridad;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String fechaCreacion;
    private String responsable;
    private String justificacion;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Icono icono;

    private Boolean estado;

    // Constructor vacío  
    public categoria() {
    }

    // Constructor lleno
    
    public categoria(Integer id, String nombre, String fechaCreacion, String responsable,
        String justificacion, String descripcion, Prioridad prioridad,
        Color color, Icono icono, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.color = color;
        this.icono = icono;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getPrioridad() { 
        return prioridad; 
    }

    public void setPrioridad(Prioridad prioridad) {
         this.prioridad = prioridad; 
    }

    public Color getColor() {
         return color; 
    }

    public void setColor(Color color) {
         this.color = color; 
    }

    public Icono getIcono() { 
        return icono; 
    }

    public void setIcono(Icono icono) { 
        this.icono = icono; 
    }

    public Boolean getEstado() {
    return estado;
    }

    public void setEstado(Boolean estado) {
    this.estado = estado;
    }

}



    