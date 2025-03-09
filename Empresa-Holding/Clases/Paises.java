package Clases;
public class Paises extends Object {
    private String nombre;
    private double PIB;
    private Long poblacion;
    private String capital;

    public Paises() {

    }

    public Paises(String nombre, double PIB, Long poblacion, String capital) {
        this.nombre = nombre;
        this.PIB = PIB;
        this.poblacion = poblacion;
        this.capital = capital;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPIB() {
        return PIB;
    }

    public void setPIB(double pIB) {
        PIB = pIB;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + " | PIB : " + " | Población : " + poblacion + " | Capital : " + capital;
    }
}