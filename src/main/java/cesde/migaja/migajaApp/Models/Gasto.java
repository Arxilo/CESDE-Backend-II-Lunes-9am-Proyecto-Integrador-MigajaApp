package cesde.migaja.migajaApp.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private Double monto;
    @Column(length = 255)
    private String imagen;
    @Column(nullable = false, length = 20)
    private String moneda;
    @Column(length = 150)
    private String lugar;
    @Column(nullable = false)
    private Boolean esRecurrente;
    @Column(nullable = false, length = 50)
    private String tipoGasto;
    @Column(nullable = false)
    private Integer impactoFinanciero;
    @Column(nullable = false)
    private Boolean activo;
    @Column(length = 300)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "comercio_id", referencedColumnName = "id")
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "medio_pago_id", referencedColumnName = "id")
    private MedioPago medioPago;

    public Gasto() {
    }



    public Gasto(Integer id, String descripcion, LocalDate fecha, Double monto, String imagen, String moneda,
            String lugar, Boolean esRecurrente, String tipoGasto, Integer impactoFinanciero,
            Boolean activo, String observaciones) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
        this.imagen = imagen;
        this.moneda = moneda;
        this.lugar = lugar;
        this.esRecurrente = esRecurrente;
        this.tipoGasto = tipoGasto;
        this.impactoFinanciero = impactoFinanciero;
        this.activo = activo;
        this.observaciones = observaciones;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public LocalDate getFecha() {
        return fecha;
    }



    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    public Double getMonto() {
        return monto;
    }



    public void setMonto(Double monto) {
        this.monto = monto;
    }



    public String getImagen() {
        return imagen;
    }



    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    public String getMoneda() {
        return moneda;
    }



    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }



    public String getLugar() {
        return lugar;
    }



    public void setLugar(String lugar) {
        this.lugar = lugar;
    }



    public Boolean getEsRecurrente() {
        return esRecurrente;
    }



    public void setEsRecurrente(Boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }



    public String getTipoGasto() {
        return tipoGasto;
    }



    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }



    public Integer getImpactoFinanciero() {
        return impactoFinanciero;
    }



    public void setImpactoFinanciero(Integer impactoFinanciero) {
        this.impactoFinanciero = impactoFinanciero;
    }



    public Boolean getActivo() {
        return activo;
    }



    public void setActivo(Boolean activo) {
        this.activo = activo;
    }



    public String getObservaciones() {
        return observaciones;
    }



    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

}
