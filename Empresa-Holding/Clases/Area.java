package Clases;
public class Area extends Object {
    private String nombre;
    private String descripcion;


    public Area(){

    }

    public Area(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
