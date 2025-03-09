package Clases;
import java.util.*;
public class Empresa extends Object {
    
    private String nombre;
    private Date fechaIncorporacion;
    private double facturacionAnual;
    private int numeroVendedoresEmpleados;
    private ArrayList<String> pais;
    private ArrayList<String> sede;
    private ArrayList<String> ciudad;
    private ArrayList<String> area;
    private ArrayList<String> asesor;
    
    public Empresa(){
        
    }
    
    public Empresa(String nombre, Date fechaIncorporacion, double facturacionAnual, int numeroVendedoresEmpleados, ArrayList<String> pais, ArrayList<String> sede, ArrayList<String> ciudad,ArrayList<String> area,
    ArrayList<String> asesor ) {
        this.nombre = nombre;
        this.fechaIncorporacion = fechaIncorporacion;
        this.facturacionAnual = facturacionAnual;
        this.numeroVendedoresEmpleados = numeroVendedoresEmpleados;
        this.pais = new ArrayList<>(pais);
        this.sede = new ArrayList<>(sede);
        this.ciudad = new ArrayList<>(ciudad);
        this.area = new ArrayList<>(area);
        this.asesor = new ArrayList<>(asesor);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public double getFacturacionAnual() {
        return facturacionAnual;
    }

    public void setFacturacionAnual(double facturacionAnual) {
        this.facturacionAnual = facturacionAnual;
    }

    public int getNumeroVendedoresEmpleados() {
        return numeroVendedoresEmpleados;
    }

    public void setNumeroVendedoresEmpleados(int numeroVendedoresEmpleados) {
        this.numeroVendedoresEmpleados = numeroVendedoresEmpleados;
    }

    public ArrayList<String> getPais() {
        return pais;
    }

    public void setPais(ArrayList<String> pais) {
        this.pais = pais;
    }

    public void agregarPaises(String pais){
        if (!this.pais.contains(pais)) {
            this.pais.add(pais);
        }
    }

    public ArrayList<String> getSede() {
        return sede;
    }

    public void setSede(ArrayList<String> sede) {
        this.sede = sede;
    }

    public void agregarSede(String sede){
        if (!this.sede.contains(sede)) {
            this.sede.add(sede);
        }
    }

    public ArrayList<String> getCiudad(){
        return ciudad;
    }

    public void setCiudad(ArrayList<String> ciudad){
        this.ciudad = ciudad;
    }

    public void agregarCiudad(String ciudad){
        if (!this.ciudad.contains(ciudad)) {
            this.ciudad.add(ciudad);
        }
    }


    public void agregarArea(String area) {
        if (!this.area.contains(area)) {
            this.area.add(area);
        }
    }

    public ArrayList<String> getArea() {
        return area;
    }

    public void setArea(ArrayList<String> areas) {
        this.area = areas;
    }

    public ArrayList<String> getAsesor() {
        return asesor;
    }

    public void setAsesor(ArrayList<String> asesor) {
        this.asesor = asesor;
    }

    public void añadirAsesor(String asesor){
        if (!this.asesor.contains(asesor)) {
            this.asesor.add(asesor);
        }
    }

    @Override
    public String toString(){
        return "Empresa: " + nombre +
        " | Facturación anual: " + facturacionAnual +
        " | Número de empleados: " + numeroVendedoresEmpleados +
        " | Sede: " + String.join(", ", sede) +
        " | Ciudad: " + String.join(", ", ciudad);
    }
}