package Clases;
import java.util.*;

public class Asesor extends Object {
    
    private String codigo;
    private String nombre;
    private String titulacion;
    private String direccion;
    private ArrayList<String> area;
    private ArrayList<String> empresas;
    private ArrayList<Date> fechaContrato;
    
    public Asesor(){
        
    }

    public Asesor(String codigo, String nombre, String titulacion, String direccion, ArrayList<String> area, ArrayList<String> empresas, ArrayList<Date> fechaContrato) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulacion = titulacion;
        this.direccion = direccion;
        this.area = new ArrayList<>(area);
        this.empresas = new ArrayList<>(empresas);
        this.fechaContrato = new ArrayList<>(fechaContrato);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getArea() {
        return area;
    }

    public void setArea(ArrayList<String> area) {
        this.area = area;
    }

    public void agregarArea(String area){
        if (!this.area.contains(area)) {
            this.area.add(area);
        }
    }

    public ArrayList<String> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<String> empresas) {
        this.empresas = empresas;
    }

    public ArrayList<Date> getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(ArrayList<Date> fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public void agregarEmpresa(String empresa){
        if (!this.empresas.contains(empresa)) {
            this.empresas.add(empresa);
        }
    }

    public void añadirFechaContrato(Date fechaContrato){
        if (!this.fechaContrato.contains(fechaContrato)) {
            this.fechaContrato.add(fechaContrato);
        }
    }



}