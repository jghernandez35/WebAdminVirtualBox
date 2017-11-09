/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "maquina_virtual")
@XmlRootElement
public class MaquinaVirtual implements Serializable{


    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    private Double usoMemoria;
    private Double usoCpu;
    private Double usoProcesamiento;
    private String usuNombre;
    private String usuIndex;
    private String usu_id;    

    public MaquinaVirtual() {
    }

    public MaquinaVirtual(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoProcesamiento() {
        return usoProcesamiento;
    }

    public void setUsoProcesamiento(Double usoProcesamiento) {
        this.usoProcesamiento = usoProcesamiento;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuIndex() {
        return usuIndex;
    }

    public void setUsuIndex(String usuIndex) {
        this.usuIndex = usuIndex;
    } 

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }


    
    
}
