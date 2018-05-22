/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MARIO-PC
 */
public class Materia {

    private String codigo;

    private String nombre;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    
    @XmlElement
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ClassPojo [codigo = " + codigo + ", nombre = " + nombre + "]";
    }
}
