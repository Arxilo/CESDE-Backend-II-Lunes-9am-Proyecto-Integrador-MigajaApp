package cesde.migaja.migajaApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import cesde.migaja.migajaApp.Models.utils.Prioridad;
import cesde.migaja.migajaApp.Models.utils.Estado;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "Categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false, length = 100)
    private String responsable;

    @Column(length = 255)
    private String justificacion;

    @Column(length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridad prioridad;

    @Column(length = 20)
    private String color;

    @Column(length = 50)
    private String icono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;


    @OneToMany(mappedBy = "categoria")
    private List<Gasto> gastos;

    // Constructor vacío
    public CategoriaModel() {
    }

    // Constructor lleno
    public CategoriaModel(String nombre, LocalDate fechaCreacion,
    String responsable, String justificacion,
    String descripcion, Prioridad prioridad,
    String color, String icono,
    Estado estado) {

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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}