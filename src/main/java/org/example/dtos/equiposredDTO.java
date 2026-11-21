package org.example.dtos;

import java.util.Date;

public class equiposredDTO {
    private int id_equipo;
    private String hostname;
    private String tipo;
    private String ip_gestion;
    private String estado;
    private Date fecha_alta;
    private sedesDTO sede;

    public equiposredDTO(){

    }
    public equiposredDTO(int id_equipo, String hostname, String tipo, String ip_gestion
            , String estado, Date fecha_alta, sedesDTO sede) {
        this.setId_equipo(id_equipo);
        this.setHostname(hostname);
        this.setTipo(tipo);
        this.setIp_gestion(ip_gestion);
        this.setEstado(estado);
        this.setFecha_alta(fecha_alta);
        this.setSede(sede);

    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIp_gestion() {
        return ip_gestion;
    }

    public void setIp_gestion(String ip_gestion) {
        this.ip_gestion = ip_gestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public sedesDTO getSede() {
        return sede;
    }

    public void setSede(sedesDTO sede) {
        this.sede = sede;
    }
}
