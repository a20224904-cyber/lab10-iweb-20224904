package org.example.dtos;

public class sedesDTO {
    private int id_sede;
    private String nombre;
    private String ciudad;

    public sedesDTO() {

    }
    public sedesDTO(int id_sede, String nombre, String ciudad) {
        this.setId_sede(id_sede);
        this.setNombre(nombre);
        this.setCiudad(ciudad);
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
