package com.paparazziteam.go_ono_go.models;

import java.util.Date;

public class User {

    private String nombre;
    private Date fecha;
    private String email;
    private String password;

    public User() {
    }

    public User(String nombre, Date fecha, String email, String password) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
