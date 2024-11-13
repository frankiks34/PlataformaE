package Negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Boleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoleta;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    private double monto;
    private String estadoPago; 
    private String paymentIntentId; 
    private String paymentMethodId; 

    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaTransaccion; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    private String descripcion; 
    private String returnUrl; 

    public Boleta() {
    
    }

    public Boleta(Estudiante estudiante, Curso curso, double monto, String estadoPago, 
                  String paymentIntentId, String paymentMethodId, Date fechaTransaccion,String descripcion, 
                 String returnUrl) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.monto = monto;
        this.estadoPago = estadoPago;
        this.paymentIntentId = paymentIntentId;
        this.paymentMethodId = paymentMethodId;
        this.fechaTransaccion = fechaTransaccion;
        this.descripcion = descripcion;
        this.returnUrl = returnUrl;
        this.fechaCreacion = new Date(); // Fecha actual
    }

  
    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
