package Clases;
import java.util.*;

public class Vendedor extends Object {

    private Date fechaReclutamiento;
    private String codigo;
    private String nombre;
    private String direccion;
    private boolean rango;
    private String empresa;
    private int numeroVentas;
    private double volumenFacturacion;


    public Vendedor(){

    }

    public Vendedor(Date fechaReclutamiento, String codigo, String nombre, String direccion, Boolean rango, String empresa, int numeroVentas, double volumenFacturacion){
        this.fechaReclutamiento = fechaReclutamiento;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rango = rango;
        this.empresa = empresa;
        this.numeroVentas = numeroVentas;
        this.volumenFacturacion = volumenFacturacion;
    }

    public Date getFechaReclutamiento(){
        return fechaReclutamiento;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setFechaReclutamiento(Date fechaReclutamiento) {
        this.fechaReclutamiento = fechaReclutamiento;
    }

    public boolean getRango() {
        return rango;
    }

    public void setRango(boolean rango) {
        this.rango = rango;
    }

    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    public double getVolumenFacturacion() {
        return volumenFacturacion;
    }

    public void setVolumenFacturacion(double volumenFacturacion) {
        this.volumenFacturacion = volumenFacturacion;
    }

    @Override
    public String toString(){
        return "| Nombre del vendedor : " + nombre +
         " | Fecha de registro : " +  fechaReclutamiento + 
         " | Código : " +  codigo + 
         " | Dirección : " + direccion 
         + "\n¿Tiene rango? " + rango +
         "\nRendimiento \n| Empresa: " + empresa +
         " | Número de ventas: " + numeroVentas +
         " | Volumen de facturación: " + volumenFacturacion;
    }
}
